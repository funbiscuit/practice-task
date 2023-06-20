package ru.naumen.practice.task.telegrambot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.naumen.practice.task.telegrambot.entities.Client;

import java.util.List;


/**
 * Репозиторий сущности "Клиент"
 *
 * @author skokurin
 * @since 20.06.2023
 */
@RepositoryRestResource(path = "clients", collectionResourceRel = "clients")
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("from Client c where lower(c.fullName) like lower(concat('%', concat(:name, '%')))")
    List<Client> findByNameLike(String name);
}