package se.me0nly.jaktia0.data.dao;
import se.me0nly.jaktia0.model.Hunter;

import java.util.Collection;

public interface HunterDao {

    //CRUD

    Hunter persist(Hunter hunter);

    Hunter findById(String id);
    Collection<Hunter> findAll();
    Collection<Hunter> findByNameContainsIgnoreCase(String name);
    Hunter findByEmail(String email);

    Hunter update(Hunter hunter);

    void remove(Hunter hunter);

}
