import java.util.ArrayList;
import java.util.Arrays;

public class sorts {  //in-place 原地排序
    /*
    * 插入排序：每次把无序区间的第一个数 在有序区间遍历 插入
    * 选择排序：
    * */





    public static void insertSort(int[] array) {
        //无序区间  [0,i]
        //有序区间  [i+1,array.length]
        //待插入的数据是array[i+1]
        //插入过程中在有序区间内查找
        /*
         * 1.查找 从后往前找
         *
         * 2.插入
         * */
        for (int i = 0; i < array.length - 1; i++) {
            int key = array[i + 1];
            int j;
            for (j = i; j >= 0; j--) {
                if (key >= array[j]) {
                    break;
                }
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }

        //插入排序（减治算法） 最多一共插入 size-1次
        //主要考虑清楚有序和无序区间
        //插入过程：每次把无序区间的第一个数 在有序区间中进行遍历
        //        1.找到合适的位置
        //        2.搬移原有数据 为这个新的数据腾出位置
        // 时间复杂度：最好[完全有序]O（n） 平均O(n^2) 最坏[完全逆序]O(n^2)
        // 插入排序 越接近有序 时间效率越高
        // 空间复杂度:O(1)  稳定
    }

    private  static int[] buildSortedArray(int n){
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=i;
        }
        return array;
    }


    public static void main(String[] args) {
        //有序
        int[] array;
        int[] array1 = {6,5,2,3,7,8,9,1,5};
        int[] array2 = {6,2,5,8,9,6,3,1,4,5};
        int[] array3 = {58,9,6,5,7,4,3,21,5};
        int[] array4={5,6,9,2,3,7,1,4,8,55,66,11,22,33,77};
        array=buildSortedArray(10);
        System.out.println("需要排序的随机数组");
        System.out.println(Arrays.toString(array1));
        long begin=System.nanoTime();//纳秒
        insertSort(array1);
        long end=System.nanoTime();//纳秒
        System.out.println("插入排序所用的时间");
        System.out.println(end-begin);
        System.out.println("插入排序");
        System.out.println(Arrays.toString(array1));
        System.out.println("需要排序的随机数组");
        System.out.println(Arrays.toString(array2));
        System.out.println("希尔排序");
        shellSort(array2);
        System.out.println(Arrays.toString(array2));
        System.out.println("需要排序的随机数组");
        System.out.println(Arrays.toString(array3));
        System.out.println("选择排序");
        selectSort(array3);
        System.out.println(Arrays.toString(array3));
        System.out.println("需要排序的随机数组");
        System.out.println(Arrays.toString(array4));
        System.out.println("堆排序");
        heapSort(array4);
        System.out.println(Arrays.toString(array4));
        //无序
        //随机值
        //完全相等的
    }
    //希尔排序 shell sort  建立在插入排序上
    /* 分组 size=10;
      gap=size
      gap =gap/3+1 第一次分组
      gap=gap/2    第二次分组        当gap=1时就是插排
    *
        //git 权威指南
        /*
         * 希尔排序
         * 前提：利用插入排序中，数据越接近有序 时间效率就越高
         * 再插入排序之间做预排序（分组插排） 是数据尽可能接近有序
         * 如何分组问题
         * 动态分组 ： 一开始很多分组 之后越来越少
         * 时间复杂度： 最好O（n） 平均O（n^1.3-1.4）最坏O（n^2）
         * 空间复杂度：0(1）
         * 稳定性  ：  不稳定  （相等的两个数分到了不同的组里 无法保证）
         * */
        private static void insertWithGap(int[] array,int gap){
            for (int i = 0; i < array.length - gap; i++) {
                int key = array[i + gap];
                int j;
                for (j = i; j >= 0 && key < array[j]; j -= gap) {
                    array[j + gap] = array[j];
                }
                array[j + gap] = key;
            }

        }
        public static void shellSort(int[] array){
            int gap = array.length;
            while(true){
                gap=gap/3+1;
                insertWithGap(array,gap);
                if(gap==1){
                    return;
                }
            }
        }
        /*
        * 选择排序
        * 每次遍历无序空间 （直接遍历） 找到无序区间中最大的数
        * 把最大的数放到无序区间的最后边
        * 一直到数据完全有序
        * */
        //神经网络学和数字信号学
    /*
    * 直接选择排序
    * 时间复杂度 O(n^2)
    * 空间复杂度 O(1)
    * 稳定性  ： 不稳定（有相同的数的时候）
    *
    * */
    public static void selectSort(int[] array){
        //每次找最大的数
        for(int i=0;i<array.length-1;i++){
            //无序区间[0,array.length-i]
            int max=0;
            for(int j=0;j<array.length-i;j++){
                if(array[j]>=array[max]){
                    max=j;
                }
            }
            //有序区间[array.length-i,array.length]

            //交换最大的数和无序区间的最后一个数
            swap(array,max,array.length-i-1);
        }
    }
    public static void swap(int[] array,int i,int j){
           int t=array[i];
           array[i]=array[j];
           array[j]=t;
    }
    /*
    * 堆排序
    * 把无序区间建好一个堆  本质上还是选择排序
    * */
    public static void heapSort(int[] array){
        createHeap(array,array.length);
        for(int i=0;i<array.length-1;i++){
            //无序 [0,array.length-i)
            swap(array,0,array.length-i-1);
            heapify(array,array.length-i-1,0);
        }
    }
    public static void createHeap(int[] array,int size){
        for(int i=(size-2)/2;i>=0;i--){
            heapify(array, array.length, i);
        }
    }
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
    //直接排序进化版
    public static void selectSortVersion2(int[] array){
        int low=0;
        int high=array.length-1;
        while(low<high){

        }

    }
    //冒泡排序
    /*
    * 时间复杂度 最好O(n) 平均O(n^2) 最坏O(n^2)
    * 空间复杂度 O(1)
    *
    */
    public static void bubbleSort(int[] array){
        boolean sorted=true;
        for(int i=0;i<array.length-1;i++){
            for(int j=1;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                    sorted=false;
                }
                if(sorted){
                    return;
                }
            }
        }
    }





    //快速排序(分治算法)
    /*
    * 步骤；
      1,在整个需要排序的区间内 找到以一个基准值
    * 2，遍历整个待排序区间 把所有的数据和基准值进行比较最终达到
    *    比基准值小的（可以包含等于） 在基准值的左边
    *    比基准值大的（可以包含等于）在基准值的右边
    * 3，用同样的方法 处理左右两个小的待排序区间，直到
    *     1.小区间内没有数据了（size=0）
    *     2.小区间已经有序了（size=1）
    *
    * */




   // public static int partition(int[] array,int left,int right){  //step2 分割数组
    //    int pivot=array[right];
    //    int less=left;
     //   int great=right;
    //}
   // public static void quickSortInternal(int[] array,int left,int right){
        //确定基准值 array[right]作为基准值 pivot基准值
       // int pivotIndex=partition(array,left,right);
     //   quickSortInternal(array,left,pivotIndex-1);
     //   quickSortInternal(array,pivotIndex-1,right);

   // }
   // public static void  quickSort(int[] array){
    //    quickSortInternal(array,0,array.length-1);

   // }


    //待排序区间时[low,high)
    public static void mergeSort(int[] array){
        //先求待排序区间的中间下标
        //对左右两个小区间进行归并排序 直到小区间的长度小于等于1
        //执行合并两个有序数组的操作

        mergeSort1(array,0,array.length);



    }
    public static void mergeSort1(int[] array,int low,int high){
        int length=high-low;
        int mid = (low+high)/2;
        if(high<=1+low){
            return;
        }


    }



 }








