package ru.yandex.practicum.delivery;
import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    List<T> box = new ArrayList<>();
    int maxWeight;
    int currentWeight = 0;
    ParcelBox(int maxWeight){
        this.maxWeight = maxWeight;
    }

    public boolean addParcel(T parcel) {
        if (maxWeight >= (currentWeight + parcel.weight)) {
            box.add(parcel);
            currentWeight += parcel.weight;
            return true;
        } else {
            System.out.println("Вес посылок превышает допустимый вес данной коробки, посылка не была добавлена");
            return false;
        }
    }
    public List<T> getAllParcels() {
        return box;
    }
}