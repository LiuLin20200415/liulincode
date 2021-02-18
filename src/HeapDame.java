import java.util.*;
public class HeapDame {
    public int[] elem;
    public int usedSize;
    public HeapDame(){
        this.elem=new int[10];
    }
    /*
    是因为每棵树的下标都不可能超过usedSize
     */
    public void adjustDown(int parent,int len){
        int child=2*parent+1;
        //child<len说明有左孩子
        while(child<len){
            //child+1<len当前是否有右孩子
            if(child+1<len&&elem[child]<elem[child+1]){
                child++;
            }
            //说明此时child对应的左右孩子的值最大
            if(elem[parent]<elem[child]){
                int tmp=elem[parent];
                elem[parent]=elem[child];
                elem[child]=tmp;
                parent=child;
                child=2*parent+1;
            }else{
                //因为从最后一棵树开始调整的
                //说明下面所有数据都已经调整好没有必要继续循环，直接跳出
                break;
            }
        }
    }
    public void createBigHeap(int[] array){
        for (int i = 0; i <array.length; i++) {
            this.elem[i]=array[i];
            this.usedSize++;
        }
        //elem中已经存放了元素
        //开始遍历每一棵子树,向下调整每一棵子树
        //O(nlog(n))
        for (int i = (this.usedSize-1-1)/2; i <=0; i--) {
            adjustDown(i,usedSize);
        }
    }
    //向上调整
    public void adjustUp(int child){
        int parent=(child-1)/2;
        while(child>0){
            if(this.elem[child]>this.elem[parent]){
                int tmp=elem[parent];
                elem[parent]=elem[child];
                elem[child]=tmp;
                child=parent;
                parent=(child-1)/2;
            }else {
                break;
            }
        }
    }
    //如果满了进行扩容，把加入的元素放到usedSize，usedSize++，在进行向上调整
    public void push(int val){
        if(isFull()){
            this.elem=Arrays.copyOf(this.elem,this.elem.length*2);
        }
        this.elem[this.usedSize]=val;
        this.usedSize++;
        adjustUp(this.usedSize-1);
    }
    public boolean isFull(){
        return usedSize==this.elem.length;
    }
    //把树顶元素跟最后一个元素交换，去除交换后的最后一个元素（usedSize--），开始从0下标向下调整树
    public int poll(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        int ret=elem[0];
        int tmp=this.elem[0];
        this.elem[0]=this.elem[this.usedSize-1];
        this.elem[this.usedSize-1]=tmp;
        this.usedSize--;
        adjustDown(0,usedSize);
        return ret;
    }
    public boolean isEmpty(){
        return this.usedSize==0;
    }
    //topK问题前K个最大的元素
    public static void topK(int[] array,int k){
        //1.大小为K的小堆
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        //2.遍历数组
        for (int i = 0; i <array.length ; i++) {
            if(minHeap.size()<k){
                minHeap.offer(array[i]);
            }else{
                int top=minHeap.peek();
                if(array[i]>top){
                    minHeap.poll();
                    minHeap.offer(array[i]);
                }
            }
        }
        for (int i = 0; i <k ; i++) {
            System.out.println(minHeap.poll());
        }
    }
    //topK问题前K个最小的元素
    public static void topK2(int[] array,int k){
        //先建立一个大小为K的大堆
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //遍历数组
        for (int j = 0; j <array.length ; j++) {
            if(maxHeap.size()<k){
                maxHeap.offer(array[j]);
            }else{
                Integer top=maxHeap.peek();
                if(top!=null) {
                    if (array[j] < top) {
                        maxHeap.poll();
                        maxHeap.offer(array[j]);
                    }
                }
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.println(maxHeap.poll());
        }
    }
    /*
    找到和最小的 k 对数字
    class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 大顶堆逆序
        Queue<int[]> maxHeap = new PriorityQueue<>(k, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return getSum(o2) - getSum(o1);
            }
        });

        for(int i = 0 ; i < nums1.length ; i ++){
            for(int j = 0 ; j < nums2.length ; j ++){
                int[] tmp = new int[]{nums1[i],nums2[j]};
                if(maxHeap.size() < k)
                    maxHeap.add(tmp);
                else{
                    if(getSum(tmp) < getSum(maxHeap.peek())){
                        maxHeap.poll();
                        maxHeap.add(tmp);
                    }
                }
            }
        }
        List<List<Integer>> list=new ArrayList<>();
        //List<Integer> list2 = new ArrayList<>();
        while(!maxHeap.isEmpty()){
            int[] array=maxHeap.poll();
            list.add(Arrays.asList(array[0],array[1]));
        }
        return list;
    }

    public int getSum(int[] o){
        return o[0] + o[1];
    }
}
     */


}
