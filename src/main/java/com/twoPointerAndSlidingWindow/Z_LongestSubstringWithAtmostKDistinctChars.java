package main.java.com.twoPointerAndSlidingWindow;

import java.util.HashMap;

public class Z_LongestSubstringWithAtmostKDistinctChars {

    /**
     * <a href="https://takeuforward.org/plus/dsa/problems/longest-substring-with-at-most-k-distinct-characters">Longest Substring With At Most K Distinct Characters</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=teM9ZsVRQyc&t=1s">Video solution link</a>
     */

    public int kDistinctChar(String s, int k) {
        int l = 0;
        int r = 0;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(r<s.length())
        {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
            if(map.size()>k)
            {
                char charAtL = s.charAt(l);
                map.put(charAtL, map.get(charAtL)-1);
                if(map.get(charAtL)==0)
                {
                    map.remove(charAtL);
                }
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}
