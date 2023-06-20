package ru.naumen.practice.task.telegrambot.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.naumen.practice.task.telegrambot.dao.CategoryRepository;
import ru.naumen.practice.task.telegrambot.dao.ProductRepository;
import ru.naumen.practice.task.telegrambot.entities.Category;
import ru.naumen.practice.task.telegrambot.entities.Product;

import java.util.List;

/**
 * @author skokurin
 * @since 20.06.2023
 */
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getProductsByCategoryId(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category == null) {
            return List.of();
        }
        Product exampleProduct = new Product();
        exampleProduct.setCategory(category);
        return productRepository.findAll(Example.of(exampleProduct));
    }

    @Override
    public List<Product> getTopPopularProducts(int limit) {
        return productRepository.getTopPopular(PageRequest.of(0, limit));
    }

    @Override
    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameLike(name);
    }
}
