package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

    @Test
    void testAverageIndexOfEvenElements() {
        // Тестовий масив
        int[] array = {10, 15, 20, 25, 30};

        double expected = 2.0;

        // Виклик методу
        double result = ArrayUtils.averageIndexOfEvenElements(array);

        // Перевірка результату
        assertEquals(expected, result, 0.0001, "Середнє арифметичне індексів парних елементів обчислено некоректно.");
    }
}
