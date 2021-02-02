public class Test {
    public static void main(String[] args) {
        int[] arr={1,2,4,5,23,0,3};
        bubbleSort( arr);
        System.out.println(Arrays.toString(arr) );
    }

    public static void  bubbleSort(int[] arr) {
        for (int i =0; i <arr.length-1; i++) {
               boolean flg=false;
            for(int j=0;j<arr.length-1-i;j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1]=temp;
                    flg=true;
                }
            }
            if(flg==false){
                return;
            }
        }
    }
}