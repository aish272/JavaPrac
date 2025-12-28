package main.java.com.string;

public class U_MultiplyStrings {

    /**
     * <a href="https://leetcode.com/problems/multiply-strings/description/">43. Multiply Strings</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=1vZswirL8Y8">Video solution link</a>
     */
    public static String multiply(String num1, String num2) {


        int[] ans = new int[num1.length() + num2.length()];


        for (int s1 = num1.length() - 1; s1 >= 0; s1--) {
            for (int s2 = num2.length() - 1; s2 >= 0; s2--) {

                int prod = Integer.parseInt(String.valueOf(num1.charAt(s1))) * Integer.parseInt(String.valueOf(num2.charAt(s2)));
                ans[s1 + s2 + 1] += prod; //add the product to any previous carry (if exists).
                ans[s1 + s2] += (ans[s1 + s2 + 1] / 10); // forward the carry to the next position (if any carry exists)
                ans[s1 + s2 + 1] = ans[s1 + s2 + 1] % 10; // only storing single digit
            }
        }
        int index = 0;
        while (ans[index] == 0) {
            index++;
        }
        StringBuilder productString = new StringBuilder();
        while (index < ans.length) {
            productString.append(ans[index]);
            index++;
        }

        return productString.toString();

    }

    public static void main(String[] args) {
        multiply("123", "456");
    }

}
