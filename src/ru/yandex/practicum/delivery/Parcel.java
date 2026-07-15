package ru.yandex.practicum.delivery;
public abstract class Parcel {
    String description;
    String deliveryAddress;
    int weight;
    byte sendDay;
    static final int COST = 2;
    Parcel(String description, String deliveryAddress, int weight, byte sendDay) {
        this.description = description;
        this.deliveryAddress = deliveryAddress;
        this.weight = weight;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> упакована");
    }
    public void deliver() {
        System.out.println("Посылка <<" + description + ">> доставлена по адресу " + deliveryAddress);
    }
    public abstract int getCost();
    public int calculateDeliveryCost() {
        return getCost() * weight;
    }
}
