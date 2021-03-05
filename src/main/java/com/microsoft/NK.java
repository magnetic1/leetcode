package com.microsoft;

import java.util.*;

public class NK {
    int ans = Integer.MAX_VALUE;

    public int solve(int N, int K, int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        int dup_max = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            dup_max = Math.max(dup_max, map.get(arr[i]));
        }
        //重复数字出现最多的个数，如果大于N/K的话，不能划分，直接返回0
        if (dup_max > N / K) {
            return 0;
        }
        int[] num = new int[N];
        int[] flag = new int[N];
        //用于判断分组中的重复元素
        Set<Integer> set = new HashSet<>();
        helper(N, K, 0, arr, num, flag, set);
        return ans;

    }

    //dfs + 剪枝
    public void helper(int N, int K, int index, int[] arr, int[] num, int[] flag, Set<Integer> set) {
        //index==N,说明分组完毕，计算每个子数组最大最小元素的差值之和
        if (index == N) {
            int res = 0;

            for (int i = 0; i < num.length; i += K) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int j = i; j < i + K; j++) {
                    min = Math.min(min, num[j]);
                    max = Math.max(max, num[j]);
                }
                res += Math.abs(max - min);
            }

            if (res < ans) {
                ans = res;
                for (int i = 0; i < num.length; i++) {
                    System.out.print(num[i] + " ");
                }
                System.out.println();
                System.out.println(res);
            }

            return;
        }


        for (int i = 0; i < N; i++) {
            //剪枝
            if (flag[i] == 0) {
                if (set.contains(arr[i])) {
                    continue;
                }
                set.add(arr[i]);
                flag[i] = 1;
                num[index] = arr[i];
                if ((index + 1) % K == 0) {
//                    set = ;
                    helper(N, K, index + 1, arr, num, flag, new HashSet<>());
                } else {
                    helper(N, K, index + 1, arr, num, flag, set);
                }

                set.remove(arr[i]);
                flag[i] = 0;
                num[index] = 0;

            }
        }
    }

    public static void main(String[] args) {
        NK nk = new NK();
        nk.solve(12, 4, new int[]{
                3, 3, 4, 4, 5, 5, 6, 6, 8, 8, 10, 10
        });
    }
}
