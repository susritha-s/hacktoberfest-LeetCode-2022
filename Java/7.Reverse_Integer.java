import java.util.*;

/*

7. Reverse Integer
Medium

8558

10781

Add to List

Share
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21

 */

//Approach 1. With 32 bits
public int reverse(int x) {
    // low equals -2 ^ 31
    int low = -1 << 31;
    
    // limit equals all significant digits in the range bounds except the unit's place
    // lower bound = -2 ^ 31 = -2147483648
    // upper bound = 2 ^ 31 - 1 = 2147483647
    // limit = 214748364
    int limit = low / -10;
   
   int rev = 0;
    
    // convert to positive and store sign in a boolean flag
    boolean neg = false;
    if (x < 0) {
        if (x == low) {
            // If its lower bound, then we can't simple remove sign
            // without going outside the upper bound, return 0 here
            // -2147483648 * -1 = +2147483648 > 2147483647
            return 0;
        }
        neg = true;
        x *= -1;
    }
    
    while (x > 0) {
        int rem = x % 10;
        x /= 10;
        if ((rev == limit) && ((neg && rem > 8) || (!neg && rem > 7))) {
            // Check if last digit is out of bounds 
            return 0;
        }
        else if (rev > limit) {
            // Check if current value can be out of bounds if we add to it 
            return 0;
        }
        // We can now add to the reversed number safely within bounds
        rev *= 10;
        rev += rem;
    }
    
    // Add the sign back before returning
    return neg ? -rev : rev;
}


//Approach 2. 
// Only 15 lines.
// If overflow exists, the new result will not equal previous one.
// No flags needed. No hard code like 0xf7777777 needed.
// Sorry for my bad english.
public int reverse(int x)
{
    int result = 0;

    while (x != 0)
    {
        int tail = x % 10;
        int newResult = result * 10 + tail;
        if ((newResult - tail) / 10 != result)
        { return 0; }
        result = newResult;
        x = x / 10;
    }

    return result;
}