package com.fz.leetcode.realize.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 18:06
 * @Version 2.0.0
 */
class Trie {

    List<List<String>> tree=new ArrayList<>();

    public Trie() {
        reSize(8);
    }

    private void reSize(int length){
        for (int i=0;i<length;i++){
            List<String> l=new ArrayList<>();
            tree.add(l);
        }
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(tree.size()==0){
            reSize(word.length());
        }else {
            if(tree.size()<word.length()){
                reSize(word.length()-tree.size());
            }
            for (int i=0;i<word.length();i++){
                if(!tree.get(i).contains(word.substring(0,i+1))){
                    tree.get(i).add(word.substring(0,i+1));
                }

            }
            if(!tree.get(word.length()-1).contains(word+"-1")){
                tree.get(word.length()-1).add(word+"-1");
            }

        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(tree.size()<word.length()) {
            return false;
        }
        return tree.get(word.length()-1).contains(word+"-1");
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(tree.size()<prefix.length()) {
            return false;
        }
        return tree.get(prefix.length()-1).contains(prefix);
    }
}
