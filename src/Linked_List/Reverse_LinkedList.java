package Linked_List;

//Given the head of a singly linked list, reverse the list, and return the reversed list.
public class Reverse_LinkedList {
    ListNode head;

    public class ListNode {
          int val;
          ListNode next;
          ListNode(int val) { this.val = val; }
      }

        public static ListNode reverseList(ListNode head) {
        ListNode node=null;

        while(head!=null){
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
         return node;
        }

    public void add(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
        public static void main(String args[]){
        Reverse_LinkedList reverse_linkedList=new Reverse_LinkedList();
            for(int i=1;i<6;i++){
                reverse_linkedList.add(i);
            }
            ListNode head=reverseList(reverse_linkedList.head);
            while(head!=null){
                System.out.print(head.val);
                head=head.next;
            };

        }

}
