package com.api.cakeShop.Models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cakes")
public class Cakes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Nome não pode estar em branco")
    private String name;

    @Min(value = 0, message = "Preço não pode estar em branco")
    private float price;

    @NotBlank(message = "Descrição não pode estar em branco")
    private String description;

    @OneToOne
    @JoinColumn(name="flavours_id")
    private Flavours flavours;

//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cakes")
//    private Orders orders;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Flavours getFlavours() {
        return flavours;
    }

    public void setFlavours(Flavours flavours) {
        this.flavours = flavours;
    }
}
