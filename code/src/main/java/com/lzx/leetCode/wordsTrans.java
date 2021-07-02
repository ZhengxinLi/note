package com.lzx.leetCode;
/**
 * @author lizhengxin<lizhengxin.lzx @ bytedance.com>
 * @date 06/29/2021 9:14 下午
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * *****************************************************
 * Copyright (C) 2021 bytedance.com. All Rights Reserved
 * This file is part of bytedance EA project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
class wordsTrans {
    private char[] des;
    private Set<String> con = new HashSet<>();
    private Map<Integer,Set<Character>> pos = new HashMap<>();
    private Set<String> seen = new HashSet<>();
    public boolean checkout(char[] source){
        for(int i=0;i<source.length;i++) {
            if (source[i] != des[i])
                return false;
        }
        return true;
    }
    public List<String> dfs(char[] s, List<String> path){
        if(checkout(s))
            return path;
        for(int i = 0; i < s.length;i++){  // 选谁来变
            for(char k : pos.get(i)){
                if(k != s[i]){
                    char[] t = Arrays.copyOf(s, s.length);
                    t[i] = k;
                    if(con.contains(String.valueOf(t)) && !seen.contains(String.valueOf(t))){
                        seen.add(String.valueOf(t));
                        path.add(String.valueOf(t));
                        List<String> res1 = dfs(t, path);
                        if(res1 != null)
                            return res1;
                        path.remove(path.size() - 1);
                    }
                }
            }
        }
        return null;
    }
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        des = new char[endWord.length()];
        char[] source = new char[beginWord.length()];
        for(int i=0;i<endWord.length();i++) {
            source[i] = beginWord.charAt(i);
            des[i] = endWord.charAt(i);
        }
        con.addAll(wordList);
        for(String s : wordList){
            for(int i =0;i<s.length();i++){
                Set<Character> t = pos.getOrDefault(i, new HashSet<Character>());
                t.add(s.charAt(i));
                pos.put(i, t);
            }
        }
        seen.add(beginWord);
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        return dfs(source, list);
    }

    public static void main(String[] args) {
        String beginWord = "hit";
            String endWord = "cog";
            String[] wordList = {"hot","dot","dog","lot","log","cog"};
            List<String> wordlist2 = Arrays.asList(wordList);
        System.out.println(new wordsTrans().findLadders(beginWord, endWord, wordlist2));

    }
}
