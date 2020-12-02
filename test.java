package com.prob.leetcode;


import com.prob.leetcode.util.TreeNode;

import javax.sql.rowset.spi.SyncResolver;
import java.util.*;

class P {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return ans;

        bt(ans, new ArrayList<>(), candidates, 0, target);

        return ans;
    }

    private void bt(List<List<Integer>> ans, List<Integer> tmp, int[] nums, int idx, int target) {
        if (target < 0)
            return;
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            tmp.add(nums[i]);
            bt(ans, tmp, nums, i, target - nums[i]);
            tmp.remove(tmp.size() - 1);
        }
    }



    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return false;

        int index = 0;
        for (int row = 0; row < board.length; row++) {
            boolean[] rowCheck = new boolean[9];
            boolean[] colCheck = new boolean[9];
            boolean[] boxCheck = new boolean[9];

            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] != '.') {
                    index = Character.getNumericValue(board[row][col]) - 1;

                    if (rowCheck[index])
                        return false;
                    rowCheck[index] = true;
                }

                if (board[col][row] != '.') {
                    index = Character.getNumericValue(board[col][row]) - 1;

                    if (colCheck[index])
                        return false;
                    colCheck[index] = true;
                }

                int rowBox = (row/3)*3 + col/3;
                int colBox = (row%3)*3 + col%3;
                if (board[rowBox][colBox] != '.') {
                    index = Character.getNumericValue(board[rowBox][colBox]) - 1;

                    if (boxCheck[index])
                        return false;
                    boxCheck[index] = false;
                }
            }
        }

        return false;
    }



    public static void main(String[] args) {
        P p = new P();

    }

}