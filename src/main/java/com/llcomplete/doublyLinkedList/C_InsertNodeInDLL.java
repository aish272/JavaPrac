package main.java.com.llcomplete.doublyLinkedList;

public class C_InsertNodeInDLL extends A_DoublyLinkedList{

    public static Node insertANodeInDLL(Node head, int index, int value)
    {
        if(head == null )
        {
            return new Node(null,null,value);
        }
        else if(index == 0)
        {
            head =  new Node(head,null,value);
            head.next.prev = head;
            return  head;
        }

        Node temp = head;
        int count =0;
        while (temp!=null)
        {
            if(count==index-1)
            {
                Node newNode = new Node(temp.next,temp,value);
                temp.next = newNode;
                if(newNode.next!=null) {
                    newNode.next.prev = newNode;
                }

                break;
            }
            temp = temp.next;
            count++;
        }
        return head;
    }

    public static void main(String[] args)
    {
        int[] arr = {9,889,6,5,8,0,8};
        Node dll = convertArrayToDLL(arr);
        dll = insertANodeInDLL(dll,7,100);
        printDLL(dll);

    }
}
