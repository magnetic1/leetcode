/**
 * Leetcode - design_parking_system
 */
package com.leetcode.design_parking_system;
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

    static class ParkingSystem {
        int[] nums;
        public ParkingSystem(int big, int medium, int small) {
            nums = new int[3];
            nums[0] = big;
            nums[1] = medium;
            nums[2] = small;
        }

        public boolean addCar(int carType) {
            if(nums[carType - 1] == 0) {
                return false;
            }
            nums[carType - 1]--;
            return true;
        }
    }

}
