package ru.naumen.practice.task.telegrambot.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
    @Query("from Product where id in ("
            + "select product.id from OrderProduct "
            + "where clientOrder.client.id = :clientId)")
    List<Product> getAllProductsOrderedByClient(Long clientId);

    @Query("select o.product from OrderProduct as o "
            + "group by o.product.id "
            + "order by sum(o.countProduct) desc")
    List<Product> getTopPopular(Pageable pageable);

    @Query("from Product p where lower(p.name) like lower(concat('%', concat(:name, '%')))")
    List<Product> findByNameLike(String name);
}