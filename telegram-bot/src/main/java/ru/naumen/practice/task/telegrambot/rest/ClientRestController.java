package ru.naumen.practice.task.telegrambot.rest;

import org.springframework.web.bind.annotation.*;
import ru.naumen.practice.task.telegrambot.entities.Client;
import ru.naumen.practice.task.telegrambot.entities.ClientOrder;
import ru.naumen.practice.task.telegrambot.entities.Product;
import ru.naumen.practice.task.telegrambot.service.ClientService;

import java.util.List;

/**
 * @author skokurin
 * @since 20.06.2023
 */
@RestController
@RequestMapping("/rest/clients")
public class ClientRestController {
    private final ClientService clientService;

    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/{id}/orders")
    public List<ClientOrder> getClientOrders(@PathVariable Long id) {
        return clientService.getClientOrders(id);
    }

    @GetMapping(value = "/{id}/products")
    public List<Product> getClientProducts(@PathVariable Long id) {
        return clientService.getClientProducts(id);
    }

    @GetMapping(value = "/search")
    public List<Client> searchClients(@RequestParam String name) {
        return clientService.searchClientsByName(name);
    }
}
