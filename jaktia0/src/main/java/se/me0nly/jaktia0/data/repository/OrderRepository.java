/* NOT IN USE!!! but think over...

package se.me0nly.jaktia0.data.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.me0nly.jaktia0.model.Order;
import java.util.Collection;

public interface OrderRepository extends CrudRepository<Order, String> {

    @Query("SELECT o FROM Order o JOIN FETCH o.orderItems AS item WHERE UPPER(item.product.productName) = UPPER(:name)")
    Collection<Order> findOrderByProductName(@Param("name") String name);

    Collection<Order> findOrderByOrderItems_Product_ProductName(String name);



    @Query("SELECT o FROM Order o JOIN FETCH o.orderItems AS item WHERE item.product.productName IN (:productName)")
    Collection<Order> findOrdersByProductName(@Param("productName") Collection<String> productNames);

    Collection<Order> findOrderByOrderItemsProductProductNameIn(Collection<String> names); // PIKE - Green, PIKE - Blue, PIKE - Pink

}

NOT IN USE!!! but think over...
 */
