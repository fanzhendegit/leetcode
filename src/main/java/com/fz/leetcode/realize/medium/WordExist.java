package com.fz.leetcode.realize.medium;

/**
 * @Author: fanzhen
 * @Date: 2019/12/18 16:29
 * @Version 2.0.0
 */
public class WordExist {

    private boolean[][] marked;

    private int m;

    private int n;

    public boolean exist(char[][] board, String word) {
        m=board.length;
        char[] wordArr=word.toCharArray();
        if(m==0){
            return word.length() == 0;
        }
        n=board[0].length;
        marked = new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                /*
                    依次搜索
                 */
                if(existWord(board,wordArr,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existWord(char[][] board,char[] wordArr,int row,int col,int length){
        if(length==wordArr.length){
            return true;
        }else {
            if(board[row][col]==wordArr[length]){
                /*
                    标记
                 */
                marked[row][col] = true;
                length++;
                if(length==wordArr.length){
                    return true;
                }

                /*
                    如果标记位为true进入递归
                 */
                if(inArea(row-1, col)&&!marked[row-1][col]){
                    if(existWord(board, wordArr, row-1, col, length)){
                        return true;
                    }
                }
                if(inArea(row+1, col)&&!marked[row+1][col]){
                    if(existWord(board, wordArr, row+1, col, length)){
                        return true;
                    }
                }
                if(inArea(row, col-1)&&!marked[row][col-1]){
                    if(existWord(board, wordArr, row, col-1, length)){
                        return true;
                    }
                }
                if(inArea(row, col+1)&&!marked[row][col+1]){
                    if(existWord(board, wordArr, row, col+1, length)){
                        return true;
                    }
                }

                /*
                    减枝
                 */
                marked[row][col] = false;
            }
            return false;
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
