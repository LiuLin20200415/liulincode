
public class Test {
    public static void main(String[] args) {
        int[] arr={1,2,4,5,23,0,3};
        System.out.println(select( arr,5));
    }

    public static int  select(int[] arr,int key) {
        int left=0;
        int right=arr.length-1;
        Arrays.sort(arr);
        while(left<=right){
            int mid=(left+right)/2;
                if (arr[mid] > key) {
                    right=mid-1;
                }
                else if (arr[mid] < key) {
                    left = mid + 1;
                }
                else{
                    return mid;
                }
        }
        return -1;
    }
}