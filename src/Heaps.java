import java.util.Arrays;
public class Heaps {
    //结点个数是n时间复杂度 O(log(n))
    /*
     * array 被看作堆的数组
     * size 数组中被看作堆的值的个数
     * index 调整下标位置
     ******* 除了index和他的孩子之外 其他位置已经满足堆的性质
     ******* 经过向下调整最终成为一个堆
     * */
    public static void heapify(int[] array, int size, int index) {
        while (true) {
            int left = 2 * index + 1;
            if (left >= size) {
                return;
            }
            //只有左孩子 肯定是左孩子大
            //左右都有判断哪个大 就跟哪个换
            int max = left;
            if (left + 1 < size && array[left + 1] > array[left]) {
                max = left + 1;
            }
            if (array[index] >= array[max]) {
                return;
            }
            swap(array, index, max);
            index = max;
        }
    }
    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
    public static void createHeap(int[] array, int size) { //建堆的时间复杂度是0(n*log(n))
        for (int i = (size - 2) / 2; i >= 0; i--) {
            heapify(array, array.length, i);
        }
    }
    public static void adjustUp(int[] array, int size, int index) {
        while (true) {
            if (index == 0) {
                return;
            }

            int pareant = (index - 1) / 2;
            if (array[pareant] >= array[index]) {
                return;
            }
            swap(array, array[pareant], array[index]);

            index = pareant;
        }
    }
    public static void main(String[] args) {
        int[] array = {-1, 8, 4, 6, 7, 2, 3, 1, 0};
        heapify(array, array.length, 0);
        System.out.println(Arrays.toString(array));
        int[] array1 = {3, 5, 2, 4, 9, 0, 1, 9, 8, 4, 7, 2, 3, 8, 6, 3};
        createHeap(array1, array1.length);
        System.out.println(Arrays.toString(array1));
    }
}
