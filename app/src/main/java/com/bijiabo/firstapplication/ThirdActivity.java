package com.bijiabo.firstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by huchunbo on 15/10/26.
 */
public class ThirdActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_ACTION_BAR);

        setContentView(R.layout.third_layout);
    }
}
