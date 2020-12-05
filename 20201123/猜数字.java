import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        int count=3;
        while (count > 0) {
            count--;
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            int num = (int) Math.random() % 100 + 1;
            if (a == num) {
                System.out.println("猜对了");
                break;
            } else if (a > num) {
                System.out.println("猜大了");
                System.out.printf("还有%d次机会\n",count);
            } else {
                System.out.println("猜小了");
                System.out.printf("还有%d次机会\n",count);
            }

        }
    }


}
