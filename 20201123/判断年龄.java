import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        if(a<18){
            System.out.println("少年");
        }
        else if(a>18&&a<29){
            System.out.println("青年");
        }
        else if(a>29&&a<55){
            System.out.println("中年");
        }

        else if(a>55){
            System.out.println("老年");
        }

    }

}


