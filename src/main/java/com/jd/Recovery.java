package com.jd;

public class Recovery {

    public int recovery(int[] arr) {
        int n = arr.length;
        int[] p = new int[n + 2];
        p[0] = p[n + 1] = 1;
        System.arraycopy(arr, 0, p, 1, n);

        return dfs(p, 1, 0);

//        int pre = 0, cur = 1;
//        int ans = 1;
//        while (cur <= n) {
//            if (p[cur] == 0) {
//                ans *= getCounts(Math.abs(p[cur] - p[pre]), cur - pre);
//                pre = cur;
//            }
//            cur++;
//        }


//        return ans;
    }

    int dfs(int[] p, int i, int state) {
        int res = 0;
        if(i == p.length - 1) {
            return 1;
        }
        if (p[i] != 0) {
            if (p[i + 1] != 0 && p[i] > Math.max(p[i - 1], p[i + 1])) {
                return 0;
            } else {
                return dfs(p, i + 1, p[i - 1] - p[i]);
            }
        }

        if (p[i + 1] != 0) {
            int max = Math.max(p[i - 1], p[i + 1]);
            if (state >= 0) {
                for (int j = max; j >= 1; j--) {
                    p[i] = j;
                    int r = dfs(p, i + 1, p[i - 1] - p[i]);

                    res += r;
                }
            } else {
                for (int j = max; j >= p[i - 1]; j--) {
                    p[i] = j;
                    int r = dfs(p, i + 1, p[i - 1] - p[i]);

                    res += r;
                }
            }
            p[i] = 0;
            return res;
        }

        if (state <= 0) {
            for (int j = p[i - 1]; j <= 200; j++) {
                p[i] = j;
                int r = dfs(p, i + 1, p[i - 1] - p[i]);

                res += r;
            }
        } else {
            for (int j = 1; j <= 200; j++) {
                p[i] = j;
                int r = dfs(p, i + 1, p[i - 1] - p[i]);

                res += r;
            }
        }

        p[i] = 0;
        return res;
    }

    int getCounts(int gap, int dis) {
        if (dis == 1) {
            return 1;
        }
        if (gap == 0) {
            return 1;
        }

        if (dis == 2) {
            return gap + 1;
        }

        int res = 0;
        for (int i = gap; i >= 0; i--) {
            res += getCounts(i, dis - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Recovery recovery = new Recovery();
//        System.out.println(recovery.getCounts(6 - 3, 3));
        System.out.println(recovery.recovery(new int[]{
                0, 0, 2, 6, 0, 0, 0, 0, 1
        }));
    }
}
