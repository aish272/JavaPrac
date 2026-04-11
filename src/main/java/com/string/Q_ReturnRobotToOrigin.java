package main.java.com.string;

public class Q_ReturnRobotToOrigin {

    /**
     * <a href="https://leetcode.com/problems/robot-return-to-origin/description/">657. Robot Return to Origin</a>
     */
    public boolean judgeCircle(String moves) {

        String travelled = "" + moves.charAt(0);
        for (int i = 1; i < moves.length(); i++) {
            char c = moves.charAt(i);
            switch (c) {
                case 'U' -> {
                    if (travelled.contains("D")) {
                        travelled = travelled.replaceFirst("D", "");
                    } else {
                        travelled += c;
                    }
                }
                case 'D' -> {
                    if (travelled.contains("U")) {
                        travelled = travelled.replaceFirst("U", "");
                    } else {
                        travelled += c;
                    }
                }
                case 'L' -> {
                    if (travelled.contains("R")) {
                        travelled = travelled.replaceFirst("R", "");
                    } else {
                        travelled += c;
                    }
                }
                case 'R' -> {
                    if (travelled.contains("L")) {
                        travelled = travelled.replaceFirst("L", "");
                    } else {
                        travelled += c;
                    }
                }
            }
        }
        return travelled.equals("");


    }
}
