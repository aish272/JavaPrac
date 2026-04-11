package main.java.com.twoPointerAndSlidingWindow;

public class J_MaximizeConfusionInExam_Better {

    /**
     * <a href="https://leetcode.com/problems/maximize-the-confusion-of-an-exam/">2024. Maximize the Confusion of an Exam</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=vY06L8hZVGI">Video solution link</a>
     */
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(returnMaxConsecutiveAnswers(answerKey, k, 'T'), returnMaxConsecutiveAnswers(answerKey, k, 'F'));

    }

    private static int returnMaxConsecutiveAnswers(String answerKey, int k, char c) {
        int left = 0;
        int count = 0;
        int len = Integer.MIN_VALUE;
        for (int right = 0; right < answerKey.length(); ) {
            char ans = answerKey.charAt(right);
            if (ans != c) {

                if (count < k) {

                    count++;
                } else {
                    while (answerKey.charAt(left) == c) {
                        left = left + 1;
                    }
                    left += 1;

                }

            }
            len = Math.max(len, right - left + 1);
            right++;

        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("TTFTTFTT", 1));

    }
}
