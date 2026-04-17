package main.java.com.string;

public class Y_StringCompression {

    /**
     * <a href="https://leetcode.com/problems/string-compression/">443. String Compression</a>
     */
    public int compress(char[] chars) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int count = 1;
            while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }
            if (count > 1) {

                s.append(chars[i]);
                s.append(count);
            } else {
                s.append(chars[i]);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return s.length();

    }
}
