package ru.naumen.practice.task.telegrambot.service;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.naumen.practice.task.telegrambot.dao.ClientOrderRepository;
import ru.naumen.practice.task.telegrambot.dao.ClientRepository;
import ru.naumen.practice.task.telegrambot.dao.ProductRepository;
import ru.naumen.practice.task.telegrambot.entities.Client;
import ru.naumen.practice.task.telegrambot.entities.ClientOrder;
import ru.naumen.practice.task.telegrambot.entities.Product;

import java.util.List;

/**
 * @author skokurin
 * @since 20.06.2023
 */
@Service
public class ClientServiceImpl implements ClientService {
    private final ProductRepository productRepository;
    private final ClientOrderRepository clientOrderRepository;
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ProductRepository productRepository,
                             ClientOrderRepository clientOrderRepository,
                             ClientRepository clientRepository) {
        this.productRepository = productRepository;
        this.clientOrderRepository = clientOrderRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientOrder> getClientOrders(Long id) {
        ClientOrder exampleOrder = new ClientOrder();
        exampleOrder.setClient(clientRepository.findById(id).orElseThrow());
        return clientOrderRepository.findAll(Example.of(exampleOrder));
    }

    @Override
    public List<Product> getClientProducts(Long id) {
        return productRepository.getAllProductsOrderedByClient(id);
    }

    @Override
    public List<Client> searchClientsByName(String name) {
        return clientRepository.findByNameLike(name);
    }
}
