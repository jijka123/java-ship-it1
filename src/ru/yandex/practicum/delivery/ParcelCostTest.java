package ru.yandex.practicum.delivery;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParcelCostTest {
    @Test
    public void testStandardParcelCost(){
        StandardParcel standardParcel = new StandardParcel("132", "123", 10, (byte) 1);
        assertEquals(standardParcel.calculateDeliveryCost(), 20);
    }
    @Test
    public void testPerishableParcelCost(){
        PerishableParcel perishableParcel = new PerishableParcel("132", "123", 10, (byte) 1,10);
        assertEquals(perishableParcel.calculateDeliveryCost(), 30);
    }
    @Test
    public void testFragileParcelCost(){
        FragileParcel fragileParcel = new FragileParcel("132", "123", 10, (byte) 1);
        assertEquals(fragileParcel.calculateDeliveryCost(), 40);
    }
}