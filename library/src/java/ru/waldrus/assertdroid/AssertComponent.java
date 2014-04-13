package ru.waldrus.assertdroid;

/**
 * Created by Wald on 13.04.2014.
 */
public class AssertComponent<C> {
    protected C mObject;
    protected AssertComponent(C object){
        mObject = object;
    }
}
