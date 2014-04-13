
package ru.waldrus.assertdroid.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;


import ru.waldrus.assertdroid.Assert;
import ru.waldrus.assertdroid.AssertDroid;

public class SampleActivity  extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent();
       // junit.framework.Assert.assertSame(i, getIntent());
        AssertDroid.init(this);
        AssertDroid.assertThat(this).notNull();
        //Assert.assertTrue(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater();
        return true;
    }

}
