package ru.naumen.practice.task.telegrambot.entities;

import javax.persistence.*;

/**
 * Сущность "Заказ клиента"
 *
 * @author skokurin
 * @since 20.06.2023
 */
@Entity
public class ClientOrder {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private Client client;

    @Column(nullable = false)
    private Integer status;

    @Column(nullable = false)
    private Double total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}