/**
 * Leetcode - Add_Two_Numbers
 */
package com.leetcode.Add_Two_Numbers;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface Solution {

    // use this Object to print the log (call from slf4j facade)
    static Logger log = LoggerFactory.getLogger(Solution.class);

    ListNode addTwoNumbers(ListNode l1, ListNode l2);
    
}
