package ru.naumen.practice.task.telegrambot.entities;

import javax.persistence.*;

/**
 * Сущность "Заказ-товар", связывающая заказы с товарами отношением многие ко многим
 *
 * @author skokurin
 * @since 20.06.2023
 */
@Entity
public class OrderProduct {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private ClientOrder clientOrder;

    @ManyToOne(optional = false)
    private Product product;

    @Column(nullable = false)
    private Integer countProduct;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientOrder getClientOrder() {
        return clientOrder;
    }

    public void setClientOrder(ClientOrder clientOrder) {
        this.clientOrder = clientOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(Integer countProduct) {
        this.countProduct = countProduct;
    }
}