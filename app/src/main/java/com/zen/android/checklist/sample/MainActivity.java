package com.zen.android.checklist.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView mTvContent;
    EditText mEtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvContent = (TextView) findViewById(R.id.tv_content);
        mEtInput = (EditText) findViewById(R.id.et_input);

        findViewById(R.id.btn_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                Intent intent = new Intent(MainActivity.this, MergeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        new AsyncTask<Integer, Void, Void>() {

            @Override
            protected Void doInBackground(Integer... datas) {
//                SystemClock.sleep(200);
                int total = 0;
                for (int data : datas) {
                    total += data;
                }
                mTvContent.setText("" + total);
                return null;
            }
        }.execute(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}
