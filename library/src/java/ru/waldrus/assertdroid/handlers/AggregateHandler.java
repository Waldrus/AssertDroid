package ru.waldrus.assertdroid.handlers;

import java.util.ArrayList;
import java.util.List;

import ru.waldrus.assertdroid.AssertDroidError;
import ru.waldrus.assertdroid.Handler;

/**
 * Created by Wald on 13.04.2014.
 */
public class AggregateHandler implements Handler {
    private List<Handler> mHandlers = new ArrayList<>();

    public AggregateHandler(){

    }

    public void add(Handler handler){
        mHandlers.add(handler);
    }

    public void remote(Handler handler){
        mHandlers.remove(handler);
    }

    @Override
    public void onHandle(AssertDroidError ae) {
        int count = mHandlers.size();
        for (int i = 0; i < count; i++){
            mHandlers.get(i).onHandle(ae);
        }
    }
}
