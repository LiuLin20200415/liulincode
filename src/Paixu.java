import java.util.Arrays;

public class Paixu {
    //直接插入
    //最坏O(n^2)
    //当数据有序时最好O(n)，所以越有序越快
    //稳定
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int tmp=array[i];
            int j=i-1;
            for (; j >=0 ; j--) {
                if(tmp<array[j]){
                    array[j+1]=array[j];
                }else{
                    break;
                }
            }
            array[j+1]=tmp;
        }
    }
    //希尔排序
    //时间O(n^1.3)
    //空间O(1)
    //不稳定
    public  static void shellSort(int[] array){
        int[] drr={5,3,1};
        for (int i = 0; i <drr.length ; i++) {
            shell(array,drr[i]);
        }
    }
    public static void shell(int[] array,int gap){
        for (int i = 0; i <array.length ; i++) {
            int tmp = array[i];
            int j = i-gap;
            for (; j >= 0 ; j=j-gap) {
                    if(array[j]>tmp){
                        array[j+gap]=array[j];
                    }else {
                        break;
                    }
            }
            array[j+gap]=tmp;
        }
    }
    //选择排序
    //时间O(n^2)
    //空间O(1)
    //不稳定
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j <array.length ; j++) {
                if(array[j]<array[i]){
                    int tmp=array[i];
                    array[i]=array[j];
                    array[j]=tmp;
                }
            }
        }
    }
    //堆排序
    //时间O(nlogn)
    //空间O(1)
    //不稳定
    public static void heapSort(int[] array){
        for (int i =(array.length-1-1)/2 ; i >=0 ; i--) {
            adjustDown(array,i);
        }
    }
    public  static void adjustDown(int[] array,int parent){
        int chile=2*parent+1;
        while(chile<array.length){
            if(chile+1<array.length&&array[chile+1]<array[chile]){
                chile++;
            }
            if(array[parent]>array[chile]){
                int tmp=array[parent];
                array[parent]=array[chile];
                array[chile]=tmp;
            }else {
                break;
            }
        }
    }
    //冒泡排序
    //O(n^2)
    //O(1)
    //稳定
    public static void bubbleSort(int[] array) {
        for (int i = 0; i <array.length ; i++) {
            boolean fag=true;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    fag=false;
                }
            }
            if(fag){
                return;
            }
        }
    }
    //快速排序
    //时间O(nlogn)
    //空间O(logn)
    //不稳定
    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
    }
    public static void quick(int[] array,int low,int high){
        if(low<high) {
            medianOfThree(array,low,high);
            int piv = pivot(array, low, high);
            quick(array, low, piv - 1);
            quick(array, piv + 1, high);
        }
    }
    public static int pivot(int[] array,int start,int end){
        int tmp=array[start];
        while(start<end){
            while(start<end&&array[end]>=tmp){
                end--;
            }
                array[start] = array[end];
            while(start<end&&array[start]<=tmp){
                start++;
            }
                array[end] = array[start];
        }
        array[start]=tmp;
        return start;
    }
    //快速排序优化
    //随机选取基准法（就是随机找到后面的一个下标然后和low下表的数据进行交换，最后以low下标交换后的值作为基准
    //三数取中法
    public static void medianOfThree(int[] array,int low,int high){
        int mid=(low+high)/2;
        //array[mid]<=array[low]<=array[high]
        if(array[low]<array[mid]){
            int tmp=array[low];
            array[low]=array[mid];
            array[mid]=tmp;
        }
        if(array[low]>array[high]){
            int tmp=array[low];
            array[low]=array[high];
            array[high]=tmp;
        }
        if(array[mid]>array[high]){
            int tmp=array[mid];
            array[mid]=array[high];
            array[high]=tmp;
        }

    }
    public static void main(String[] args) {
        int[] array={10,3,2,7,19,78,65,127};
        System.out.println(Arrays.toString(array));
        selectSort(array);
        System.out.println(Arrays.toString(array));
        shellSort(array);
        System.out.println(Arrays.toString(array));
        heapSort(array);
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
