public class Test {
    public static void main(String[] args) {
        int[] arr={1,1,2,2,3};
        System.out.println(find(arr));
    }
    public static int find(int[] arr){
        int ret=0;
        for (int i = 0; i < arr.length ; i++) {
            ret=ret^arr[i];
        }
        return ret;
    }
}
