package com.api.cakeShop.Models;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Min(value = 1, message = "Quantidade precisa ser maior do que 1")
    @Max(value = 4, message = "Quantidade precisa ser menor ou igual a 4")
    private int quantity;

    private Timestamp createdAt;

    private float totalPrice;

    @Column(columnDefinition = "boolean default false")
    private boolean isDelivered = false;

    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Clients clients;

    @ManyToOne
    @JoinColumn(name = "cakes_id")
    private Cakes cakes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getDelivered() {
        return isDelivered;
    }

    public void setDelivered(Boolean delivered) {
        isDelivered = delivered;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    public Cakes getCakes() {
        return cakes;
    }

    public void setCakes(Cakes cakes) {
        this.cakes = cakes;
    }

}
