package se.me0nly.jaktia0.data.repository;
import org.springframework.data.repository.CrudRepository;
import se.me0nly.jaktia0.model.Product;

import java.math.BigDecimal;
import java.util.Collection;


public interface ProductRepository extends CrudRepository<Product, String> {


    //Query Creation for methods
    Collection<Product> findAllByProductNameContainsIgnoreCase(String productName);

    Collection<Product> findAllByProductPrice(BigDecimal price);

}
