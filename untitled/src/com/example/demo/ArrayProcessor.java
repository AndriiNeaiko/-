package com.example.demo;

import java.util.Random;
import java.util.Scanner;

public class ArrayProcessor {

    // Ручний ввід масиву
    public static int[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість елементів масиву: ");
        int size = scanner.nextInt();
        if (size <= 0) {
            throw new IllegalArgumentException("Розмір масиву має бути додатним.");
        }
        int[] array = new int[size];
        System.out.println("Введіть елементи масиву (цілі числа):");
        for (int i = 0; i < size; i++) {
            System.out.print("Елемент " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    // Автоматична генерація масиву
    public static int[] generateArray(int size, int minVal, int maxVal) {
        if (size <= 0) {
            throw new IllegalArgumentException("Розмір масиву має бути додатним.");
        }
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxVal - minVal + 1) + minVal;
        }
        return array;
    }

    // Знаходження суми від’ємних елементів
    public static int sumNegativeElements(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім.");
        }
        int sum = 0;
        for (int num : array) {
            if (num < 0) {
                sum += num;
            }
        }
        return sum;
    }

    // Знаходження добутку елементів між максимальним і мінімальним
    public static int productBetweenMinMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім.");
        }
        int minIndex = 0, maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        if (minIndex > maxIndex) {
            int temp = minIndex;
            minIndex = maxIndex;
            maxIndex = temp;
        }
        if (maxIndex - minIndex <= 1) {
            throw new IllegalArgumentException("Немає елементів між мінімальним і максимальним.");
        }
        int product = 1;
        for (int i = minIndex + 1; i < maxIndex; i++) {
            product *= array[i];
        }
        return product;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Вибір способу заповнення
            System.out.println("Оберіть спосіб заповнення масиву:");
            System.out.println("1 - Ручне заповнення");
            System.out.println("2 - Автоматичне заповнення");
            System.out.print("Ваш вибір: ");
            int choice = scanner.nextInt();

            int[] array;
            if (choice == 1) {
                // Ручне заповнення
                array = inputArray();
            } else if (choice == 2) {
                // Автоматичне заповнення
                System.out.print("Введіть кількість елементів масиву: ");
                int size = scanner.nextInt();
                array = generateArray(size, -100, 100);
            } else {
                throw new IllegalArgumentException("Неправильний вибір. Введіть 1 або 2.");
            }

            // Вивід масиву
            System.out.println("Масив:");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();

            // Обчислення суми від’ємних елементів
            int sumNegatives = sumNegativeElements(array);
            System.out.println("Сума від'ємних елементів: " + sumNegatives);

            // Обчислення добутку між мінімальним і максимальним
            int product = productBetweenMinMax(array);
            System.out.println("Добуток елементів між мінімальним і максимальним: " + product);

        } catch (IllegalArgumentException e) {
            // Обробка виключних ситуацій (некоректні дані)
            System.err.println("Помилка: " + e.getMessage());
        } catch (Exception e) {
            // Загальна обробка несподіваних помилок
            System.err.println("Сталася непередбачувана помилка: " + e.getMessage());
        }
    }
}
