package com.sinhvien.coffee_mobileapp.DTO;

public class OrderDetailDTO {

    int OrderId, DrinkId, Number;

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public int getDrinkId() {
        return DrinkId;
    }

    public void setDrinkId(int drinkId) {
        DrinkId = drinkId;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }
}
