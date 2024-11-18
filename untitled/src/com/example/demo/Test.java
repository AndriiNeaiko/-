package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayProcessorTest {

    @Test
    void testSumNegativeElements() {
        int[] array = {-3, 5, -7, 2, -1, 8};
        int expectedSum = -3 + -7 + -1;
        assertEquals(expectedSum, ArrayProcessor.sumNegativeElements(array),
                "Сума від'ємних елементів розрахована некоректно");
    }

    @Test
    void testProductBetweenMinMax() {
        int[] array = {2, 3, -5, 4, -1, 6};
        // Мінімальний елемент (-5) на позиції 2, максимальний (6) на позиції 5
        // Елементи між ними: 4, -1
        int expectedProduct = 4 * -1;
        assertEquals(expectedProduct, ArrayProcessor.productBetweenMinMax(array),
                "Добуток елементів між мінімальним і максимальним розраховано некоректно");
    }
}
