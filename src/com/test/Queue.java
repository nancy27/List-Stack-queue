package com.test;

import java.util.List;
import java.util.NoSuchElementException;

public class Queue {
    private ListNode front;
    private ListNode rear;
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public Queue() {
        front = null;
        rear = null;
        length = 0;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public int length(){
        return length;
    }
    public void enqueue(int data){
        ListNode temp= new ListNode(data);
        if (isEmpty()) {
            front=temp;
        }
        else{
            rear.next=temp;
        }
        rear=temp;
        length++;
    }
    public void displayQueue(){
        ListNode temp = front;
        if(isEmpty()){
            return ;
        }
        while(temp!=null){
        System.out.print(temp.data + "-->");
        temp=temp.next;
        }
        System.out.println("Null");
    }

    public int dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
       int result=front.data;
        front= front.next;
        if(front==null){
            rear=null;
        }
        length--;
        return result;
    }



}
