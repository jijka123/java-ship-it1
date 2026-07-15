package ru.yandex.practicum.delivery;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackable = new ArrayList<>();
    private static ParcelBox<StandardParcel> standartParcelBox = new ParcelBox<>(15);
    private static ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(10);
    private static ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(5);
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatus();
                    break;
                case 5:
                    showBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Показать статус посылки");
        System.out.println("5 - Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Введите описание посылки");
        String description = scanner.nextLine();
        System.out.println("Введите адресс");
        String adress = scanner.nextLine();
        System.out.println("Введите вес посылки");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите дату отправки");
        byte sendDay = Byte.parseByte(scanner.nextLine());
        System.out.println("Выберите тип посылки");
        System.out.println("1 - обычная");
        System.out.println("2 - скоропортящаяся");
        System.out.println("3 - хрупкая");
        int parcelChoice = Integer.parseInt(scanner.nextLine());
        switch (parcelChoice) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(description, adress, weight, sendDay);
                if (standartParcelBox.addParcel(standardParcel)) {
                    allParcels.add(standardParcel);
                }
                break;
            case 2:
                System.out.println("Введите время жизни продукта с момента отправки");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(description, adress, weight, sendDay, timeToLive);
                if (perishableParcelBox.addParcel(perishableParcel)) {
                    allParcels.add(perishableParcel);
                }
                break;
            case 3:
                FragileParcel fragileParcel = new FragileParcel(description, adress, weight, sendDay);
                if (fragileParcelBox.addParcel(fragileParcel)) {
                    allParcels.add(fragileParcel);
                    trackable.add(fragileParcel);
                }
                break;
        }
    }

    private static void sendParcels() {
        for (Parcel p : allParcels) {
            p.packageItem();
            p.deliver();
        }
        allParcels.clear();
    }

    private static void calculateCosts() {
        int sum = 0;
        for (Parcel p : allParcels) {
            sum += p.calculateDeliveryCost();
        }
        System.out.println(sum);
    }
    private static void reportStatus() {
        String location;
        for (Trackable t : trackable) {
            System.out.println("Введите локацию");
            location = scanner.nextLine();
            t.reportStatus(location);
        }
    }
    private static void showBox() {
        System.out.println("Выберите коробку");
        System.out.println("1 - стандартные");
        System.out.println("2 - скоропортящиеся");
        System.out.println("3 - хрупкие");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                for(Parcel parcel : standartParcelBox.getAllParcels()){
                    System.out.println(parcel.description);
                }
                break;
            case 2:
                for(Parcel parcel : perishableParcelBox.getAllParcels()){
                    System.out.println(parcel.description);
                }
                break;
            case 3:
                for(Parcel parcel : fragileParcelBox.getAllParcels()){
                    System.out.println(parcel.description);
                }
                break;
        }
    }


}
