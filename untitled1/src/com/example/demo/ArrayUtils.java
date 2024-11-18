package com.example.demo;

import java.util.Random;
import java.util.Scanner;

public class ArrayUtils {

    // Підпрограма для обчислення середнього арифметичного індексів парних елементів
    public static double averageIndexOfEvenElements(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім.");
        }

        int sumIndexes = 0;
        int countEven = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                sumIndexes += i;
                countEven++;
            }
        }

        if (countEven == 0) {
            throw new IllegalArgumentException("У масиві немає парних елементів.");
        }

        return (double) sumIndexes / countEven;
    }

    // Метод для автоматичної генерації масиву
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Меню для вибору способу заповнення масиву
            System.out.println("Оберіть спосіб заповнення масиву:");
            System.out.println("1 - Ручне заповнення");
            System.out.println("2 - Автоматичне заповнення");
            System.out.print("Ваш вибір: ");
            int choice = scanner.nextInt();

            int[] array;

            if (choice == 1) {
                // Ручне заповнення масиву
                System.out.print("Введіть кількість елементів масиву: ");
                int size = scanner.nextInt();
                if (size <= 0) {
                    throw new IllegalArgumentException("Розмір масиву має бути додатним.");
                }

                array = new int[size];
                System.out.println("Введіть елементи масиву:");
                for (int i = 0; i < size; i++) {
                    System.out.print("Елемент " + (i + 1) + ": ");
                    array[i] = scanner.nextInt();
                }
            } else if (choice == 2) {
                // Автоматичне заповнення масиву
                System.out.print("Введіть кількість елементів масиву: ");
                int size = scanner.nextInt();
                if (size <= 0) {
                    throw new IllegalArgumentException("Розмір масиву має бути додатним.");
                }

                array = generateArray(size, -100, 100); // Генеруємо числа в діапазоні [-100, 100]
                System.out.println("Автоматично згенерований масив:");
                for (int num : array) {
                    System.out.print(num + " ");
                }
                System.out.println();
            } else {
                throw new IllegalArgumentException("Неправильний вибір. Введіть 1 або 2.");
            }

            // Виклик функції для обчислення середнього арифметичного
            double averageIndex = averageIndexOfEvenElements(array);
            System.out.println("Середнє арифметичне індексів парних елементів: " + averageIndex);

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Сталася непередбачувана помилка: " + e.getMessage());
        }
    }
}
