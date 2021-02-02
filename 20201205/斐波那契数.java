//迭代
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(fib(num));
    }

    public static int fib(int num) {
        int last3=0;
            int last1 = 1;
            int last2 = 1;
            for (int i = 3; i <= num; i++) {
                last3 = last1 + last2;
                last2=last1;
                last1=last3;

            }
        return last3;
    }
}
//递归
public class Test{
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int num=scanner.nextInt();
        System.out.println(fib(num));
    }
    public static int fib(int num){
        if(num==1||num==2){
            return 1;
        }
        return fib(num-1)+fib(num-2);
    }
}