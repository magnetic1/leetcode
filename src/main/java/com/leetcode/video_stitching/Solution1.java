/**
 * Leetcode - video_stitching
 */
package com.leetcode.video_stitching;
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

    public int videoStitching(int[][] clips, int T) {
        int[] maxn = new int[T];
        int ret = 0, last = 0, pre = 0;

        for(int[] clip : clips) {
            if(clip[0] < T) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }

        for(int i = 0; i < T; i++) {
            last = Math.max(last, maxn[i]);
            if(last <= i) {
                return -1;
            }

            if(i == pre) {
                pre = last;
                ret++;
            }
        }

        return ret;
    }

}
