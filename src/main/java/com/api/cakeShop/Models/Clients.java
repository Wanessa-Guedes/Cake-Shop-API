package com.api.cakeShop.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Nome não pode estar em branco")
    private String name;

    @NotBlank(message = "Endereço não pode estar em branco")
    private String address;

    @NotBlank(message = "Telefone não pode estar em branco")
    @Size(min = 10, max = 11)
    private String phone;

//    @OneToMany(mappedBy = "clients")
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
