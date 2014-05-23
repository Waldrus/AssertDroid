package ru.waldrus.assertdroid;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import ru.waldrus.assertdroid.handlers.AggregateHandler;

/**
 * Created by Wald on 13.04.2014.
 */
public class AssertDroidConfig {
    /* package */ AssertDroidConfig(Context context){
        this((context.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) > 0);
    }

    /* package */ AssertDroidConfig(boolean debug){
        Assert.DEBUG = debug;
    }
    
    /* package */ AssertDroidConfig(){
        
    }

    public AssertDroidConfig setHandleOnDebug(boolean handle){
        if (handle){
            Assert.HANDLE_LEVEL |= Assert.HANDLE_DEBUG;
        } else {
            Assert.HANDLE_LEVEL &= ~Assert.HANDLE_DEBUG;
        }
        return this;
    }

    public AssertDroidConfig setHandle(boolean handle){
        if (handle){
            Assert.HANDLE_LEVEL |= Assert.HANDLE_NORMAL;
        } else {
            Assert.HANDLE_LEVEL &= ~Assert.HANDLE_NORMAL;
        }
        return this;
    }

    public AssertDroidConfig setHandler(Handler handler){
        Assert.HANDLER = handler;
        return this;
    }
    
    public AssertDroidConfig appendHandler(Handler handler){
        if (null == Assert.HANDLER){
            setHandler(handler);
        } else if (Assert.HANDLER instanceof AggregateHandler){
            Assert.HANDLER.add(handler);
        } else {
            AggregateHandler aggregate = new AggregateHandler();
            aggregate.add(Assert.HANDLER);
            aggregate.add(handler);
            Assert.HANDLER = aggregate;
        }
        return this;
    }
}
