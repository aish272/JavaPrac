package main.java.com.twoPointerAndSlidingWindow;

public class J_MaximizeConfusionInExam {

    /**
     * <a href="https://leetcode.com/problems/maximize-the-confusion-of-an-exam/">2024. Maximize the Confusion of an Exam</a>
     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return returnMaxConsecutiveAnswers(answerKey, k, 0);

    }

    public int returnMaxConsecutiveAnswers(String answerKey, int k, int times) {
        if (times == k) {
            int t = 0;
            int f = 0;
            int consecutiveT = 0;
            int consecutiveF = 0;
            for (int i = 0; i < answerKey.length(); ) {

                while (i < answerKey.length() && answerKey.charAt(i) == 'T') {
                    consecutiveT++;
                    i++;
                }
                t = Math.max(t, consecutiveT);
                consecutiveT = 0;

                while (i < answerKey.length() && answerKey.charAt(i) == 'F') {
                    consecutiveF++;
                    i++;
                }
                f = Math.max(f, consecutiveF);
                consecutiveF = 0;

            }
            return Math.max(t, f);
        }

        int max = Integer.MIN_VALUE;
        max = Math.max(max, returnMaxConsecutiveAnswers(answerKey, k, times + 1));
        for (int i = 0; i < answerKey.length(); i++) {
            char[] arr = answerKey.toCharArray();
            char og = arr[i];
            if (arr[i] == 'T') {
                arr[i] = 'F';
            } else {
                arr[i] = 'T';
            }
            String newS = new String(arr);
            max = Math.max(max, returnMaxConsecutiveAnswers(newS, k, times + 1));
            arr[i] = og;

        }
        return max;

    }
}
