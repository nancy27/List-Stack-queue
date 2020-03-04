package com.test;

import java.util.EmptyStackException;
import java.util.List;

public class Stack {
    ListNode top;
    int length;
    private class ListNode{
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Stack() {
        top = null;
        length = 0;
    }
    public int getLength(){
        return length;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next=top;
        top=temp;
        length++;
    }
    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int temp = top.data;
        top = top.next;
        length--;
        return temp;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }
}
