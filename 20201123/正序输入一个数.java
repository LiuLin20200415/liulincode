import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = n;
        int count = 0;
        while (i/10!= 0) {
            i /= 10;
            count++;
        }
        while(count>=0){
            System.out.println(n/(int)Math.pow(10,count));
            n=n%(int)Math.pow(10,count);
            count--;
        }
    }
}
