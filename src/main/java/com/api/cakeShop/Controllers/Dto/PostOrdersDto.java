package com.api.cakeShop.Controllers.Dto;

public class PostOrdersDto {

    private long clientId;

    private long cakeId;

    private int quantity;

    private float totalPrice;

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getCakeId() {
        return cakeId;
    }

    public void setCakeId(long cakeId) {
        this.cakeId = cakeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
