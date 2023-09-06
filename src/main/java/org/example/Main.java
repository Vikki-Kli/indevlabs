package org.example;

import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static final String EXCEPTION_DUPLICATE = "В вашем ряде содержатся дубликаты";
    public static final String EXCEPTION_NOT_ONE_MISSING_NUMBER = "В вашем ряде должно быть одно пропущенное число";
    /*
    Для поиска буду использовать формулу суммы любой натуральной последовательности: среднее арифметическое самого
    малого и самого большого чисел, умноженное на количество чисел последовательности. То, насколько реальная сумма
    чисел в массиве будет меньше ожидаемой, подскажет, какого числа не хватает.

    Метод работает исходя из условий, что входной массив состоит только из натуральных чисел, имеет лишь один пропуск и
    все числа умещаются в диапазон int.
    */
    public static String findMissingNumber(int[] array) {
        /*
        Из условий ясно, что ряд чисел может начинаться не с 0, следовательно, нужно найти, с какого же числа он
        начинается и каким заканчивается. Сортировки всех видов займут больше времени, чем просто поиск максимума и
        минимума, поэтому их не рассматриваем. Дальше есть три варианта работы: с чистым массивом, с коллекцией или со
        стримом. Коллекция позволит нам сэкономить во времени, но может работать только с объектами (Integer против int),
        что затратно по памяти. Массив же может работать с примитивами, но обяжет вручную перебрать все объекты, чтобы
        найти максимум и минимум, а также их сумму. IntStream же позволит нам работать с примитивами и имеет все
        необходимые методы.
         */
        IntSummaryStatistics stats = IntStream.of(array).distinct().summaryStatistics();
        int count = (int)stats.getCount();

        // Проверка корректности ряда 1
        if (count != array.length) return EXCEPTION_DUPLICATE;

        //Для читаемости кода заведем несколько переменных для важных элементов расчета
        int max = stats.getMax();
        int min = stats.getMin();

        // Проверка корректности ряда 2
        if (max - min != array.length) return EXCEPTION_NOT_ONE_MISSING_NUMBER;

        count++; //Добавляю 1, т.к. количество чисел на одно меньше, чем должно быть
        long sum = stats.getSum();
        long expectedSum = (max + min) * count / 2;
        int missingNumber = (int)(expectedSum - sum);

        return String.valueOf(missingNumber);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size;

        // Проверка на корректный ввод количества элементов будущего массива
        while (true) {
            try {
                size = Integer.parseInt(scan.next());
                if (size < 2) throw new RuntimeException();
                break;
            }
            catch (Exception e) {
                System.out.println("Необходимо ввести целое число не меньше 2");
            }
        }

        int[] array = new int[size];

        // Проверка на корректный ввод элементов массива
        for (int i = 0; i < size; i++) {
            while (true) {
                try {
                    array[i] = Integer.parseInt(scan.next());
                    if (array[i] < 0) throw new RuntimeException();
                    break;
                }
                catch (Exception e) {
                    System.out.println("Необходимо ввести целое неотрицательное число");
                }
            }
        }

        System.out.println(findMissingNumber(array));
    }
}
