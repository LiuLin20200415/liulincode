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
}
