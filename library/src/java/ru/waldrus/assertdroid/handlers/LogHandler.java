package ru.waldrus.assertdroid.handlers;

import android.os.Build;
import android.util.Log;

import ru.waldrus.assertdroid.AssertDroidError;
import ru.waldrus.assertdroid.Handler;

/**
 * Created by Wald on 13.04.2014.
 */
public class LogHandler implements Handler {
    private String mTag;
    private String mMessage;
    private int mLevel;

    public LogHandler(){
        this(Log.ASSERT);
    }

    public LogHandler(int level){
        this("LogHandler", level);
    }

    public LogHandler(String tag, int level){
        this(tag, "Assertion", level);
    }

    public LogHandler(String tag, String message, int level){
        mTag = tag;
        mLevel = level;
        mMessage = message;
    }

    @Override
    public void onHandle(AssertDroidError ae) {
        switch (mLevel){
            case Log.ASSERT:
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.FROYO){
                    Log.e(mTag, mMessage, ae);
                } else {
                    Log.wtf(mTag, mMessage, ae);
                }
                break;
            case Log.INFO:
                Log.i(mTag, mMessage, ae);
                break;
            case Log.VERBOSE:
                Log.v(mTag, mMessage, ae);
                break;
            case Log.DEBUG:
                Log.d(mTag, mMessage, ae);
                break;
            case Log.WARN:
                Log.w(mTag, mMessage, ae);
                break;
            case Log.ERROR:
                Log.e(mTag, mMessage, ae);
                break;
        }
    }
}
