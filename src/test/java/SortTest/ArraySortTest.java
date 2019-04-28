package SortTest;

import AlgoOfSort.ArraySort;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 测试排序代码
 *
 * @author GAIA
 * @create 2019-04-28-14:51
 */
public class ArraySortTest {
    @Test
    public void bubbleSortTest() {
        int[] array = new Random().ints(20, 0, 100).toArray();
        ArraySort arraySort = new ArraySort();
        arraySort.bubbleSort(array, false);
        System.out.println("正序排序:\r\n");
        System.out.println(Arrays.toString(array));
        arraySort.bubbleSort(array, true);
        System.out.println("逆序排序:\r\n");
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void selectSortTest() {
        int[] array = new Random().ints(20, 0, 100).toArray();
        ArraySort arraySort = new ArraySort();
        arraySort.selectSort(array, false);
        System.out.println("正序排序:\r\n");
        System.out.println(Arrays.toString(array));
        arraySort.selectSort(array, true);
        System.out.println("逆序排序:\r\n");
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void insertSortTest() {
        int[] array = new Random().ints(20, 0, 100).toArray();
        ArraySort arraySort = new ArraySort();
        arraySort.insertSort(array, false);
        System.out.println("正序排序:\r\n");
        System.out.println(Arrays.toString(array));
        arraySort.insertSort(array, true);
        System.out.println("逆序排序:\r\n");
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void quickSortTest() {
        int[] array = new Random().ints(20, 0, 100).toArray();
        ArraySort arraySort = new ArraySort();
        arraySort.quickSort(array, false);
        System.out.println("正序排序:\r\n");
        System.out.println(Arrays.toString(array));
        arraySort.quickSort(array, true);
        System.out.println("逆序排序:\r\n");
        System.out.println(Arrays.toString(array));
    }
}
