package ru.naumen.practice.task.telegrambot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.naumen.practice.task.telegrambot.entities.Product;
import ru.naumen.practice.task.telegrambot.service.ProductService;

import java.util.List;

/**
 * @author skokurin
 * @since 20.06.2023
 */
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/search")
    public List<Product> searchProducts(@RequestParam(required = false) Long categoryId,
                                        @RequestParam(required = false) String name) {
        if (categoryId != null) {
            return productService.getProductsByCategoryId(categoryId);
        } else if (name != null) {
            return productService.searchProductsByName(name);
        } else {
            throw new IllegalArgumentException("categoryId or name is required");
        }
    }

    @GetMapping(value = "/popular")
    public List<Product> getPopularProducts(@RequestParam int limit) {
        return productService.getTopPopularProducts(limit);
    }
}
