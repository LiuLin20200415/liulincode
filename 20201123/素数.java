public class Test {
    public static void main(String[] args) {
        int i=1;
        int j=2;
        for(i=1;i<=100;i++){
            for(j=2;j<=Math.sqrt(i);j++){
                if(i%j==0) {
                    break;
                }
            }
            if(j>Math.sqrt(i)){
                System.out.println(i);
            }
        }
    }

}


