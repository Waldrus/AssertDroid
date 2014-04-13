package ru.waldrus.assertdroid;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;

/**
 * Created by Wald on 13.04.2014.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class AssertFragment extends AssertComponent<Fragment, AssertFragment> {

    private AssertFragment(Fragment fragment){
        super(fragment);
    }

    public static AssertFragment assertThat(Fragment fragment){
        return new AssertFragment(fragment);
    }
}
