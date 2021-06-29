package com.lzx.leetCode;
/**
 * @author lizhengxin<lizhengxin.lzx @ bytedance.com>
 * @date 06/29/2021 6:24 下午
 **/

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * *****************************************************
 * Copyright (C) 2021 bytedance.com. All Rights Reserved
 * This file is part of bytedance EA project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
class ugly {
    public int getKthMagicNumber(int k) {
        Queue<Long> que = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        que.offer(1L);
        int[] factors = {3, 5, 7};
        Long s = 0L;
        for(int i = 0;i<k;i++){
            s = que.poll();
            for(int factor : factors){
                if(!seen.contains(factor * s)) {
                    seen.add(factor * s);
                    que.offer(factor * s);
                }
            }
        }
        return s.intValue();
    }
}
