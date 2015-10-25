package com.bijiabo.firstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.Vector;

/**
 * Created by huchunbo on 15/10/26.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.second_layout);

        //get Intent
        Intent intent = getIntent();
        String contentString = intent.getStringExtra("textString");

        //update Content text
        TextView contentTextView = (TextView) findViewById(R.id.textView2);
        contentTextView.setText(contentString);

        //set button_3
        Button button_3 = (Button) findViewById(R.id.button_3);
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello MainActivity,I am SecondActivty!");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello MainActivity,I am SecondActivty!");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
