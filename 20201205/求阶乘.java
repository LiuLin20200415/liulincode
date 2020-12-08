//递归
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(fun(num));
    }

    public static int fun(int num) {
        if (num == 0||num==1) {
            return 1;
        }
        return num*fun(num-1);
    }
}
//循环
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(fun(num));
    }

    public static int fun(int num) {
        int sum = 0;
        if (num == 0||num==1) {
            return 1;
        }
        for (int i = 1; i <=num; i++) {
            int a = 1;
            for (int j = i; j > 0; j--) {
                a = a * j;
            }
            sum = sum + a;
        }
        return sum;
    }
}


