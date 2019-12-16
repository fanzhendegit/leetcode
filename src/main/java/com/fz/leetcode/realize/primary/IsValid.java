package com.fz.leetcode.realize.primary;

import java.util.Stack;

/**
 * @Author: fanzhen
 * @Date: 2019/12/16 18:50
 * @Version 2.0.0
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValid {


    /**
     * 匹配出栈，不匹配入栈，最后判断栈是否为空即可
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<String> stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(s.substring(i,i+1));
            }else {
                if(s.substring(i, i + 1).equals("}")&&stack.peek().equals("{")){
                    stack.pop();
                }else if(s.substring(i, i + 1).equals(")")&&stack.peek().equals("(")){
                    stack.pop();
                }else if(s.substring(i, i + 1).equals("]")&&stack.peek().equals("[")){
                    stack.pop();
                }else {
                    stack.push(s.substring(i,i+1));
                }
            }
        }
        if(stack.size()==0){
            return true;
        }else {
            return false;
        }
    }
}
