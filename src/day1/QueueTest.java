package day1;

import java.util.ArrayList;

public class QueueTest {
    public static void main(String[] args) throws QueueFullException, QueueEmptyException {
        MyQueue<Integer> myQueue = new MyQueue<Integer>(5);
        myQueue.addQueue(1);
        myQueue.addQueue(11);
        myQueue.addQueue(111);
        myQueue.addQueue(1111);
        myQueue.addQueue(11111);
        myQueue.addQueue(2);
        myQueue.addQueue(3);
//        System.out.println(myQueue.removeQueue());
//        System.out.println(myQueue.removeQueue());
//        System.out.println(myQueue.removeQueue());
//        System.out.println(myQueue.removeQueue());

    }
}

class MyQueue<T>{
    ArrayList<T> A;
    int start = -1;
    int end;
    int size;

    public MyQueue(int size){
        this.size = size;
        this.end = start;
        A = new ArrayList<T>(size);
    }
    void addQueue(T item) throws QueueFullException {
//        if(end - start > size) throw new day1.QueueFullException("Queue full");
        if(end + 1 > size) throw  new QueueFullException("Queue full");
        else{
            if(start == -1 && end == -1){
                start = 0;
                end = 0;
            }
            else end = end + 1;
        }
        A.add(item);
    }
    T removeQueue() throws QueueEmptyException {
        if(start == -1 || start > end) {
            throw new QueueEmptyException("Queue Empty");
        }

        T removeItem = A.get(start);

        if(start == end){
            start = end = -1;
        }
        else{
            start = start + 1 ;
        }

        return removeItem;
    }



}