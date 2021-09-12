package 九月12;

import java.util.Stack;

public class Solution {

    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // left 栈存左括号的下标
                left.push(i);
            } else if (s.charAt(i) == '*') {
                // right 栈存星号下标
                star.push(i);
            } else {
                if (!left.isEmpty()) {
                    // 用左括号匹配右括号
                    left.pop();
                } else if (!star.isEmpty()) {
                    // 用星号匹配右括号
                    star.pop();
                } else {
                    // 没有左括号或星号匹配右括号，则直接返回false
                    return false;
                }
            }
        }

        // 匹配剩余的左括号和星号，星号看作右括号
        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.peek() > star.peek()) {
                // 相当于右括号在左括号的左边
                return false;
            } else {
                left.pop();
                star.pop();
            }
        }
        return left.isEmpty();
    }
}
