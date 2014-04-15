package ru.waldrus.assertdroid;

import android.view.View;

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
}
