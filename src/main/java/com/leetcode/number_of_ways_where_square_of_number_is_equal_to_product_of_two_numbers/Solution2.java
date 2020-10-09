/**
 * Leetcode - number_of_ways_where_square_of_number_is_equal_to_product_of_two_numbers
 */
package com.leetcode.number_of_ways_where_square_of_number_is_equal_to_product_of_two_numbers;
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

    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return calc(nums1, nums2) + calc(nums2, nums1);
    }

    public int calc(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        //存储本次计算符合条件的结果总数
        int sum = 0;
        //记录上一个目标值，符合条件的结果数
        int gap = 0;
        //arr2是排序过的数组，用两个指针分别指向首尾

        //这个变量记录头部指针的起始位置
        int curBegin = 0;
        for (int i = 0; i < len1; i++) {
            //从第二个数开始，如果这个数之前已经出现过了，那么它对应的符合条件的结果数已经计算过了，存储在tap中，直接累加即可，无需再进行计算
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                sum += gap;
                continue;
            }
            //否则需要重新计算 累加值gap清零
            gap = 0;
            //目标值 每次计算的target都是不同的值 是升序的
            long target = (long) arr1[i] * (long) arr1[i];
            //尾部指针始终从最后一个数开始
            int end = len2 - 1;
            //头部指针从curBegin开始
            int begin = curBegin;
            //存储当前首尾指针指向数的乘积
            long now;
            //这里的循环是用于改变每次头部指针的起始位置 更新curBegin
            while (begin < end) {
                now = (long) arr2[begin] * (long) (arr2[end]);
                //由于arr1是升序的，target也是升序的
                //当前begin位置如果和最大的end乘积都小于目标值的话，目标值是不断增大的，下一次头指针开始的位置可以后移动curBegin
                if (now < target) {
                    begin++;
                    //更新头部指针的位置
                    curBegin++;
                } else {
                    break;
                }
            }
            //如果小于目标值，首部指针不断后移；如果大于目标值，尾部指针前移；如果等于目标针则计算符合的组数，更新指针位置。
            while (begin < end) {
                now = (long) arr2[begin] * (long) arr2[end];
                //等于目标针则计算符合的组数，更新指针位置。
                if (now == target) {
                    //条件1，是begin->end都是相同的数，那么符合条件的组数是排列组合Cn2,其中n=end-begin+1
                    //比如 target=4, arr2中begin中有2,2,2,2,2，那么符合的组数是任意两个组合在一起都符合
                    if (arr2[begin] == arr2[end]) {
                        gap += (end - begin) * (end - begin + 1) / 2;
                        break;
                    } else {
                        //一般的情况
                        // 计算符合的组数  比如说符合的begin值为2 end值为7，对于 2224457777，符合条件的组数应该等于2的个数乘以7的个数
                        int firstStep = begin + 1;
                        int secondStep = end - 1;
                        //更新begin找到下一个和当前值不同的位置
                        while (firstStep < end && arr2[firstStep] == arr2[begin]) {
                            firstStep++;
                        }
                        //更新end找到下一个和当前值不同的位置
                        while (secondStep > begin && arr2[secondStep] == arr2[end]) {
                            secondStep--;
                        }
                        //计算符合的组数  比如说符合的begin值为2 end值为7，对于 2224457777，符合条件的组数应该等于2的个数乘以7的个数
                        gap += (end - secondStep) * (firstStep - begin);
                        //更新位置
                        begin = firstStep;
                        end = secondStep;
                    }
                    //如果大于目标值，尾部指针前移；
                } else if (now > target) {
                    //找到下一个与当前end指向数值不同的位置
                    int next = end - 1;
                    while (next > begin && arr2[end] == arr2[next]) {
                        next--;
                    }
                    end = next;
                    // 如果小于目标值，首部指针不断后移；
                } else if (now < target) {
                    //找到下一个与当前begin指向数值不同的位置
                    int next = begin + 1;
                    while (next < end && arr2[next] == arr2[begin]) {
                        next++;
                    }
                    begin = next;
                }
            }
            sum += gap;
        }
        return sum;
    }

}
