package ru.yandex.practicum.delivery;
public class FragileParcel extends Parcel implements Trackable{
    static final int COST = 4;
    FragileParcel(String description, String deliveryAddress, int weight, byte sendDay) {
        super(description, deliveryAddress, weight, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> обёрнута в защитную плёнку");
        System.out.println("Посылка <<" + description + ">> упакована");
    }
    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <<" + description + ">> изменила местоположение на " + newLocation );
    }
    public int getCost() {
        return COST;
    }
}
