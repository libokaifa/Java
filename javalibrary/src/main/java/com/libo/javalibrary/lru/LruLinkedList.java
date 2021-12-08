package com.libo.javalibrary.lru;

/**
 * /**
 *
 * @Author libo
 * @create 2021/11/28 4:39 下午
 * @describe: LrU
 * 新数据插入到链表头部
 * 当缓存命中(即缓存数据被访问)，数据要移到表头
 * 当链表满的时候，将链表尾部的数据丢弃
 */
class LruLinkedList<T>   extends LinkedList<T> {
    int memory_size; // 内存大小
    static final int DEFAULT_CAP = 5;// 默认内存大小
    // 新数据插入到链表头部,当链表满的时候，将链表尾部的数据丢弃
    public void lruPut(T data) {
        if (size >= memory_size) {
            removeLast();
            put(data);
        } else {
            put(data);
        }
    }
    public T lruRemove(){
        return removeLast();
    }
    //当缓存命中(即缓存数据被访问)，数据要移到表头
    public T lruGet(int index) {
        checkIndex(index);
        Node cur = list;
        Node pre = list;
        for(int i = 0; i < index; i++) {//找到当前节点
            pre = cur;
            cur = cur.next;
        }
        T resultData = cur.data;

        pre.next =  cur.next;
        Node head = list;
        cur.next = head;
        list = cur;
        return resultData;
    }
}
