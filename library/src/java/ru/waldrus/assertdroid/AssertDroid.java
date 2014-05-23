package ru.waldrus.assertdroid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.view.View;

/**
 * Created by Wald on 11.04.2014.
 */
public class AssertDroid extends Assert {
    public static AssertDroidConfig init(Context context){
        return new AssertDroidConfig(context);
    }

    public static AssertDroidConfig init(boolean debug){
        return new AssertDroidConfig(debug);
    }
    
    public static AssertDroidConfig getConfig(){
        return new AssertDroidConfig();
    }

    public static AssertActivity assertThat(Activity activity){
        return AssertActivity.assertThat(activity);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static AssertFragment assertThat(Fragment fragment){
        return AssertFragment.assertThat(fragment);
    }

    public static AssertView assertThat(View view){
        return AssertView.assertThat(view);
    }
}
