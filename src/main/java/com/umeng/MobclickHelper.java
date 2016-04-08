package com.umeng;

import android.content.Context;
import android.util.Log;


import com.umeng.analytics.MobclickAgent;

import java.util.HashMap;


public class MobclickHelper {
    private static final String TAG = MobclickHelper.class.getName();

    private static boolean enable = true;

    public static void init(Context context) {
        MobclickHelper.context = context;
        MobclickAgent.openActivityDurationTrack(false);
    }

    private static Context context;


    public static void onResume() {
        if (!enable) return;
        MobclickAgent.onResume(context);
    }

    public static void onPause() {
        if (!enable) return;
        MobclickAgent.onPause(context);
    }

    public static void onEvent(String evenId) {
        if (!enable) return;
        Log.e(TAG, evenId);
        MobclickAgent.onEvent(context, evenId);
    }

    public static void onEvent(String evenId, HashMap hm) {
        if (!enable) return;
        Log.e(TAG, evenId);
        MobclickAgent.onEvent(context, evenId, hm);
    }

    public static void onEventValue(String evenId, HashMap hm, int v) {
        if (!enable) return;
        MobclickAgent.onEventValue(context, evenId, hm, v);
    }

    public static void onEventValue(String evenId, int v) {
        if (!enable) return;
        MobclickAgent.onEventValue(context, evenId, null, v);
    }

    public static void reportError(Throwable ex) {
        if (!enable) return;
        MobclickAgent.reportError(context, ex);
    }

    public static void onPageStart(String page) {
        if (!enable) return;
        MobclickAgent.onPageStart(page);
    }

    public static void onPageEnd(String page) {
        if (!enable) return;
        MobclickAgent.onPageEnd(page);
    }

    public static void setDebugMode(boolean b) {
        MobclickAgent.setDebugMode(b);
    }

    public static void disable() {
        MobclickHelper.enable = false;
    }

    public static void enable() {
        MobclickHelper.enable = true;
    }
}
