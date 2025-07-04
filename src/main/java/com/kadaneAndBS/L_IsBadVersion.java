package main.java.com.kadaneAndBS;

public class L_IsBadVersion {

    /**
     * <a href="https://leetcode.com/problems/first-bad-version/description/">278. First Bad Version</a>
     */
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int ans = -1;
        while (high >= low) {
            int mid = low + ((high - low) / 2);
            /* The isBadVersion API is defined in the parent class VersionControl. boolean isBadVersion(int version);
              commenting the below code because of the above reason. This above line is from leetcode and the class is available on their server
             */
//            boolean rslt = isBadVersion(mid);
//            if (rslt == true) {
//                high = mid - 1;
//                ans = mid;
//
//            } else {
//                low = mid + 1;
//            }
        }
        return ans;

    }
}
