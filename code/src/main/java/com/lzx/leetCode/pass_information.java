package com.lzx.leetCode;
/**
 * @author lizhengxin<lizhengxin.lzx @ bytedance.com>
 * @date 07/01/2021 5:56 下午
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * *****************************************************
 * Copyright (C) 2021 bytedance.com. All Rights Reserved
 * This file is part of bytedance EA project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
class fixLengthPath {
    private int bfs(Map<Integer, List<Integer>> G, int k, int n){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(0);
        Q.offer(-1);
        int time = 0;
        int res = 0;
        while (!Q.isEmpty() && time <= k){
            Integer v = Q.poll();
            if(v == -1){
                time += 1;
                Q.offer(-1);
            }
            else if(time == k && v == n - 1)
                res += 1;
            else{
                for(Integer t : G.getOrDefault(v, new ArrayList<>())){
                    Q.offer(t);
                }
            }
        }
        return res;
    }
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> G = new HashMap<>();
        for(int i=0;i<relation.length;i++){
            int x = relation[i][0], y = relation[i][1];
            List<Integer> list = G.getOrDefault(x, new ArrayList<>());
            list.add(y);
            G.put(x, list);
        }
        return bfs(G, k, n);

    }

    public static void main(String[] args) {
        int[][] relation = {{0,1},{1,0}};
        int n = 2;
        int k = 3;
        System.out.println(new fixLengthPath().numWays(n, relation, k));
    }
}
