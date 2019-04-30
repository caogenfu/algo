package AlgoOfSort;


/**
 * 数组的一些排序算法
 *
 * @author GAIA
 * @create 2019-04-28-14:32
 */
public class ArraySort {

    /**
     * 冒泡排序算法
     *
     * @param array
     * @param isReverse
     */
    public void bubbleSort(int[] array, boolean isReverse) {
        int length = array.length;
        int temp;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((!isReverse && array[i] < array[j]) || isReverse && array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序算法
     *
     * @param array
     * @param isReverse
     */
    public void selectSort(int[] array, boolean isReverse) {
        int length = array.length;
        int temp = 0, min = 0;
        for (int i = 0; i < length; i++) {
            min = i;
            for (int j = i; j < length; j++) {
                if ((!isReverse && array[min] > array[j]) || (isReverse && array[min] < array[j]))
                    min = j;
            }
            if (i != min) {
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    /**
     * 插入排序算法
     *
     * @param array
     * @param isReverse
     */
    public void insertSort(int[] array, boolean isReverse) {
        int length = array.length;
        int temp = 0;
        int j;
        for (int i = 1; i < length; i++) {
            temp = array[i];
            j = i;
            if (isReverse) {
                while (j > 0 && temp > array[j - 1]) {
                    array[j] = array[j - 1];
                    j--;
                }
            } else {
                while (j > 0 && temp < array[j - 1]) {
                    array[j] = array[j - 1];
                    j--;
                }
            }
            array[j] = temp;
        }
    }

    /**
     * 快速排序算法
     *
     * @param array
     * @param isReverse 是否逆序
     */
    public void quickSort(int[] array, boolean isReverse) {
        quickSort(array, 0, array.length - 1, isReverse);
    }

    /**
     * 快速排序算法，对从left到right下标之间的元素进行快速排序
     *
     * @param array
     * @param left
     * @param right
     * @param isReverse
     */
    public void quickSort(int[] array, int left, int right, boolean isReverse) {
        if (right <= left) {
            return;
        } else {
            int partition = partitionIt(array, left, right, isReverse);
            quickSort(array, left, partition - 1, isReverse);
            quickSort(array, partition + 1, right, isReverse);
        }
    }

    /**
     * 返回基准值最后在数组中的位置
     *
     * @param array
     * @param left
     * @param right
     * @param isReverse
     * @return
     */
    private int partitionIt(int[] array, int left, int right, boolean isReverse) {
        int i = left;
        int j = right + 1;
        //选取基准元素
        int pivot = array[left];
        int temp;
        while (true) {
            if (isReverse) {
                while (i < right && array[++i] > pivot) {
                }
                while (j > 0 && array[--j] < pivot) {
                }
            } else {
                while (i < right && array[++i] < pivot) {
                }
                while (j > 0 && array[--j] > pivot) {
                }
            }
            if (i >= j) {
                break;
            } else {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        temp = array[left];
        array[left] = array[j];
        array[j] = temp;
        return j;
    }

    /**
     * 归并排序算法
     * @param array
     * @param start
     * @param last
     * @param isReverse
     */
    public void mergeSort(int[] array,int start, int last,boolean isReverse){
        if(last > start){
            int mid = start + (last - start) / 2;
            mergeSort(array,start,mid,isReverse);
            mergeSort(array,mid+1,last,isReverse);
            merge(array,start,mid,last,isReverse);
        }
    }

    /**
     * 将mid两边已排序好的数组归并成一个有序数组
     * @param array
     * @param start
     * @param mid
     * @param last
     * @param isReverse
     */
    private void merge(int[] array, int start, int mid, int last, boolean isReverse) {
        int[] temp = new int[last - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= last){
            if((isReverse && array[i] > array[j]) || (!isReverse && array[i] < array[j])){
                temp[k++] = array[i++];
            }else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid){
            temp[k++] = array[i++];
        }
        while (j <= last){
            temp[k++] = array[j++];
        }
        int length = last - start + 1;
        for (i = 0; i < length; i++) {
            array[i + start] = temp[i];
        }
    }

    /**
     * 希尔排序算法
     * @param array
     * @param isReverse
     */
    public void shellKnuthSort(int[] array,boolean isReverse){
        int step = 1;
        int length = array.length;
        while (step < length / 3){
            step = step * 3 + 1;
        }
        while(step > 0){
            for (int i = step; i < length; i++) {
                int temp = array[i];
                int j = i;
                while (j > step - 1 && ((!isReverse && temp < array[j - step]) || (isReverse && temp > array[j - step]))){
                    array[j] = array[j - step];
                    j -= step;
                }
                array[j] = temp;
            }
            step = (step - 1) / 3;
        }
    }


}
