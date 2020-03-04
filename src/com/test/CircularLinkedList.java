package com.test;

import java.util.List;

public class CircularLinkedList {
    private ListNode last;
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public CircularLinkedList() {
        this.last = null;
        this.length = 0;
    }

    public CircularLinkedList(ListNode last) {
        this.last = last;
        this.length = 0;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }
    public void CreateCircularLinkedList(){
        ListNode first= new ListNode(1);
        ListNode second= new ListNode(3);
        ListNode third= new ListNode(6);
        ListNode fourth= new ListNode(4);
        last= new ListNode(9);

        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=last;
        last.next=first;
    }


    public void printCircularList() {
        if (last == null) {
          return;
        }
        ListNode first = last.next;
        while(first!=last){
            System.out.print(first.data + "--> ");
            first=first.next;
        }
        System.out.print(first.data);
        System.out.println();
    }

    public void insertAtBeginning(int data){
        ListNode temp= new ListNode(data);
        if (last == null) {
        last=temp;
        }
        else{
            temp.next=last.next;
        }
        last.next=temp;
        length++;

    }

    public void insertAtEnd(int data){
        ListNode temp= new ListNode(data);
        if(last==null){
            last=temp;
            last.next=last;
        }
        else{
            temp.next=last.next;
            last.next=temp;
            last=temp;
        }
        length++;
    }
}
