package org.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest {

    //ќценка вли€ни€ четности/нечетности элементов (максимального, минимального и недостающего)
    @Test
    public void findMissingNumber_parityOfMembers() {
        int[] array1 = {1,2,3,5,6,7};
        assertEquals(4, Main.findMissingNumber(array1));
        int[] array2 = {1,2,3,5,6};
        assertEquals(4, Main.findMissingNumber(array2));
        int[] array3 = {1,2,4,5,6,7};
        assertEquals(3, Main.findMissingNumber(array3));
        int[] array4 = {1,2,4,5,6};
        assertEquals(3, Main.findMissingNumber(array4));
        int[] array5 = {2,3,5,6,7};
        assertEquals(4, Main.findMissingNumber(array5));
        int[] array6 = {2,3,5,6,7,8};
        assertEquals(4, Main.findMissingNumber(array6));
        int[] array7 = {2,3,4,6,7};
        assertEquals(5, Main.findMissingNumber(array7));
        int[] array8 = {2,3,4,6,7,8};
        assertEquals(5, Main.findMissingNumber(array8));
    }

    //ќценка вли€ни€ присутстви€ нул€
    @Test
    public void findMissingNumber_containingZero() {
        int[] array1 = {0,1,2,3,5,6,7};
        assertEquals(4, Main.findMissingNumber(array1));
        int[] array2 = {0,1,2,3,5,6};
        assertEquals(4, Main.findMissingNumber(array2));
        int[] array3 = {0,2,3,4,5,6,7};
        assertEquals(1, Main.findMissingNumber(array3));
        int[] array4 = {0,2,3,4,5,6};
        assertEquals(1, Main.findMissingNumber(array4));
    }

    //ќценка вли€ни€ смещени€ диапазона
    @Test
    public void findMissingNumber_differentArrangementOfMembers() {
        int[] array1 = {4,6,7,8,9,10};
        assertEquals(5, Main.findMissingNumber(array1));
        int[] array2 = {0,1,2,3,4,6};
        assertEquals(5, Main.findMissingNumber(array2));
        int[] array3 = {2,3,4,6,7,8};
        assertEquals(5, Main.findMissingNumber(array3));
    }

}