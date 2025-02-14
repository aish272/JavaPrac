package main.java.com.string;

public class D_FindIndexOfFirstOccurrenceOfString {

    public int strStr(String haystack, String needle) {
        if(haystack.contains(needle))
        {
            return haystack.indexOf(needle);
        }
        return -1;
    }
}

