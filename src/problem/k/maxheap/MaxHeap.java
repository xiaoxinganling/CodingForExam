/**
 * maxheap to solve k
 */
package problem.k.maxheap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private List<Integer> items;

    public List<Integer> getItems() {
        return items;
    }

    private int cursor;
    public MaxHeap(int mSize)
    {
        items = new ArrayList<>(mSize);
        cursor = -1;
    }
    public void adjustDown(int r,int j)
    {
        //r+1-j的均已满足最大堆
        int tmp = items.get(r);
        int child = 2*r+1;
        while(child<=j)
        {
            if(child<j&&items.get(child+1)>items.get(child))
                child++;
            if(items.get(child)<=tmp)
                break;
            items.set((child-1)/2,items.get(child));
            child = 2*child+1;
        }
        items.set((child-1)/2,tmp);
    }
    public void adjustUp(int index)
    {
        //index前面的均满足最大堆
        int tmp = items.get(index);
        int i = index;
        while(i>0&&items.get((i-1)/2)<tmp)
        {
            items.set(i,items.get((i-1)/2));
            i = (i-1)/2;
        }
        items.set(i,tmp);
    }
    //向堆中添加一个元素
    public void add(int item)
    {
        items.add(item);
        adjustUp(items.size()-1);
        cursor++;
    }
    //删除堆中元素
    public void deleteItem()
    {
        if(items.size()==0)
            return;
        int last = items.remove(items.size()-1);
        cursor--;
        items.set(0,last);
        adjustDown(0,items.size()-1);
    }
    //判断堆是否已满
    public boolean isFull(int k)
    {
        return items.size()==k;
    }
    //得到最大值
    public int getMax()
    {
        return items.get(0);
    }

    public static void main(String[] args) {
        int[] nums ={4,5,1,6,2,7,3,8};
        MaxHeap mh = new MaxHeap(4);
        for(int i:nums)
        {
            if(!mh.isFull(4))
                mh.add(i);
            else
                if(i<mh.getMax()) {
                    mh.deleteItem();
                    mh.add(i);
                }
        }
        for(int i:mh.getItems())
        {
            System.out.print(i+" ");
        }
    }
}
