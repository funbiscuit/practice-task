package ru.naumen.practice.task.telegrambot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.naumen.practice.task.telegrambot.entities.Client;


/**
 * Репозиторий сущности "Клиент"
 *
 * @author skokurin
 * @since 20.06.2023
 */
@RepositoryRestResource(path = "clients", collectionResourceRel = "clients")
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findFirstByFullName(String fullName);
}