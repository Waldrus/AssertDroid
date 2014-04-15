package ru.waldrus.assertdroid;

/**
 * Created by Wald on 13.04.2014.
 */
public class AssertComponent<T extends AssertComponent, C> {
    protected C mObject;
    protected AssertComponent(C object){
        mObject = object;
    }

    public T notNull(){
        Assert.assertNotNull(mObject);
        return (T) this;
    }

    public T isNull(){
        Assert.assertNull(mObject);
        return (T) this;
    }

}
