package com.libo.javalibrary.lru;

/**
 * /**
 *
 * @Author libo
 * @create 2021/11/28 3:20 下午
 * @describe: 手动单链表实现linklist
 */
public class LinkedList<T> {
     Node list; //头部节点
     int size;//当前链表大小

    public LinkedList() {
        this.size = 0;
    }

    // 存储数据 ，默认存储到链表头部
    public void  put(T data){
         Node head=new Node(data,list);
         list=head;//头部节点
         size++;
    }
   // 存储指定节点
    public void  put(int dex,T DATA){
        checkIndex(dex);
        Node pre=list;//前一个节点
        Node cur=list;//当前节点
        for (int i=0;i<dex;i++ ){//找到节点
            pre=cur;//向下找，当前节点变成上个节点
            cur=cur.next;// 当前节点变成下个节点
        }
        // 插入操作
        Node node=new Node(DATA,cur);
        pre.next=node;
        size++;
    }
    // 删除节点,从头部删除
     public T remove(){
        if (list!=null){
            Node node=list;
            list=list.next;
            node.next=null;
            size--;
            return node.data;
        }
        return null;
     }
     // 删除指定元素
    public T remove(int dex){
        checkIndex(dex);
        Node pre=list;//前一个节点
        Node cur=list;//当前节点
        for (int i=0;i<dex;i++ ){//找到节点
            pre=cur;//向下找，当前节点变成上个节点
            cur=cur.next;// 当前节点变成下个节点
        }
        // 插入操作
        pre.next=cur.next;
        cur.next=null;//GC 回收
        size--;
        return cur.data;
    }
    public T removeLast() {
        if (list != null) {
            Node pre = list;
            Node cur = list;
            while(cur.next != null) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = null;
            size--;
            return cur.data;

        }
        return null;
    }

    // 修改数据
    public  void  set(int index,T newData){
        checkIndex(index);
        Node cur=list;
        for (int i=0;i< index;i++){//查找到当前元素
            cur=cur.next;
        }
        cur.data=newData;
    }
    // 获得头部元素
    public T get() {
        Node node = list;
        if (node != null) {
            return node.data;
        } else {
            return null;
        }
    }
    // 获得指定元素
    public  T get(int index){
        checkIndex(index);
        Node cur=list;
        for (int i=0;i< index;i++){//查找到当前元素
            cur=cur.next;
        }
       return cur.data;
    }

    public String toString() {
        Node node = list;
        for (int i = 0; i < size; i++) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
        return super.toString();
    }
    /**
     * 数据元素
     */
    class  Node{
        T data;
        Node next;
        public  Node(T data,Node node){
            this.data=data;
            this.next=node;
        }
    }

    /**
     * 检查合法性质
     * @param index
     */
    public void checkIndex(int index) {
        if(!(index >=0 && index <=size)) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }

    }
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.put(i);
        }
        list.toString();
        list.put(3, 3);
        list.toString();
        list.put(8);
        list.toString();
        System.out.println(list.get(2));
    }
}
