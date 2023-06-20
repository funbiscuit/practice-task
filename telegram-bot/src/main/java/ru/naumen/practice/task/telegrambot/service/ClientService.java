package ru.naumen.practice.task.telegrambot.service;

import ru.naumen.practice.task.telegrambot.entities.Client;
import ru.naumen.practice.task.telegrambot.entities.ClientOrder;
import ru.naumen.practice.task.telegrambot.entities.Product;

import java.util.List;


/**
 * Сервис для работы с клиентами телеграмм-бота
 *
 * @author skokurin
 * @since 20.06.2023
 */
public interface ClientService {
    /**
     * Получить список заказов клиента
     *
     * @param id идентификатор клиента
     */
    List<ClientOrder> getClientOrders(Long id);

    /**
     * Получить список всех товаров во всех заказах клиента
     *
     * @param id идентификатор клиента
     */
    List<Product> getClientProducts(Long id);

    /**
     * Найти всех клиентов по подстроке имени
     *
     * @param name подстрока имени клиента
     */
    default List<Client> searchClientsByName(String name) {
        throw new UnsupportedOperationException("Доп. задание");
    }
}
