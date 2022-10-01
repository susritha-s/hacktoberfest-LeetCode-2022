/*
14. Longest Common Prefix
Easy

10516

3409

Add to List

Share
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.

*/

class Solution
{
public static String longestCommonPrefix(String[] str)
{
String s="";int index=0;boolean SS=true;
int min=Integer.MAX_VALUE;
for(int i=0;i<str.length;i++)
{
if(str[i].length()==0)
{
return s;
}
if(str[i].length()<min)
{
min=str[i].length();
index=i;
}
}
if(str.length==1)
{
return str[0];
}
int start=0;
int end=min-1;
int ans=0;
boolean hit=false;
while(start<=end)
{
int mid=start+(end-start)/2;
char ch=str[index].charAt(mid);
boolean b=true;
for(int i=0;i<str.length;i++)
{
if(str[i].charAt(mid)!=ch)
{
b=false;
}
}
if(b)
{
hit=true;
ans=mid;
start=mid+1;
}
else
{
end=mid-1;
}
}
String aa=str[0].substring(0,ans+1);
if(ans==0 && hit==false)
{
return s;
}
String a1=str[0].substring(0,ans+1);
for(int i=0;i<str.length;i++)
{
if(!(str[i].contains(a1)))
{
SS=false;
}
}
if(SS)
{
return aa;
}
else
{
return s;
}
}
}