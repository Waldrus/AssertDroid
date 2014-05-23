package ru.waldrus.assertdroid;

import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Wald on 11.04.2014.
 */
public class AssertView extends AssertComponent<AssertView, View> {

    private AssertView(View view) {
        super(view);
    }

    public static AssertView assertThat(View view){
        return new AssertView(view);
    }
    
    public AssertView assertEnabled(){
        notNull();
        Assert.assertTrue(mObject.isEnabled());
        return true;
    }
    
    public AssertView assertDisabled(){
        notNull();
        Assert.assertFalse(mObject.isEnabled());
        return true;
    }
    
    public AssertView assertVisible(){
        notNull();
        Assert.assertTrue(mObject.getVisibility() == View.VISIBLE);
        return this;
    }
    
    public AssertView assertInvisible(){
        notNull();
        Assert.assertTrue(mObject.getVisibility() == View.INVISIBLE);
        return this;
    }
    
    public AssertView assertGone(){
        notNull();
        Assert.assertTrue(mObject.getVisibility() == View.GONE);
        return this;
    }
    
    public AssertView assertNotVisible(){
        notNull();
        Assert.assertTrue(mObject.getVisibility() != View.VISIBLE);
        return this;
    }
    
    public AssertView assertIsLayout(){
        notNull();
        Assert.assertTrue(mObject instanceof ViewGroup);
        return this;
    }
    
    public AssertView assertNotLayout(){
        notNull();
        Assert.assertFalse(mObject instanceof ViewGroup);
        return this;
    }
    
    public AssertView assertContainsChild(int count){
        assertIsLayout();
        Assert.assertTrue(((ViewGroup)mObject).getChildCount() > 0);
        return this;
    }
}
