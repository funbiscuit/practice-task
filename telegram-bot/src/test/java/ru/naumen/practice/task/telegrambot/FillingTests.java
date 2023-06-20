package ru.naumen.practice.task.telegrambot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.naumen.practice.task.telegrambot.dao.CategoryRepository;
import ru.naumen.practice.task.telegrambot.dao.ClientRepository;
import ru.naumen.practice.task.telegrambot.dao.ProductRepository;
import ru.naumen.practice.task.telegrambot.entities.Category;
import ru.naumen.practice.task.telegrambot.entities.Client;
import ru.naumen.practice.task.telegrambot.entities.Product;

/**
 * @author skokurin
 * @since 20.06.2023
 */
@SpringBootTest
class FillingTests {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void createTwoClients() {
        Client client1 = new Client();
        client1.setAddress("client 1 address");
        client1.setFullName("Client 1 Full Name");
        client1.setExternalId(1L);
        client1.setPhoneNumber("1111111111");
        clientRepository.save(client1);

        Client client2 = new Client();
        client2.setAddress("client 2 address");
        client2.setFullName("Client 2 Full Name");
        client2.setExternalId(2L);
        client2.setPhoneNumber("2222222222");
        clientRepository.save(client2);
    }

    @Test
    void createProductCategories() {
        Category pizzaCategory = createCategory("Пицца", null);
        createProduct("Пицца 1", "Описание пиццы 1", 54.21, pizzaCategory);
        createProduct("Пицца 2", "Описание пиццы 2", 84.20, pizzaCategory);
        createProduct("Пицца 3", "Описание пиццы 3", 46.18, pizzaCategory);

        Category rollCategory = createCategory("Роллы", null);
        Category classicRollCategory = createCategory("Классические роллы", rollCategory);
        createProduct("Классические роллы 1", "Описание классических роллов 1", 121.65, classicRollCategory);
        createProduct("Классические роллы 2", "Описание классических роллов 2", 657.15, classicRollCategory);
        createProduct("Классические роллы 3", "Описание классических роллов 3", 89.43, classicRollCategory);
        Category sweetRollCategory = createCategory("Сладкие роллы", rollCategory);
        createProduct("Сладкие роллы 1", "Описание сладких роллов 1", 45.26, sweetRollCategory);
        createProduct("Сладкие роллы 2", "Описание сладких роллов 2", 98.44, sweetRollCategory);
        createProduct("Сладкие роллы 3", "Описание сладких роллов 3", 47.11, sweetRollCategory);
        Category rollSetCategory = createCategory("Наборы", rollCategory);
        createProduct("Набор роллов 1", "Описание набора роллов 1", 458.14, rollSetCategory);
        createProduct("Набор роллов 2", "Описание набора роллов 2", 958.32, rollSetCategory);
        createProduct("Набор роллов 3", "Описание набора роллов 3", 1120.00, rollSetCategory);
        Category bakedRollCategory = createCategory("Запеченные роллы", rollCategory);
        createProduct("Запеченные роллы 1", "Описание запеченных роллов 1", 142.85, bakedRollCategory);
        createProduct("Запеченные роллы 2", "Описание запеченных роллов 2", 651.16, bakedRollCategory);
        createProduct("Запеченные роллы 3", "Описание запеченных роллов 3", 64.13, bakedRollCategory);

        Category burgerCategory = createCategory("Бургеры", null);
        Category classicBurgerCategory = createCategory("Классические бургеры", burgerCategory);
        createProduct("Классический бургер 1", "Описание классического бургера 1", 142.85, classicBurgerCategory);
        createProduct("Классический бургер 2", "Описание классического бургера 2", 651.16, classicBurgerCategory);
        createProduct("Классический бургер 3", "Описание классического бургера 3", 64.13, classicBurgerCategory);
        Category hotBurgerCategory = createCategory("Острые бургеры", burgerCategory);
        createProduct("Острый бургер 1", "Описание острого бургера 1", 11.66, hotBurgerCategory);
        createProduct("Острый бургер 2", "Описание острого бургера 2", 157.98, hotBurgerCategory);
        createProduct("Острый бургер 3", "Описание острого бургера 3", 364.47, hotBurgerCategory);

        Category drinkCategory = createCategory("Напитки", null);
        Category sparklinkDrinkCategory = createCategory("Газированные напитки", drinkCategory);
        createProduct("Газированный напиток 1", "Описание газированного напитка 1", 3.50, sparklinkDrinkCategory);
        createProduct("Газированный напиток 2", "Описание газированного напитка 2", 6.89, sparklinkDrinkCategory);
        createProduct("Газированный напиток 3", "Описание газированного напитка 3", 12.40, sparklinkDrinkCategory);
        Category energyDrinkCategory = createCategory("Энергетические напитки", drinkCategory);
        createProduct("Энергетический напиток 1", "Описание энергетического напитка 1", 37.50, energyDrinkCategory);
        createProduct("Энергетический напиток 2", "Описание энергетического напитка 2", 67.89, energyDrinkCategory);
        createProduct("Энергетический напиток 3", "Описание энергетического напитка 3", 127.40, energyDrinkCategory);
        Category JuiceCategory = createCategory("Соки", drinkCategory);
        createProduct("Сок 1", "Описание сока 1", 137.50, JuiceCategory);
        createProduct("Сок 2", "Описание сока 2", 167.89, JuiceCategory);
        createProduct("Сок 3", "Описание сока 3", 227.40, JuiceCategory);
        Category otherDrinkCategory = createCategory("Другие", drinkCategory);
        createProduct("Другой напиток 1", "Описание другого напитка 1", 337.50, otherDrinkCategory);
        createProduct("Другой напиток 2", "Описание другого напитка 2", 367.89, otherDrinkCategory);
        createProduct("Другой напиток 3", "Описание другого напитка 3", 427.40, otherDrinkCategory);
    }

    private void createProduct(String name, String description, double price, Category category) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategory(category);
        productRepository.save(product);
    }

    private Category createCategory(String name, Category parent) {
        Category category = new Category();
        category.setName(name);
        category.setParent(parent);
        categoryRepository.save(category);
        return category;
    }
}
