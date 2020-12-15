import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(toString(arr));
    }

    public static String toString(int[] arr) {
        if (arr == null) {
            return "\""+"[]"+"\"";
        } else {
            String ret = "\""+"[";
            for (int i = 0; i < arr.length; i++) {
                if (i < arr.length - 1) {
                    ret = ret + arr[i] + ",";
                } else {
                    ret = ret + arr[i];
                }
            }
            return ret + "]"+"\"";
        }

    }
}

