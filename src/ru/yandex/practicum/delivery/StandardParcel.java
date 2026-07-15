package ru.yandex.practicum.delivery;
public class StandardParcel extends Parcel{
    StandardParcel(String description, String deliveryAddress, int weight, byte sendDay) {
        super(description, deliveryAddress, weight, sendDay);
    }
    public int getCost() {
        return COST;
    }
}
