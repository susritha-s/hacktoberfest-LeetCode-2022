/*
20. Valid Parentheses
Easy

15858

789

Add to List

Share
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

import java.util.*;
class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0) {   
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='[') {
                stack.push(c);
            }
            else {
                if(stack.isEmpty())
                    return false;
                if(c==')'&&stack.peek()=='(' || 
                   c=='}'&&stack.peek()=='{' || 
                   c==']'&&stack.peek()=='[')
                    
                    stack.pop();
                else
                    return false;
            }
            
        }
        return stack.isEmpty();
    }
}