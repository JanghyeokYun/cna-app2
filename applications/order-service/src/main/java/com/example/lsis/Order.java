package com.example.lsis;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    private Long id;
    private Long customerId;


    public Order(Long id, Long customerId) {
        this.id = id;
        this.customerId = customerId;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                '}';
    }
}
