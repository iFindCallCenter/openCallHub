package com.och.common.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.HashSet;
import java.util.Set;

/**
 * DFA算法 工具类
 *
 * @author danmo
 * @date 2024-01-10 10:10
 **/
public class DFAUtil {

    public static final int minMatchType = 1;

    public static final int maxMatchType = 2;

    /*{1=
     *     {2=
     *         {人={isEnd=1},
     *         3=
     *             {4={isEnd=1},
     *             isEnd=0},
     *         isEnd=0},
     *     isEnd=0},
     *
     * 5=
     *     {6=
     *         {7={isEnd=0,
     *             8={isEnd=1}},
     *         isEnd=0},
     *     isEnd=0,
     *     9={isEnd=0,
     *         10={isEnd=1,
     *             11={isEnd=0,
     *                 12={isEnd=1}}}}}}*/

    /**
     * set作为敏感词，创建出对应的dfa的Map，以供检验敏感词
     *
     * @param set
     */
    public static JSONObject createDFAHashMap(Set<String> set) {
        //根据set的大小，创建map的大小
        JSONObject nowMap = new JSONObject(set.size());
        //对set里的字符串进行循环
        for (String key : set) {
            for (int i = 0; i < key.length(); i++) {
                //一个个字符循环
                String nowChar = String.valueOf(key.charAt(i));
                //根据nowChar得到nowMap里面对应的value
                JSONObject map = nowMap.getJSONObject(nowChar);
                //如果map为空，则说明nowMap里面没有以nowChar开头的东西，则创建一个新的hashmap，
                //以nowChar为key，新的map为value，放入nowMap
                if (map == null) {
                    map = new JSONObject();
                    nowMap.put(nowChar, map);
                }
                //nowMap=map，就是nowChar对应的对象
                nowMap = map;
                //最后在nowMap里设置isEnd
                //如果nowMap里面已经有isEnd，并且为1，说明以前已经有关键字了，就不再设置isEnd
                //因为如果没有这一步，123和12345，先设置大123
                //在12345设置的时候，华对应的map有isEnd=1，如果这时对它覆盖，就会isEnd=0，导致123这个关键字失效
                if (nowMap.containsKey("isEnd") && nowMap.get("isEnd").equals("1")) {
                    continue;
                }
                if (i != key.length() - 1) {
                    nowMap.put("isEnd", "0");
                } else {
                    nowMap.put("isEnd", "1");
                }
            }
        }
        return nowMap;
    }


    /**
     * 用创建的dfaMap，根据matchType检验字符串string是否包含敏感词，返回包含所有对于敏感词的set
     *
     * @param string    要检查是否有敏感词在内的字符串
     * @param matchType 检查类型，如123对应123456两个关键字，1为最小检查，会检查出123，2位最大，会检查出12345
     * @return
     */
    public static Set<String> getSensitiveWordByDFAMap(JSONObject dataMap, String string, int matchType) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            //matchType是针对同一个begin的后面，在同一个begin匹配最长的还是最短的敏感词
            int length = getSensitiveLengthByDFAMap(dataMap, string, i, matchType);
            if (length > 0) {
                set.add(string.substring(i, i + length));
                //这个对应的是一个敏感词内部的关键字（不包括首部），如果加上，123，对应123和12两个敏感词，只会对应123而不是两个
                //i=i+length-1;//减1的原因，是因为for会自增
            }
        }
        return set;
    }


    /**
     * 如果存在，则返回敏感词字符的长度，不存在返回0
     *
     * @param string
     * @param beginIndex
     * @param matchType  1：最小匹配规则，2：最大匹配规则
     * @return
     */
    public static int getSensitiveLengthByDFAMap(JSONObject dataMap, String string, int beginIndex, int matchType) {
        //当前匹配的长度
        int nowLength = 0;
        //最终匹配敏感词的长度，因为匹配规则2，如果123，对应12，123，在2的时候，nowLength=3，因为是最后一个字，将nowLenth赋给resultLength
        //然后在3的时候，now=4，result=3，然后不匹配，resultLength就是上一次最大匹配的敏感词的长度
        int resultLength = 0;
        JSONObject nowMap = dataMap;
        for (int i = beginIndex; i < string.length(); i++) {
            String nowChar = String.valueOf(string.charAt(i));
            //根据nowChar得到对应的map，并赋值给nowMap
            nowMap = nowMap.getJSONObject(nowChar);
            //nowMap里面没有这个char，说明不匹配，直接返回
            if (nowMap == null) {
                break;
            } else {
                nowLength++;
                //如果现在是最后一个，更新resultLength
                if ("1".equals(nowMap.get("isEnd"))) {
                    resultLength = nowLength;
                    //如果匹配模式是最小，直接匹配到，退出
                    //匹配模式是最大，则继续匹配，resultLength保留上一次匹配到的length
                    if (matchType == minMatchType) {
                        break;
                    }
                }
            }
        }
        return resultLength;
    }
}
