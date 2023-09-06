package org.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest {

    //Оценка влияния четности/нечетности элементов (максимального, минимального и недостающего)
    @Test
    public void findMissingNumber_parityOfMembers() {
        int[] array1 = {1,2,3,5,6,7};
        assertEquals("4", Main.findMissingNumber(array1));
        int[] array2 = {1,2,3,5,6};
        assertEquals("4", Main.findMissingNumber(array2));
        int[] array3 = {1,2,4,5,6,7};
        assertEquals("3", Main.findMissingNumber(array3));
        int[] array4 = {1,2,4,5,6};
        assertEquals("3", Main.findMissingNumber(array4));
        int[] array5 = {2,3,5,6,7};
        assertEquals("4", Main.findMissingNumber(array5));
        int[] array6 = {2,3,5,6,7,8};
        assertEquals("4", Main.findMissingNumber(array6));
        int[] array7 = {2,3,4,6,7};
        assertEquals("5", Main.findMissingNumber(array7));
        int[] array8 = {2,3,4,6,7,8};
        assertEquals("5", Main.findMissingNumber(array8));
    }

    //Оценка влияния присутствия нуля
    @Test
    public void findMissingNumber_containingZero() {
        int[] array1 = {0,1,2,3,5,6,7};
        assertEquals("4", Main.findMissingNumber(array1));
        int[] array2 = {0,1,2,3,5,6};
        assertEquals("4", Main.findMissingNumber(array2));
        int[] array3 = {0,2,3,4,5,6,7};
        assertEquals("1", Main.findMissingNumber(array3));
        int[] array4 = {0,2,3,4,5,6};
        assertEquals("1", Main.findMissingNumber(array4));
    }

    //Оценка влияния смещения диапазона
    @Test
    public void findMissingNumber_differentArrangementOfMembers() {
        int[] array1 = {4,6,7,8,9,10};
        assertEquals("5", Main.findMissingNumber(array1));
        int[] array2 = {0,1,2,3,4,6};
        assertEquals("5", Main.findMissingNumber(array2));
        int[] array3 = {2,3,4,6,7,8};
        assertEquals("5", Main.findMissingNumber(array3));
    }

    // Проверка на отсутствие пропущенного числа
    @Test
    public void findMissingNumber_noMissingNumber() {
        int[] array1 = {5,6,7,8,9};
        assertEquals(Main.EXCEPTION_NOT_ONE_MISSING_NUMBER, Main.findMissingNumber(array1));
        int[] array2 = {4,5};
        assertEquals(Main.EXCEPTION_NOT_ONE_MISSING_NUMBER, Main.findMissingNumber(array2));
        int[] array3 = {0,1};
        assertEquals(Main.EXCEPTION_NOT_ONE_MISSING_NUMBER, Main.findMissingNumber(array3));
        int[] array5 = {0,1,2,3};
        assertEquals(Main.EXCEPTION_NOT_ONE_MISSING_NUMBER, Main.findMissingNumber(array5));
    }

    // Проверка на несколько пропущенных чисел
    @Test
    public void findMissingNumber_moreThanTwoMissingNumber() {
        int[] array1 = {5,6,9,10};
        assertEquals(Main.EXCEPTION_NOT_ONE_MISSING_NUMBER, Main.findMissingNumber(array1));
        int[] array2 = {4,6,7,9};
        assertEquals(Main.EXCEPTION_NOT_ONE_MISSING_NUMBER, Main.findMissingNumber(array2));
        int[] array3 = {0,1,4,5};
        assertEquals(Main.EXCEPTION_NOT_ONE_MISSING_NUMBER, Main.findMissingNumber(array3));
        int[] array4 = {0,2,4};
        assertEquals(Main.EXCEPTION_NOT_ONE_MISSING_NUMBER, Main.findMissingNumber(array4));
        int[] array5 = {0,3};
        assertEquals(Main.EXCEPTION_NOT_ONE_MISSING_NUMBER, Main.findMissingNumber(array5));
        int[] array6 = {5,8};
        assertEquals(Main.EXCEPTION_NOT_ONE_MISSING_NUMBER, Main.findMissingNumber(array6));
    }

    // Проверка на неуникальные члены ряда
    @Test
    public void findMissingNumber_duplicateMembers() {
        int[] array1 = {4,5,6,6,8,9};
        assertEquals(Main.EXCEPTION_DUPLICATE, Main.findMissingNumber(array1));
        int[] array2 = {4,5,6,6,7,8,9};
        assertEquals(Main.EXCEPTION_DUPLICATE, Main.findMissingNumber(array2));
        int[] array3 = {5,5,6,7,8,9};
        assertEquals(Main.EXCEPTION_DUPLICATE, Main.findMissingNumber(array3));
        int[] array4 = {5,5,7,8,9};
        assertEquals(Main.EXCEPTION_DUPLICATE, Main.findMissingNumber(array4));
        int[] array5 = {6,7,8,9,9};
        assertEquals(Main.EXCEPTION_DUPLICATE, Main.findMissingNumber(array5));
        int[] array6 = {6,7,9,9};
        assertEquals(Main.EXCEPTION_DUPLICATE, Main.findMissingNumber(array6));
        int[] array7 = {4,4};
        assertEquals(Main.EXCEPTION_DUPLICATE, Main.findMissingNumber(array7));
        int[] array8 = {0,0};
        assertEquals(Main.EXCEPTION_DUPLICATE, Main.findMissingNumber(array8));
        int[] array9 = {0,0,1,2};
        assertEquals(Main.EXCEPTION_DUPLICATE, Main.findMissingNumber(array9));
        int[] array10 = {0,0,2};
        assertEquals(Main.EXCEPTION_DUPLICATE, Main.findMissingNumber(array10));
    }

}