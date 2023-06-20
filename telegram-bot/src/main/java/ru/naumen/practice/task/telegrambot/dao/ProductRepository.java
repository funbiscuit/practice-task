package ru.naumen.practice.task.telegrambot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.naumen.practice.task.telegrambot.entities.Product;

import java.util.List;


/**
 * Репозиторий сущности "Товар"
 *
 * @author skokurin
 * @since 20.06.2023
 */
@RepositoryRestResource(path = "products", collectionResourceRel = "products")
public interface ProductRepository extends JpaRepository<Product, Long> {
    String GET_ALL_PRODUCT_QUERY = "from Product where id in ("
            + "select product.id from OrderProduct where clientOrder.client.id = :clientId)";
    String GET_TOP_POPULAR_QUERY = "select o.product from OrderProduct as o group by o.product.id order by "
            + "sum(o.countProduct) desc";

    @Query(GET_ALL_PRODUCT_QUERY)
    List<Product> getAllProductsOrderedByClient(@Param("clientId") Long clientId);

    @Query(GET_TOP_POPULAR_QUERY)
    List<Product> getTopPopular();

    Product findByName(String name);

    Product getByName(String name);

    List<Product> findByCategoryId(Long id);
}