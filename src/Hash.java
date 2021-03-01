import javafx.print.Collation;

import java.util.*;

public class Hash {
    public static void main1(String[] args) {
        //Map<key，value>
        HashMap<String,Integer> map=new HashMap<>();
        //当放入的key相同时，只保存最后一次更新的内容
        //不会根据先后顺序存放
        map.put("al",3);
        map.put("zz",3);
        //map.put("zz",2);
        //get(key)是value的值
        int value=map.get("zz");
        //如果key值不存在可以打印出后面默认的值
        int value2= map.getOrDefault("aa",12);
        System.out.println(value2);//12
        //删除key所对的value值
        //map.remove("zz");
        //打印一个数组，是不重复key的集合
        Set<String> set=map.keySet();
        System.out.println(set);//[zz, al]
        //打印一个数组，是可重复value的集合
        Collection<Integer> map2=map.values();
        System.out.println(map2);//[3, 3]
        System.out.println(map);//{zz=3, al=3}
        //把key和value打印成一个整体相当是一个节点 Map.Entry<String,Integer>是一种类型代表那个节点
        Set<Map.Entry<String,Integer>> set2=map.entrySet();
        for (Map.Entry<String,Integer> entry:set2) {
            //那个节点所对应的getKey()：key和entry.getValue()：value
            System.out.println(entry.getKey()+" "+entry.getValue());//zz 3
                                                                    //al 3
        }
        System.out.println(set2);//[zz=3, al=3]
        boolean a=map.containsKey("zz");
        boolean b=map.containsValue(2);
        System.out.println(a);//true
        System.out.println(b);//false
    }

    public static void main(String[] args) {
        Set<Integer> set=new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(14);
        System.out.println(set);
    }
    //字符串中的第一个唯一字符
    public int firstUniqChar(String s) {
        if(s==null||s.length()==0){
            return -1;
        }
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,(map.getOrDefault(c,0)+1));
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
    //给定两个数组，编写一个函数来计算它们的交集。
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set=new HashSet<>();
            Set<Integer> set2=new HashSet<>();
            if(nums1==null||nums2==null){
                return null;
            }
            for(int i=0;i<nums1.length;i++){
                set.add(nums1[i]);
            }
            for(int j=0;j<nums2.length;j++){
                if(set.contains(nums2[j])){
                    set2.add(nums2[j]);
                }
            }
            int[] res=new int[set2.size()];
            int k=0;
            for(int num:set2){
                res[k]=num;
                k++;
            }
            return res;
    }
    //给定两个字符串 s 和 t，判断它们是否是同构的。一一对应
    //如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
    //每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
    // 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身

        public boolean isIsomorphic(String s, String t) {
            Map<Character,Character> map=new HashMap<>();
            for(int i=0;i<s.length();i++){
                if(!map.containsKey(s.charAt(i))){
                    if(map.containsValue(t.charAt(i))){
                        return false;
                    }
                    map.put(s.charAt(i),t.charAt(i));
                }else{
                    if(map.get(s.charAt(i))!=t.charAt(i)){
                        return false;
                    }
                }
            }
            return true;
    }
    //滑动窗口，最大不重复子串
        public int lengthOfLongestSubstring(String s) {
            if(s==null||s.length()==0){
                return 0;
            }
            int left=0;
            int max=0;
            Map<Character,Integer> map=new HashMap<>();
            for(int i=0;i<s.length();i++){
                if(map.containsKey(s.charAt(i))){
                    left=Math.max(left,map.get(s.charAt(i))+1);
                }
                map.put(s.charAt(i),i);
                max=Math.max(max,i-left+1);
            }
            return max;

    }
    //给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，
    // 同时不在禁用列表中的单词。
    // 分割字符串，空格和标点符号都会分割字符串，因此先把标点符号替换成空格，
    // 然后根据空格分割字符串，之后就是统计每个单词出现的次数，
    // 并找到非banned且出现次数最多的单词
        public String mostCommonWord(String paragraph, String[] banned) {
            Set<String> set=new HashSet<>();
            for(String s:banned){
                set.add(s);
            }
            Map<String,Integer> map=new HashMap<>();
            paragraph=paragraph.replace(","," ").replace("."," ").replace("!", " ").replace("?", " ").replace(";", " ").replace("'", " ");
            //split("\\s+")多个空格
            for(String s : paragraph.split("\\s+")){
                s=s.toLowerCase();
                if(set.contains(s)){
                    continue;
                }
                if(!map.containsKey(s)){
                    map.put(s,1);
                }else{
                    map.put(s,map.get(s)+1);
                }

            }
            int max=0;
            String str="";
            Set<Map.Entry<String,Integer>> set2=map.entrySet();
            for(Map.Entry<String,Integer> entry:set2){
                if(entry.getValue()>max){
                    max=entry.getValue();
                    str=entry.getKey();
                }
            }
            return str;
        }

}


