import java.util.Arrays;
import java.util.Stack;

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
    //当数据有序时，为了避免时间复杂度O(n^2)，三数去中法。
    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
    }
    public static void quick(int[] array,int low,int high){
        if(array.length<50){
            insertSortqurt(array,low,high);
        }
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
    //随机选取基准法（就是随机找到后面的一个下标然后和low下表的数据进行交换，
    // 最后以low下标交换后的值作为基准
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
        if(array[mid]>array[high]) {
            int tmp = array[mid];
            array[mid] = array[high];
            array[high] = tmp;
        }
    }
    //快排优化
    //当快速排序在一直执行的过程中，数据肯定会趋于有序，使用插入排序进行优化，插入排序是越有序月快
    public static void insertSortqurt(int[] array,int low,int high) {
        for (int i = low+1; i <= high; i++) {
            int tmp=array[i];
            int j = i-1;
            for (; j>=low ; j--) {
                if(array[j]>tmp){
                    array[j+1]=array[j];
                }else{
                    break;
                }
            }
            array[j+1]=tmp;
        }
    }
    //非递归快排
    //O(nlogn)
    //O(n) O(logn)
    //分治思想
    public static void quickSort2(int[] array){
        Stack<Integer> stack=new Stack<>();
        int low=0;
        int high=array.length-1;
        int piv=pivot(array,low,high);
        if(piv>low+1){
            stack.push(low);
            stack.push(piv-1);
        }
        if(piv<high-1){
            stack.push(piv+1);
            stack.push(high);
        }
        while(!stack.isEmpty()){
            high=stack.pop();
            low=stack.pop();
            piv=pivot(array,low,high);
            if(piv>low+1){
                stack.push(low);
                stack.push(piv-1);
            }
            if(piv<high-1){
                stack.push(piv+1);
                stack.push(high);
            }
        }
    }
    //归并排序
    //稳定
    //O(nlogn)
    //O(n)
    public static void merge(int[] array,int start,int mid,int end){
        int s1=start;
        int s2=mid+1;
        int[] tmp=new int[end-start+1];
        int k=0;
        while (s1<=mid&&s2<=end){
            if(array[s1]<=array[s2]){
                tmp[k++]=array[s1++];
            }else{
                tmp[k++]=array[s2++];
            }
        }
        while(s1<=mid){
            tmp[k++]=array[s1++];
        }
        while (s2<=end){
            tmp[k++]=array[s2++];
        }
        for (int i = 0; i < tmp.length; i++) {
            array[i+start]=tmp[i];
        }
    }
    public static void mergeSortInternal(int[] array,int low,int high){
        //拆分
        if(low>=high){
            return;
        }
        int mid=low+(high-low)/2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid+1,high);
        //合并
        merge(array,low,mid,high);
    }
    public static void mergeSort(int[] array){
        mergeSortInternal(array,0,array.length-1);
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
        quickSort2(array);
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));

    }
}
