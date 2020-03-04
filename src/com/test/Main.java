package com.test;

import java.sql.SQLOutput;
import java.util.List;

public class Main {

        private ListNode head;
      public Main(ListNode head) {
        this.head = head;
    }
        private static class ListNode{
            private int data;
            private ListNode next;

            public ListNode(int data) {
                this.data = data;
                this.next = null;
            }

            public int data() {
                return data;
            }
            public ListNode next() {
                return next;
            }

        }

       public static void main(String[] args) {
	// write your code here
           ListNode head = createLinkedList();
           System.out.println("Linked List");
           System.out.println("Printing all :");
           display(head);
           System.out.println("Length of the linked list");
        length(head);
           System.out.println("Insert Linked List at beginning");
        insertAtBeginning(head,33);
           System.out.println("Insert Linked List at end");
        insertAtEnd(head,55);
           System.out.println("Insert Linked List at a given Position");
        insertAtGivenPosition(head,3,66);
           System.out.println("reverse Linked List:");
        reverseLinkedList(head);
           System.out.println("Search Element in the linked list");
        searchElementLinkedList(head,40);
           System.out.println("Find Middle Element:");
        findMiddleElement(head);
           System.out.println("Finding Nth Node from end :");
        findNthNodeFromEnd(head,1);

        //Pushing and popping data from the list using stack
           System.out.println("Stack Push and Pop :");
           Stack stack=new Stack();
           stack.push(10);
           stack.push(15);
           stack.push(20);
           System.out.println(stack.peek());
           System.out.println(stack.pop());
           System.out.println(stack.peek());
           //enqueing and dequeing data from the list
           System.out.println("Queue Operation :");
           queueOperation();
           //circular list operations
           System.out.println("Circular List:");
           CircularLinkedList circularLinkedList= new CircularLinkedList();
           circularLinkedList.CreateCircularLinkedList();
           circularLinkedList.printCircularList();
           System.out.println("Insert at the beginning");
           circularLinkedList.insertAtBeginning(23);
           System.out.println("Print all");
           circularLinkedList.printCircularList();
           System.out.println("Insert at the end ");
           circularLinkedList.insertAtEnd(8);
           System.out.println("Printing all");
           circularLinkedList.printCircularList();
      }
      private static void queueOperation(){
          Queue queue= new Queue();
          queue.enqueue(10);
          queue.enqueue(20);
          queue.enqueue(11);
          queue.enqueue(12);
          queue.displayQueue();
          queue.dequeue();
          queue.dequeue();
          queue.displayQueue();
      }
      private static ListNode createLinkedList(){
          ListNode head= new ListNode(31);
          ListNode second = new ListNode(22);
          ListNode third = new ListNode(30);
          ListNode fourth = new ListNode(20);
          ListNode fifth = new ListNode(40);
          head.next=second;
          second.next=third;
          third.next=fourth;
          fourth.next=fifth;
           return head;
      }

      private static void display(ListNode head){
          ListNode current = head;
          while(current !=null){
              System.out.print(current.data+ " --> ");
              current=current.next;
          }
          System.out.println(current);
      }

     private static void length(ListNode head){
          ListNode current = head;
          int count=0;
          while(current!=null){
              count= count+1;
              current= current.next;
          }
         System.out.println("Length " + count);
     }

     private static void insertAtBeginning(ListNode head , int data) {
         ListNode newNode = new ListNode(data);
         if (head == null) {
             return;
         }
         newNode.next = head;
         head = newNode;
         display(head);
     }

    private static  boolean hasLoop(ListNode head){
        ListNode fastPtr= head;
        ListNode slowPtr= head;
        while (fastPtr!=null && fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            if(slowPtr==fastPtr){
                return true;
            }
        }
        return false;
    }

    private static void createALoopInLinked(){
        ListNode head= new ListNode(31);
        ListNode second = new ListNode(22);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(20);
        ListNode fifth = new ListNode(40);
        ListNode sixth= new ListNode(43);

        head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=sixth;
        sixth.next=third;

        System.out.println(hasLoop(head));
    }

     private static void insertAtEnd(ListNode head, int data){
          ListNode newNode = new ListNode(data);
          ListNode current = head;
          if (head == null){
           return ;
          }
          while (current.next != null){
              current=current.next;
          }
          current.next= newNode;
          display(head);
     }
     private static void reverseLinkedList(ListNode head){
          ListNode previous= null;
          ListNode next = null;
          ListNode current= head;
          while(current != null){
              next= current.next;
              current.next=previous;
              previous= current;
              current=next;
          }
          display(previous);
     }

     private static void findMiddleElement(ListNode head){
          ListNode slowptr=head;
          ListNode fastPtr=head;
          while(fastPtr != null && fastPtr.next!=null){
              slowptr=slowptr.next;
              fastPtr=fastPtr.next.next;
          }
         System.out.println("Middle Element : " + slowptr.data);
     }

     private static void findNthNodeFromEnd(ListNode head,int position){
          if(head == null){
              return;
          }
          if(position<=0){
              throw new IllegalArgumentException("Invalid Value");
          }
          ListNode mainPtr=head;
          ListNode refPtr=head;
          int count=0;
          while(count <position) {
              if(refPtr == null){
                  throw new IllegalArgumentException(position + "is greatee than the no of nodes in the list");
              }
          refPtr=refPtr.next;
          count++;
          }
          while (refPtr!=null) {
              refPtr=refPtr.next;
              mainPtr = mainPtr.next;
          }
         System.out.println("NthElement From End of the Linked list : " + mainPtr.data);
          }

     private static void searchElementLinkedList(ListNode head, int search){
          ListNode current= head;
          boolean value = false;
          while (current!=null){
              if(current.data==search){
                  value=true;
              }
              current=current.next;
          }
         System.out.println("Has Search element found :" + value);
     }

     private static void insertAtGivenPosition(ListNode head, int position, int data){
          ListNode newNode= new ListNode(data);
          ListNode previousNode = head;
          int count=1;
          while(count <position-1){
              previousNode =previousNode.next;
              count++;
          }
         ListNode current= previousNode.next;
          newNode.next=current;
          previousNode.next=newNode;
         System.out.println("Insert At given Position " );
          display(head);
     }
}
