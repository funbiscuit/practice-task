package ru.naumen.practice.task.telegrambot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.naumen.practice.task.telegrambot.entities.Category;


/**
 * Репозиторий сущности "Категория"
 *
 * @author skokurin
 * @since 20.06.2023
 */
@RepositoryRestResource(path = "categories", collectionResourceRel = "categories")
public interface CategoryRepository extends JpaRepository<Category, Long> {
}