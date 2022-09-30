/*


13. Roman to Integer
Easy

7190

427

Add to List

Share
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */


 //Approach1. 
 /**
  * Just keep the basic in mind.
iv=4(5-1) --> (v=5 and i=1)
vi=6(5+1)--> (v=5 and i=1)
if a smaller number comes before then it is minus -
or else plus +
Character.toString() is used to convert char to String as our map takes in <String , Integer>
  */
class Solution {
    public int romanToInt(String s) {
        
      HashMap<String, Integer> alphabet = new HashMap<String, Integer>();
        alphabet.put("I", 1);
        // alphabet.put("IV", 4);
        alphabet.put("V", 5);
        // alphabet.put("IX", 9);
        alphabet.put("X", 10);
        // alphabet.put("XL", 40);
        alphabet.put("L", 50);
        // alphabet.put("XC", 90);
        alphabet.put("C", 100);
        // alphabet.put("CD", 400);
        alphabet.put("D", 500);
        // alphabet.put("CM", 900);
        alphabet.put("M", 1000);
        int result = 0;
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (alphabet.get(Character.toString(s.charAt(i))) < alphabet.get(Character.toString(s.charAt(i + 1))))
                result = result - alphabet.get(Character.toString(s.charAt(i)));
            else 
                result = result + alphabet.get(Character.toString(s.charAt(i)));
        }
        return result + alphabet.get(Character.toString(s.charAt(s.length() - 1)));
    }       
        
    }