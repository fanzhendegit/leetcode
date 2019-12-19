package com.fz.leetcode.realize.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: fanzhen
 * @Date: 2019/12/18 10:33
 * @Version 2.0.0
 *
 * 字母异位词分组
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String str:strs){
            String value=stringValue(str);
            if(map.containsKey(value)){
                map.get(value).add(str);
            }else {
                List<String> l=new LinkedList<>();
                l.add(str);
                map.put(value,l);
            }
        }
        return new ArrayList<>(map.values());
    }

    private String stringValue(String s){
        Integer[] arr=new Integer[s.length()];
        for (int i=0;i<s.length();i++){
            arr[i]= (int) s.charAt(i);
        }
        Arrays.sort(arr);
        StringBuilder temp=new StringBuilder();
        for (Integer i:arr){
            temp.append(i).append("-");
        }
        return temp.toString();
    }

    /**
     *  直接重排序str
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsSecond(String[] strs) {
        List<List<String>> resultList = new LinkedList<>();
        Map<String,List<String>> result=new HashMap<>();
        int length = strs.length;
        for (int i=0;i< length;i++){
            char[] chars=strs[i].toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
            if(!result.containsKey(key)){
                result.put(key,new LinkedList<String>());
            }
            result.get(key).add(strs[i]);

        }
        for(List<String> list : result.values()) {
            resultList.add(list);
        }
        return resultList;
    }
}
