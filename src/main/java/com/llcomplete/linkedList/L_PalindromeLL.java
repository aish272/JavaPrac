package main.java.com.llcomplete.linkedList;

public class L_PalindromeLL extends A_LinkedList {


    public static void main(String[] args) {
        int[] arr = {1, 2};
        ListNode ll = convertArrToLL(arr);
        printLL(ll);
    }

    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        StringBuilder s = new StringBuilder();
        while(temp!=null)
        {
            s.append(temp.data);
            temp = temp.next;
        }
        for(int counter=0;counter<s.length()/2;counter++)
        {
            if(s.charAt(counter)==s.charAt(s.length()-counter-1))
            {
                continue;
            }
            else
            {
                return false;
            }
        }
        return true;
    }

}
