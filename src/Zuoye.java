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
    /*
    字典计数法（哈希策略）
    class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote==null&&magazine==null){
            return false;
        }
        int[] fag=new int[26];
        for(int i=0;i<magazine.length();i++){
            fag[magazine.charAt(i)-'a']++;
        }
        for(int j=0;j<ransomNote.length();j++){
            fag[ransomNote.charAt(j)-'a']--;
            if(fag[ransomNote.charAt(j)-'a']<0){
                return false;
            }
        }
        return true;
    }
}
     */
    /*
    回文数字
    class Solution {
    public boolean isPalindrome(int x) {
        int z=x;
        if(x<0){
            return false;
        }
        int a=0;
        if(x>0&&x<10){
            return true;
        }
        while(x!=0){
          a=a*10+x%10;
          x=x/10;
        }
        if(a==z){
            return true;
        }
        return false;
    }
}
     */
    /*
    final 关键字
    final修饰的成员变量为基本数据类型，在赋值之后无法改变。
    当final修饰的成员变量为引用数据类型时，在赋值后其指向地址无法改变，但是对象内容还是可以改变的。
    final修饰的成员变量在赋值时可以有三种方式。
    1、在声明时直接赋值。2、在构造器中赋值。3、在初始代码块中进行赋值。
    final修饰的方法，不允许被子类覆盖。
    final修饰的类，不能被继承。
     */
    /*
    A：该方法是抽象方法，所以没有方法体，和题目中的method()方法构成了方法重载（方法名一致，参数不一致）
    B：类体中只能定义变量和方法，不能有其他语句
    C：方法和类中的方法重复，所以会发生编译异常
    D：该项方法有abstract修饰，所以是抽象方法，由于抽象方法不能有方法体
     */
    /*

    class Solution {
    public int lengthOfLastWord(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        String[] str=s.split(" ");
        return str.length==0?0:str[str.length-1].length();
    }
}
     */
    /*
    给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

    初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
    你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。

    class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1==null&&nums2==null){
            return;
        }
        int len=nums1.length;
        while(n>0&&m>0){
            len=len-1;
            if(nums1[m-1]<=nums2[n-1]){
                nums1[len]=nums2[n-1];
                n--;
            }else{
                nums1[len]=nums1[m-1];
                m--;
            }
        }
        while(n>0){
            len=len-1;
            nums1[len]=nums2[n-1];
            n--;
        }
        while(m>0){
            len=len-1;
            nums1[len]=nums1[m-1];
            m--;
        }

    }
}
     */

       /* String str=new String("hello");
        char[]ch={'a','b'};
        public static void main(String args[]){
            Zuoye ex=new Zuoye();
            ex.change(ex.str,ex.ch);
            System.out.print(ex.str+" and ");
            System.out.print(ex.ch);
        }
        public void change(String str,char ch[]){
            str="test ok"; ch[0]='c';
        }
        //hello and cb
        */
           /*private float f = 1.0f;
           int m = 12;
           static int n = 1;
       public static void main (String args[]) {
           Zuoye t = new Zuoye();

       } }
            */
    /*
    给定一个整数数组，判断是否存在重复元素
    class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null||nums.length<2){
            return false;
        }
        Set<Integer> map=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(map.contains(nums[i])){
                return true;
            }
            map.add(nums[i]);
        }
        return false;
    }
}
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null||nums.length<2){
            return false;
        }
        Arrays.sort(nums);
        int j=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[j]){
                return true;
            }
            j++;
        }
        return false;
    }
}
/*
你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。

你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name==null||typed==null){
            return false;
        }
        int i=name.length();
        int j=typed.length();
        if(i>j){
            return false;
        }
        i=0;
        j=0;
        while(i<name.length()&&j<typed.length()){
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }else if(j>0&&typed.charAt(j)==typed.charAt(j-1)){
                j++;
            }else{
                return false;
            }
        }
        while(j<typed.length()){
            if(typed.charAt(j)!=name.charAt(name.length()-1)){
                return false;
            }
            j++;
        }
        return i==name.length();

    }
}
     */

}


