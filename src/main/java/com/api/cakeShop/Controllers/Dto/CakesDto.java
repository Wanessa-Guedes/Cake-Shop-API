package com.api.cakeShop.Controllers.Dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CakesDto {

    @NotBlank(message = "Nome não pode estar em branco")
    private String name;

    @Min(value = 0, message = "Preço não pode estar em branco")
    private float price;

    @NotBlank(message = "Descrição não pode estar em branco")
    private String description;

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
}
