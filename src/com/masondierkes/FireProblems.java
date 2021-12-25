package com.masondierkes;

import java.util.ArrayList;
import java.util.List;

public class FireProblems {

    public void printBinary(int digits) {
        printBinaryHelper(digits, "");
    }

    private void printBinaryHelper(int n, String result){
        if(result.length() == n)
            System.out.print(result + " ");

        else {
            printBinaryHelper(n, result + 0);
            printBinaryHelper(n, result + 1);
        }
    }

    public void climbStairs(int steps){
        climbStairsHelper(0, steps, "");
    }

    private void climbStairsHelper(int current, int goal, String result){
        if(current == goal)
            System.out.println(result + " ");

        else if(current > goal){ return; }

        climbStairsHelper(current + 1, goal, result + "1 ");
        climbStairsHelper(current + 2, goal, result + "2 ");
    }

    public int getMax(List<Integer> nums, int limit){
        return getMaxHelper(nums, new ArrayList<>(), limit, 0);
    }

    private int getMaxHelper(List<Integer> nums, List<Integer> used, int limit, int total){
        if (total > limit)
            return total;

        for (int i = 0; i < nums.size(); i++) {
            if(!used.contains(nums.get(i)) && (total + nums.get(i) <= limit)) {
                used.add(nums.get(i));
                return getMaxHelper(nums,used, limit, total + nums.get(i));
            }
        }
        return total;
    }


    public void campsite(int x, int y) {
        campsiteHelper(x, y, 0, 0, "");
    }

    private void campsiteHelper(int x, int y, int currentX, int currentY, String result) {
        if (x == currentX && y == currentY)
            System.out.println(result);

        else {
            if (currentX + 1 <= x)
                campsiteHelper(x, y, currentX + 1, currentY, result + "E ");

            if (currentY + 1 <= y)
                campsiteHelper(x, y, currentX, currentY + 1, result + "N ");

            if (currentX + 1 <= x && currentY + 1 <= y)
                campsiteHelper(x, y, currentX + 1, currentY + 1, result + "NE ");
        }
    }

    public int makeChange(int amount){
        return makeChangeHelper(0, amount);
    }

    private int makeChangeHelper(int current, int amount){
        if (amount == 0)
            System.out.println(current);

        else {
            if (amount - 25 >= 0)
                return makeChangeHelper(current, amount - 25);

            if (amount - 10 >= 0)
                return makeChangeHelper(current, amount - 10);

            if (amount - 5 >= 0)
                return makeChangeHelper(current, amount - 5);

            if (amount - 1 >= 0)
                return makeChangeHelper(current, amount - 1);
        }
        return current;
    }

}
