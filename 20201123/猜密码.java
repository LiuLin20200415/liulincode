import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        int count=3;
        while (count > 0) {
            count--;
            Scanner scanner = new Scanner(System.in);
            String a = scanner.nextLine();
            String num="liulin";
            if (a.equals(num)==true){
                System.out.println("登陆成功");
                break;
            } else if (a.equals(num)==false) {
                System.out.println("密码错误");
                System.out.printf("还有%d次机会\n",count);
            }

        }
    }


}
