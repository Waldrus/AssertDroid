package ru.waldrus.assertdroid;

import android.app.Activity;

/**
 * Created by Wald on 13.04.2014.
 */
public class AssertActivity extends AssertComponent<AssertActivity, Activity> {

    private AssertActivity(Activity activity) {
        super(activity);
    }

    public static AssertActivity assertThat(Activity activity){
        return new AssertActivity(activity);
    }

}
