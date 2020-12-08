public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        print(num);
    }

    public static void print(int num) {
        if(num>9){
            print(num/10);
        }
        System.out.println(num%10);
    }
}