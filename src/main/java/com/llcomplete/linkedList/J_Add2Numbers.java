package main.java.com.llcomplete.linkedList;

public class J_Add2Numbers extends A_LinkedList {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        ListNode temp = l1;
        while (temp!=null)
        {
            num1.append(temp.data);
            temp = temp.next;
        }
        temp = l2;
        while (temp!=null)
        {
            num2.append(temp.data);
            temp = temp.next;
        }
        num1.reverse();
        num2.reverse();
        //Long sum = Long.parseLong(String.valueOf(num1)) + Long.parseLong(String.valueOf(num2));
        StringBuilder summation = new StringBuilder();
        int len1 = 0;
        int len2 = 0;
        int carry = 0;
        while (len1<num1.length()||len2<num2.length()) {
            int a;
            if(len1==num1.length())
            {
                a = Integer.parseInt(String.valueOf(num2.charAt(num2.length()-1-len2))) +carry;
                len2++;
            }
            else if(len2==num2.length())
            {
                a = Integer.parseInt(String.valueOf(num1.charAt(num1.length()-1-len1))) +carry;
                len1++;
            }
            else {
                a = Integer.parseInt(String.valueOf(num1.charAt(num1.length() - 1 - len1))) +
                        Integer.parseInt(String.valueOf(num2.charAt(num2.length() - 1 - len2))) + carry;
                len1++;
                len2++;
            }
            if(len1>=num1.length()&&len2>=num2.length())
            {
                summation.append(new StringBuilder(String.valueOf(a)).reverse());
            }
            else {
                summation.append(a % 10);
                carry = a / 10;
            }
        }
//        if(carry>0)
//        {
//            int lastNum = Integer.parseInt(String.valueOf(summation.charAt(summation.length() - 1)));
//            if(lastNum>0)
//                summation.replace(summation.length()-1,summation.length(), String.valueOf( lastNum+ carry));
//            else
//            {
//                summation.append(carry);
//            }
//
//        }
        //num1 = new StringBuilder().append(sum).reverse();
        ListNode head = new ListNode(Integer.parseInt(String.valueOf(summation.charAt(0))));
        ListNode current = head;
        for(int counter =1 ;counter<summation.length();counter++)
        {
            temp = new ListNode(Integer.parseInt
                    (String.valueOf(summation.charAt(counter)))
            );
            current.next = temp;
            current = temp;
        }
        return head;

    }

    /*
    StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        ListNode temp = l1;
        while (temp!=null)
        {
            num1.append(temp.val);
            temp = temp.next;
        }
        temp = l2;
        while (temp!=null)
        {
            num2.append(temp.val);
            temp = temp.next;
        }
        num1.reverse();
        num2.reverse();
        StringBuilder summation = new StringBuilder();
        int len1 = 0;
        int len2 = 0;
        int carry = 0;
        while (len1<num1.length()||len2<num2.length()) {
            int a;
            if(len1>=num1.length())
            {
                a = Integer.parseInt(String.valueOf(num2.charAt(num2.length()-1-len2))) +carry;
                len2++;
            }
            else if(len2>=num2.length())
            {
                a = Integer.parseInt(String.valueOf(num1.charAt(num1.length()-1-len1))) +carry;
                len1++;
            }
            else {
                a = Integer.parseInt(String.valueOf(num1.charAt(num1.length() - 1 - len1))) +
                        Integer.parseInt(String.valueOf(num2.charAt(num2.length() - 1 - len2))) + carry;
                len1++;
                len2++;
            }

            summation.append(a%10);
            carry = a/10;
        }
        if(carry>0)
        {
            summation.replace(summation.length()-1,summation.length(), String.valueOf(Integer.parseInt(String.valueOf(summation.charAt(summation.length() - 1))) + carry));
        }

        ListNode head = new ListNode(Integer.parseInt(String.valueOf(summation.charAt(0))));
        ListNode current = head;
        for(int counter =1 ;counter<summation.length();counter++)
        {
            temp = new ListNode(Integer.parseInt
                    (String.valueOf(summation.charAt(counter)))
            );
            current.next = temp;
            current = temp;
        }
        return head;
     */

    public static void main(String[] args) {
        int[] arr = {9,9};
        int[] arr2 = {9,9};
        ListNode ll = convertArrToLL(arr);
        ListNode ll2 = convertArrToLL(arr2);
        printLL(addTwoNumbers(ll,ll2));

    }

}
