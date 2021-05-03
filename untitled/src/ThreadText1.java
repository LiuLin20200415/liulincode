public class ThreadText1 {
    private static int count=0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    count++;
                }
            }
        });
        thread.start();
        thread.join();
        System.out.println(count);
    }
}
