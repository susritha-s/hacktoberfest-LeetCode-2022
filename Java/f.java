import java.util.*;

/*
44. Wildcard Matching
Hard

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

 

Constraints:

    0 <= s.length, p.length <= 2000
    s contains only lowercase English letters.
    p contains only lowercase English letters, '?' or '*'.


*/
class Solution {
public:
    bool f(int i,int j, string &s,string &p)
    {
        if(i<0 && j<0) return true;
        if(j<0 && i>=0) return false;
        if(i<0 && j>=0)
        {
            while(j>=0)
            {
                if(p[j]=='*') j--;
                else return false;
            }
            return true;
        }
        
        if(s[i]==p[j] || p[j]=='?') return f(i-1,j-1,s,p);
        
        if(p[j]=='*')
        {
            return f(i-1,j,s,p) || f(i,j-1,s,p);
            //Two cases
            //Consider * as len=0
            //Give one charcter to * and remain at *
            //at next step it will again be decided from both these cases
        }
        return false;
        
    }
    
    bool isMatch(string s, string p) {
        int n=s.length(),m=p.length();
        return f(n-1,m-1,s,p);
    }
};