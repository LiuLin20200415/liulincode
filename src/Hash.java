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

}
