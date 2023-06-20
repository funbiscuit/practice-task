package ru.naumen.practice.task.telegrambot.entities;

import javax.persistence.*;

/**
 * Сущность "Категория товара"
 *
 * @author skokurin
 * @since 20.06.2023
 */
@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    @ManyToOne
    private Category parent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}