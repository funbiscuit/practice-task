package ru.naumen.practice.task.telegrambot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.naumen.practice.task.telegrambot.entities.ClientOrder;

import java.util.List;


/**
 * Репозиторий сущности "Заказ клиента"
 *
 * @author skokurin
 * @since 20.06.2023
 */
@RepositoryRestResource(path = "clientOrders", collectionResourceRel = "clientOrders")
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long> {
    List<ClientOrder> findByStatus(Integer status);

    List<ClientOrder> findByClientFullName(String fullName);
}