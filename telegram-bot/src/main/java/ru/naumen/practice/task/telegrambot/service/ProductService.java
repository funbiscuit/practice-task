package ru.naumen.practice.task.telegrambot.service;

import ru.naumen.practice.task.telegrambot.entities.Product;

import java.util.List;


/**
 * Сервис для работы с продуктами телеграмм-бота
 *
 * @author skokurin
 * @since 20.06.2023
 */
public interface ProductService {
    /**
     * Получить список товаров в категории
     *
     * @param id идентификатор категории
     */
    List<Product> getProductsByCategoryId(Long id);

    /**
     * Получить указанное кол-во самых популярных (наибольшее
     * количество штук в заказах) товаров среди клиентов
     *
     * @param limit максимальное кол-во товаров
     */
    List<Product> getTopPopularProducts(int limit);

    /**
     * Найти все продукты по подстроке названия
     *
     * @param name подстрока названия продукта
     */
    default List<Product> searchProductsByName(String name) {
        throw new UnsupportedOperationException("Доп. задание");
    }
}
