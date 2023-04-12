package se.me0nly.jaktia0.data.dao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.me0nly.jaktia0.model.Hunter;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class HunterDaoJPAImpl implements HunterDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Hunter persist(Hunter hunter) {
        entityManager.persist(hunter);
        return hunter;
    }

    @Override
    public Hunter findById(String id) {
        return entityManager.find(Hunter.class, id);
    }

    @Override
    public Collection<Hunter> findAll() {
        return entityManager.createQuery("SELECT c FROM Hunter c", Hunter.class).getResultList();
    }

    @Override
    public Collection<Hunter> findByNameContainsIgnoreCase(String name) {

        return entityManager.createQuery(
                        "SELECT c FROM Hunter c WHERE UPPER(c.firstName) LIKE UPPER(CONCAT('%',:name,'%')) " +
                                "OR " +
                                "UPPER(c.lastName) LIKE UPPER(CONCAT('%', :name, '%')) ", Hunter.class)
                .setParameter("name", name)
                .getResultList();

    }

    @Override
    public Hunter findByEmail(String email) {
        return entityManager.createQuery("SELECT c FROM Hunter c WHERE c.email = :email", Hunter.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst().orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Hunter update(Hunter hunter) {
        return entityManager.merge(hunter);
    }

    @Override
    public void remove(Hunter hunter) {
        entityManager.remove(hunter);
    }
}
