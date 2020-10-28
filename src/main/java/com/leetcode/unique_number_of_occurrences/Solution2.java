/**
 * Leetcode - unique_number_of_occurrences
 */
package com.leetcode.unique_number_of_occurrences;
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
class Solution2 implements Solution {

    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(arr);
        int count = 1;
        for(int i = 1;i < arr.length;i ++){
            if(arr[i] != arr[i - 1]){
                if(!set.add(count)){
                    return false;
                }
                count = 1;
            }else{
                count ++;
            }
        }
        if(!set.add(count)){
            return false;
        }
        return true;
    }

}
