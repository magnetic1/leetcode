package com.wzq;

public class SegmentTree {
    private int MAXN;
    private int[] arr;
    private int[] sum;
    private int[] lazy;
    private int[] change;
    private boolean[] update;

    public SegmentTree(int[] origin) {
        MAXN = origin.length + 1;
        arr = new int[MAXN];
        System.arraycopy(origin, 0, arr, 1, origin.length);

        sum = new int[MAXN << 2];
        lazy = new int[MAXN << 2];
        change = new int[MAXN << 2];
        update = new boolean[MAXN << 2];
    }

    // rt: 在sum中的下标。
    public void build(int l, int r, int rt) {
        if (l == r) {
            sum[rt] = arr[l];
            return;
        }

        int mid = (l + r) / 2;
        build(l, mid, rt * 2);
        build(l, mid, rt * 2 + 1);
        pushUp(rt);
    }

    private void pushUp(int rt) {
        sum[rt] = sum[rt * 2] + sum[rt * 2 + 1];
    }

    // L..R -> 任务范围，所有值累加C
    // l, r -> 表达的范围
    // rt   -> l-r范围对应下标
    public void add(
            int L, int R, int C,
            int l, int r, int rt
    ) {
        if (L <= l && r <= R) {
            sum[rt] += C * (r - l + 1);
            lazy[rt] += C;
            return;
        }

        int mid = (l + r) / 2;
        pushDown(rt, mid - l + 1, r - mid);
        if (L <= mid) {
            add(L, R, C, l, mid, rt * 2);
        }
        if (R > mid) {
            add(L, R, C, mid + 1, r, rt * 2 + 1);
        }
        pushUp(rt);
    }

    public void update(
            int L, int R, int C,
            int l, int r, int rt
    ) {
        if (L <= l && r <= R) {
            update[rt] = true;
            change[rt] = C;
            sum[rt] = C * (r - l + 1);
            lazy[rt] = 0;
            return;
        }

        int mid = (l + r) / 2;
        pushDown(rt, mid - l + 1, r - mid);
        if (L <= mid) {
            update(L, R, C, l, mid, rt * 2);
        }
        if(R > mid) {
            update(L, R, C, mid + 1, r, rt * 2 + 1);
        }
        pushUp(rt);
    }

    public long query(int L, int R, int l, int r, int rt) {
        if (L <= l && r <= R) {
            return sum[rt];
        }
        int mid = (l + r) / 2;
        pushDown(rt, mid - l + 1, r - mid);
        long ans = 0;
        if (L <= mid) {
            ans += query(L, R, l, mid, rt * 2);
        }
        if (R > mid) {
            ans += query(L, R, mid + 1, r, rt * 2 + 1);
        }
        return ans;
    }

    private void pushDown(int rt, int ln, int rn) {
        if (update[rt]) {
            update[rt * 2] = true;
            update[rt * 2 + 1] = true;

            change[rt * 2] = change[rt];
            change[rt * 2 + 1] = change[rt];

            lazy[rt * 2] = lazy[rt * 2 + 1] = 0;
            sum[rt * 2] = change[rt] * ln;
            sum[rt * 2 + 1] = change[rt] * rn;

            update[rt] = false;
        }
        if (lazy[rt] != 0) {
            lazy[rt * 2] += lazy[rt];
            sum[rt * 2] += lazy[rt] * ln;

            lazy[rt * 2 + 1] += lazy[rt];
            sum[rt * 2 + 1] += lazy[rt] * rn;

            lazy[rt] = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(test());
    }

    static class Right {
        public int[] arr;

        public Right(int[] origin) {
            arr = new int[origin.length + 1];
            System.arraycopy(origin, 0, arr, 1, origin.length);
        }

        public void update(int L, int R, int C) {
            for (int i = L; i <= R; i++) {
                arr[i] = C;
            }
        }

        public void add(int L, int R, int C) {
            for (int i = L; i <= R; i++) {
                arr[i] += C;
            }
        }

        public long query(int L, int R) {
            long ans = 0;
            for (int i = L; i <= R; i++) {
                ans += arr[i];
            }
            return ans;
        }
    }

    public static int[] generateRandomArray(int len, int max) {
        int size = (int) (Math.random() * len) + 1;
        int[] origin = new int[size];
        for (int i = 0; i < size; i++) {
            origin[i] = (int) (Math.random() * max) - (int) (Math.random() * max);
        }
        return origin;
    }

    public static boolean test() {
        int len = 100;
        int max = 1000;
        int testTimes = 5000;
        int addOrUpdateTimes = 1000;
        int queryTimes = 500;

        for (int i = 0; i < testTimes; i++) {
            int[] origin = generateRandomArray(len, max);
            SegmentTree seg = new SegmentTree(origin);

            int S = 1;
            int N = origin.length;
            int root = 1;
            seg.build(S, N, root);

            Right rig = new Right(origin);

            for (int j = 0; j < addOrUpdateTimes; j++) {
                int nums1 = (int) (Math.random() * N) + 1;
                int nums2 = (int) (Math.random() * N) + 1;
                int L = Math.min(nums1, nums2);
                int R = Math.max(nums1, nums2);
                int C = (int) (Math.random() * max) - (int) (Math.random() * max);
                if (Math.random() < 0.5) {
                    seg.add(L, R, C, S, N, root);
                    rig.add(L, R, C);
                } else {
                    seg.update(L, R, C, S, N, root);
                    rig.update(L, R, C);
                }
            }
            for (int k = 0; k < queryTimes; k++) {
                int nums1 = (int) (Math.random() * N) + 1;
                int nums2 = (int) (Math.random() * N) + 1;
                int L = Math.min(nums1, nums2);
                int R = Math.max(nums1, nums2);
                long ans1 = seg.query(L, R, S, N, root);
                long ans2 = rig.query(L, R);
                if (ans1 != ans2) {
                    return false;
                }
            }
        }
        return true;
    }
}
