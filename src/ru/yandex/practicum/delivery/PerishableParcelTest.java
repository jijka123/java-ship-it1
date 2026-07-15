package ru.yandex.practicum.delivery;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PerishableParcelTest {
    PerishableParcel perishableParcel = new PerishableParcel("123", "123", 10, (byte) 3, 3);

    @Test
    public void testIsExpired(){
        assertTrue(perishableParcel.isExpired(10));
    }
    @Test
    public void testIsNotExpired() {
        assertFalse(perishableParcel.isExpired(1));
    }
    @Test
    public void testIsNotExpiredBordered(){
        assertFalse(perishableParcel.isExpired(3));
    }
}
