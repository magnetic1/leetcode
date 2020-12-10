/**
 * Leetcode - lemonade_change
 */
package com.leetcode.lemonade_change;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution1 implements Solution {

    public boolean lemonadeChange(int[] bills) {
        int[] myBill = new int[3];
        for(int bill : bills) {
            if(!lemonadeChange(myBill, bill)) {
                return false;
            }
        }
        return true;
    }

    boolean lemonadeChange(int[] myBill, int bill) {
        int b = bill;

        while(myBill[1] > 0 && b >= 15) {
            b -= 10;
            myBill[1]--;
        }

        while(myBill[0] > 0 && b >= 10) {
            b -= 5;
            myBill[0]--;
        }

        myBill[bill / 7]++;

        return b == 5;
    }

}
