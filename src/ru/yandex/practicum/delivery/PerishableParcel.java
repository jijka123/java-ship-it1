package ru.yandex.practicum.delivery;
public class PerishableParcel extends Parcel{
    int timeToLive;
    static final int COST = 3;
    PerishableParcel(String description, String deliveryAddress, int weight, byte sendDay, int timeToLive) {
        super(description, deliveryAddress, weight, sendDay);
        this.timeToLive = timeToLive;
    }
    public Boolean isExpired(int currentDay) {
        return sendDay + timeToLive < currentDay;
    }
    @Override
    public int getCost() {
        return COST;
    }
}
