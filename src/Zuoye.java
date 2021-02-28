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
    /*
    给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。


    class Solution {
    public String reverseOnlyLetters(String S) {

        int left=0;
        int right=S.length()-1;
        char[] arr=S.toCharArray();
        while(left<right){
            while(!(Character.isLetter(arr[left]))&&left<right){
                left++;
            }
            while(!(Character.isLetter(arr[right]))&&left<right){
                right--;
            }
            char fag=arr[left];
            arr[left]=arr[right];
            arr[right]=fag;
            left++;
            right--;
        }
        return String.valueOf(arr);
    }
}

     */
    /*
    给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
    class Solution {
    public int[] sortArrayByParity(int[] A) {

        if(A==null||A.length==0){
            return null;
        }
        int left=0;
        int right=A.length-1;
        int a=0;
        while(left<=right){
            if(A[left]%2!=0&&A[right]%2==0){
                 a=A[left];
                A[left]=A[right];
                A[right]=a;
            }else if(A[left]%2==0){
                left++;
            }else if(A[right]%2!=0){
                right--;
            }
        }
        return A;
    }
}
     */
    /*
    给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。

数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。

如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。
    class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        int a=0;
        for(int j=0;j<nums.length;j++){
            a=a+nums[j];
            if(sum==a*2-nums[j]){
                return j;
            }
        }
        return -1;
    }
}
     */
    /*

public class Father {
    public void say(){
        System.out.println("father");
    }
    public static void action(){
        System.out.println("爸爸打儿子！");
    }
}
public class Son extends Father{
    public void say() {
        System.out.println("son");
    }
   public static void action(){
        System.out.println("打打！");
    }
    public static void main(String[] args) {
        Father f=new Son();
        f.say();
        f.action();
    }
}
输出：son
           爸爸打儿子！
当调用say方法执行的是Son的方法，也就是重写的say方法
而当调用action方法时，执行的是father的方法。
普通方法，运用的是动态单分配，是根据new的类型确定对象，从而确定调用的方法；
静态方法，运用的是静态多分派，即根据静态类型确定对象，因此不是根据new的类型确定调用的方法
     */
           public static void main(String args[]){
               int num = 10; System.out.println(test(num)); }
               public static int test(int b){
               try {
                   b += 10;
                   return b;
               }
               catch(RuntimeException e){

               }
               catch(Exception e2){ }
       finally{ b += 10; return b; } }
}
/*
 二分法找数字
o(n/2)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[]{-1,-1};
        if(nums==null||nums.length==0){
            return res;
        }
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            if(nums[left]==target&&nums[right]==target){
                res[0]=left;
                res[1]=right;
                return res;
            }else if(nums[left]!=target&&nums[right]==target){
                left++;
            }else if(nums[left]==target&&nums[right]!=target){
                right--;
            }else{
                left++;
                right--;
            }
        }
        return res;
    }
}
O(logn)
class Solution {
    public int find(int[] nums, int target,boolean tOrf) {
        int fag=-1;
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                fag=mid;
                if(tOrf){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return fag;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[]{-1,-1};
        if(nums==null||nums.length==0){
            return res;
        }
        res[0]=find(nums,target,true);
        res[1]=find(nums,target,false);
        return res;
    }
}

/*
1、把功能相似或相关的类或接口组织在同一个包中，方便类的查找和使用。

2、如同文件夹一样，包也采用了树形目录的存储方式。同一个包中的类名字是不同的，不同的包中的类的名字是可以相同的，当同时调用两个不同包中相同类名的类时，应该加上包名加以区别。因此，包可以避免名字冲突。

3、包也限定了访问权限，拥有包访问权限的类才能访问某个包中的类。

　　Java 使用包（package）这种机制是为了防止命名冲突，访问控制，提供搜索和定位类（class）、接口、枚举（enumerations）和注释（annotation）
 */
/*
回文字符串
class Solution {
    public boolean isPalindrome(String s) {
        if(s==null){
            return true;
        }
        s=s.toLowerCase();
        int len=s.length();
        StringBuilder str=new StringBuilder(len);
        for(int i=0;i<len;i++){
            if((s.charAt(i)>='0'&&s.charAt(i)<='9')||(s.charAt(i)>='a'&&s.charAt(i)<='z')){
                str.append(s.charAt(i));
            }
        }
        if(str.toString().equals(str.reverse().toString())){
            return true;
        }
        return false;
    }
}
 */
/*
给定一组字符，使用原地算法将其压缩。压缩后的长度必须始终小于或等于原数组长度。数组的每个元素应该
是长度为1 的字符（不是 int 整数类型）。在完成原地修改输入数组后，返回数组的新长度
class Solution {
    public int compress(char[] chars) {
        if(chars==null||chars.length==0){
            return 0;
        }
        int read=0;
        int string=0;
        int write=0;
        for(read=0;read<chars.length;read++){
            if(read+1==chars.length||chars[read]!=chars[read+1]){
                chars[write]=chars[read];
                write++;
                if(read>string){
                    for(char c:(""+(read-string+1)).toCharArray()){
                        chars[write]=c;
                        write++;
                    }
                }
                string=read+1;
            }
        }
    return write;
    }
}
 */
/*
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr=nums.clone();
        Arrays.sort(arr);
        int start=arr.length;
        int end=0;
        for(int i=0;i<nums.length;i++){
            if(arr[i]!=nums[i]){
               start=Math.min(start,i);
               end=Math.max(end,i);
            }
        }
        return ((end-start)>=0?(end-start+1):0);

    }
}
 */

