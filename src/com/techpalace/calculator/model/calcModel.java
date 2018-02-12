package com.techpalace.calculator.model;

/**
 * Created by momen on 2/10/2018.
 */
public class calcModel {
    private static int  res;

    public static boolean isComputedFlag() {
        return computedFlag;
    }

    public static void setComputedFlag(boolean computedFlag) {
        calcModel.computedFlag = computedFlag;
    }

    private static boolean computedFlag;
    public static int getRes() {
        return res;
    }

    public static void setRes(int res) {
        calcModel.res = res;
    }
}
