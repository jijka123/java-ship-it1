package ru.yandex.practicum.delivery;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParcelBoxTest {
    @Test
    public void testAddParcelPositive() {
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(10);
        StandardParcel standardParcel = new StandardParcel("123", "123", 1, (byte) 1);
        assertTrue(parcelBox.addParcel(standardParcel));
    }
    @Test
    public void testAddParcelBordered() {
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(10);
        StandardParcel standardParcel = new StandardParcel("123", "123", 10, (byte) 1);
        assertTrue(parcelBox.addParcel(standardParcel));
    }
    @Test
    public void testAddParcelNegative() {
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(10);
        StandardParcel standardParcel = new StandardParcel("123", "123", 11, (byte) 1);
        assertFalse(parcelBox.addParcel(standardParcel));
    }
}
