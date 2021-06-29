package com.lzx.leetCode;
/**
 * @author lizhengxin<lizhengxin.lzx @ bytedance.com>
 * @date 06/28/2021 9:25 下午
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;
import java.util.Queue;

/**
 * *****************************************************
 * Copyright (C) 2021 bytedance.com. All Rights Reserved
 * This file is part of bytedance EA project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        int node = routes.length;
        boolean[][] graph = new boolean[node][node];
        Map<Integer, List<Integer>> res = new HashMap<>();
        for(int i=0;i<node;i++){
            for(int j : routes[i]){
                List<Integer> t = res.getOrDefault(j, new ArrayList<>()); // key：路牌j，value：经过key的车编号
                for(int k : t){
                    graph[i][k] = graph[k][i] = true;
                }
                t.add(i);
                res.put(j, t);
            }
        }
        int[] dis = new int[node];
        Arrays.fill(dis, -1);
        Queue<Integer> que = new LinkedList<>();
        for(int bus : res.getOrDefault(source, new ArrayList<>())){
            dis[bus] = 1;
            que.offer(bus);
        }
        while (!que.isEmpty()){
            int x = que.poll();
           for(int bus:res.getOrDefault(x, new ArrayList<>())){
               if(dis[bus] == -1){
                   dis[bus] = dis[x] + 1;
                   que.offer(bus);
               }
           }
        }

        int ret = Integer.MAX_VALUE;
        for (int bus : res.getOrDefault(target, new ArrayList<Integer>())) {
            if (dis[bus] != -1) {
                ret = Math.min(ret, dis[bus]);
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;


    }

    public static void main(String[] args) {

    }

}
