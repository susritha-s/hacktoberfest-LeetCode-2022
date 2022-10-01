/*
12. Integer to Roman
Medium

4085

4448

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
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.

 

Example 1:

Input: num = 3
Output: "III"
Explanation: 3 is represented as 3 ones.
Example 2:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 3:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= num <= 3999


*/

//Approach1. 
class Solution {
    public String intToRoman(int num) {
        StringBuffer ans = new StringBuffer();
        int ktest = num/1000;
        if(ktest >= 1){
            for(int i = 1;i<=ktest;i++){
                ans.append("M");
            }
            num = num-ktest*1000;
        }
        
        int btest = num/100;
        if(btest >= 1){
            if(btest == 4){
                ans.append("CD");
            }
            else if(btest == 9){
                ans.append("CM");
            }
            else{
                if(btest < 5){
                    for(int i = 1;i<=btest;i++){
                        ans.append("C");
                    }
                }
                else{
                    ans.append("D");
                    int flag = btest-5;
                    while(flag>0){
                        ans.append("C");
                        flag--;
                    }
                }
            }
            num = num-btest*100;
        }
        
        int ttest = num/10;
        if(ttest >= 1){
            if(ttest == 4){
                ans.append("XL");
            }
            else if(ttest == 9){
                ans.append("XC");
            }
            else{
                if(ttest < 5){
                    for(int i = 1;i<=ttest;i++){
                        ans.append("X");
                    }
                }
                else{
                    ans.append("L");
                    int flag = ttest-5;
                    while(flag>0){
                        ans.append("X");
                        flag--;
                    }
                }
            }
            num = num-ttest*10;
        }
        
        int gtest = num;
        if(gtest >= 1){
            if(gtest == 4){
                ans.append("IV");
            }
            else if(gtest == 9){
                ans.append("IX");
            }
            else{
                if(gtest < 5){
                    for(int i = 1;i<=gtest;i++){
                        ans.append("I");
                    }
                }
                else{
                    ans.append("V");
                    int flag = gtest-5;
                    while(flag > 0){
                        ans.append("I");
                        flag--;
                    }
                }
            }
        }
        return ans.toString();
    }
}

//Approach 2.
//18ms 24.31%
class Solution {
    public String intToRoman(int num) {
        StringBuffer ans = new StringBuffer();
        LinkedHashMap<Integer,String> map = new LinkedHashMap();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        
        for(int digit : map.keySet()){
            // System.out.println(digit);
            while(num >= digit){
                ans.append(map.get(digit));
                num -= digit;
            }
        }
        return ans.toString();
    }
}