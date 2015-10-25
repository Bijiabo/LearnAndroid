package com.bijiabo.firstapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //set button_1
        Button button_1 = (Button) findViewById(R.id.button_1);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.button_1, Toast.LENGTH_SHORT).show();
            }
        });

        //set button_2
        Button button_2 = (Button) findViewById(R.id.button_2);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Log.v("Verbose","MainActivity onCreate function did run.");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You tapped Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You tapped Remove", Toast.LENGTH_SHORT).show();
                break;
            case R.id.open_second_activity:
                //Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Intent intent = new Intent("com.bijiabo.activitytest.ACTION_START");
                intent.addCategory("com.bijiabo.activitytest.MY_CATEGORY");
                String textString = getString(R.string.crazyOnes);
                intent.putExtra("textString", textString);
                //startActivity(intent);
                startActivityForResult(intent, 1);
                break;
            case R.id.open_baidu:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                break;
            case R.id.open_Bijiabo:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.bijiabo.com"));
                startActivity(intent);
                break;
            case R.id.call_10086:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == Activity.RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("MainActivity", returnedData);
                }
                break;
            default:
        }
    }
}
