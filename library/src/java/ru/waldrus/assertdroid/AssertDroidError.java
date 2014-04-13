package ru.waldrus.assertdroid;

/**
 * Created by Wald on 13.04.2014.
 */
public class AssertDroidError extends AssertionError {
    public AssertDroidError(String message){
        super(message);
    }

    public AssertDroidError(){
        super();
    }
}
