public class Zuoye {
    /*
    class Solution {
    public String toLowerCase(String str) {
        if(str==null||str.length()==0){
            return null;
        }
        StringBuilder string =new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='A'&&str.charAt(i)<='Z'){
                string.append((char)(str.charAt(i)+32));
            }else{
            string.append(str.charAt(i));
            }
        }
        return string.toString();
    }
}
     */
    /*数组逆置
    class Solution {
    public void reverse(int[] nums,int begin,int end){
        while(begin<end){
            int tmp=nums[begin];
            nums[begin]=nums[end];
            nums[end]=tmp;
            begin++;
            end--;
        }

    }
    public void rotate(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return;
        }
        if(k<=0){
            return;
        }
        k=k%nums.length;
        reverse(nums,0,nums.length-1-k);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }
}*/
    /*public static void mystery (int x) {
        System.out.print(x % 10);
        if ((x / 10) != 0){
            mystery(x / 10);
        }
        System.out.print(x % 10);
    }
    public static void main(String[] args) {
            mystery(1234);
    }

    public static void main1(String[] args) {
        int x=20, y=5;
        System.out.println(x+y +""+(x+y)+y);
    }*/
}
