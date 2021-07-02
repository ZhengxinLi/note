package com.lzx.leetCode;
/**
 * @author lizhengxin<lizhengxin.lzx @ bytedance.com>
 * @date 07/02/2021 5:15 下午
 **/

import java.util.Arrays;

/**
 * *****************************************************
 * Copyright (C) 2021 bytedance.com. All Rights Reserved
 * This file is part of bytedance EA project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        int sum = 0;
        for(int t : costs){
            sum += t;
            if(sum <= coins)
                res += 1;
            else{
                return res;
            }
        }
        return res;
    }
}
