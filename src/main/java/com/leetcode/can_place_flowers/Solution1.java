/**
 * Leetcode - can_place_flowers
 */
package com.leetcode.can_place_flowers;
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

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int i = 0;
        while(i < len) {
            if(flowerbed[i] == 1) {
                i += 2;
            } else if((i == 0 || flowerbed[i - 1] == 0) && (i == len - 1 || flowerbed[i + 1] == 0)) {
                n--;
                i += 2;
            } else {
                i++;
            }
        }

        return n <= 0;
    }

}
