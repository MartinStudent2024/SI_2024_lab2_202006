package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void everyBranchTest(){

        System.out.println("Every Branch Testing");

        String ITEMS_NULL = "allItems list can't be null!";
        String INVALID_CHARACTER_BARCODE = "Invalid character in item barcode!";
        String NO_BARCODE = "No barcode!";
        int payment = 500;

        List<Item> list1 = null;
        RuntimeException exception;
        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(list1, payment));
        assertTrue(exception.getMessage().contains(ITEMS_NULL));
        // All items list can't be null!

        List<Item> list2 = List.of(
                new Item("Coca-Cola", "123$$56789", 85, 5)
        );
        RuntimeException exception2;
        exception2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(list2, payment));
        assertTrue(exception2.getMessage().contains(INVALID_CHARACTER_BARCODE));
        // Invalid character in item barcode!

        List<Item> list3 = List.of(
                new Item("Fanta", null, 65, 3)
        );
        RuntimeException exception3;
        exception3 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(list3, payment));
        assertTrue(exception3.getMessage().contains(NO_BARCODE));
        // No barcode!

        List<Item> list5 = List.of(new Item("Milkshake", "5555555555", 185, 10));
        assertFalse(SILab2.checkCart(list5, 100));
        // Payment not full
    }

    @Test
    void multipleConditionTest(){

        System.out.println("Multiple Conditions Testing");

        String ITEMS_NULL = "allItems list can't be null!";
        String INVALID_CHARACTER_BARCODE = "Invalid character in item barcode!";
        String NO_BARCODE = "No barcode!";
        int payment = 1000;

        List<Item> list1 = null;
        RuntimeException exception;
        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(list1, payment));
        assertTrue(exception.getMessage().contains(ITEMS_NULL));
        // All items list can't be null!

        List<Item> list2 = List.of(
                new Item("Coca-Cola", "123$$56789", 85, 5)
        );
        RuntimeException exception2;
        exception2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(list2, payment));
        assertTrue(exception2.getMessage().contains(INVALID_CHARACTER_BARCODE));
        // Invalid character in item barcode!

        List<Item> list3 = List.of(
                new Item("Fanta", null, 65, 3));
        RuntimeException exception3 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(list3, payment));
        assertTrue(exception3.getMessage().contains(NO_BARCODE));
        // No barcode!

        List<Item> list5 = List.of(new Item("Milkshake", "5555555555", 185, 10));
        assertFalse(SILab2.checkCart(list5, 100));
        // Payment not full

        List<Item> list4 = List.of(
                new Item("PowerBar", "0124356789", 350, 3), // begin 0
                new Item(null, "5252525252", 100, 10), // unknown name
                new Item("GranolaBar", "1357924680", 77, 0)  // null discount
        );
        assertTrue(SILab2.checkCart(list4, 10000));
        // All conditions met, payment full.

    }
}
