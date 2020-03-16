package com.fz.leetcode.realize.medium;

import java.util.HashMap;

/**
 * @author fanzhen
 * @date 2020/2/7--14:15
 *
 * 和为K的子数组
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 这种方法背后的想法如下：如果累积总和（由 sum[i]sum[i] 表示加到 i^{th}i
 * th
 *   的和）最多两个指数是相同的，那么这些元素之间的元素总和为零。进一步扩展相同的想法，如果累计总和，在索引 ii 和 jj 处相差 kk，即 sum[i] - sum[j] = ksum[i]−sum[j]=k，则位于索引 ii 和 jj 之间的元素之和是 kk。
 *
 * 基于这些想法，可以使用了一个哈希表 mapmap，它用于存储所有可能的索引的累积总和以及相同累加和发生的次数。我们以以下形式存储数据：(sum_isum
 * i
 * ​
 *  ，sum_isum
 * i
 * ​
 *   的出现次数)。我们遍历数组numsnums并继续寻找累积总和。每当我们遇到一个新的和时，我们在hashmap中创建一个与该总和相对应的新条目。如果再次出现相同的和，我们增加与mapmap中的和相对应的计数。此外，对于遇到的每个总和，我们还确定已经发生 sum-ksum−k 总和的次数，因为它将确定具有总和 kk 的子阵列发生到当前索引的次数。我们将 countcount 增加相同的量。
 *
 * 在完成便利数组后，countcount 记录了所需结果
 */
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;


        HashMap< Integer, Integer > map = new HashMap < > ();


        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
