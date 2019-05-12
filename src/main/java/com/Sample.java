package com;

import opencc.OpenCC;

/**
 * @desc:
 * @author: panqiong
 * @date: 2019-05-11
 */
public class Sample {


    /**
     * 'hk2s': Traditional Chinese (Hong Kong standard) to Simplified Chinese
     *
     * 's2hk': Simplified Chinese to Traditional Chinese (Hong Kong standard)
     *
     * 's2t': Simplified Chinese to Traditional Chinese
     *
     * 's2tw': Simplified Chinese to Traditional Chinese (Taiwan standard)
     *
     * 's2twp': Simplified Chinese to Traditional Chinese (Taiwan standard, with phrases)
     *
     * 't2hk': Traditional Chinese to Traditional Chinese (Hong Kong standard)
     *
     * 't2s': Traditional Chinese to Simplified Chinese
     *
     * 't2tw': Traditional Chinese to Traditional Chinese (Taiwan standard)
     *
     * 'tw2s': Traditional Chinese (Taiwan standard) to Simplified Chinese
     *
     * 'tw2sp': Traditional Chinese (Taiwan standard) to Simplified Chinese (with phrases)
     * @param args
     */
    public static void main(String[] args) {
        // use default conversion "s2t", convert from Simplified Chinese to Traditional Chinese
        OpenCC openCC = new OpenCC();

        // can also set conversion when constructing
        openCC = new OpenCC("s2twp"); // convert from Simplified Chinese to Traditional Chinese (Taiwan Standard)

        // also can set a new conversion when needed
        //openCC.setConversion("s2hk");
        String toConvert = "滑鼠里面的矽二极体坏了，导致游标解析度降低。\n" +
                "我们在寮国的伺服器的硬碟需要使用网际网路演算法软体解决非同步的问题。\n" +
                "为什么你在床里面睡著？";
        String converted = openCC.convert(toConvert);
        System.out.println("converted = " + converted);
    }


}
