package com.zen.android.checklist.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends Activity {

    ListView mLvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mLvContent = (ListView) findViewById(R.id.lv_content);
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView header = (TextView)getLayoutInflater().inflate(android.R.layout.simple_list_item_1, null);
        header.setText(R.string.list);

        mLvContent.addHeaderView(header);
        mLvContent.setAdapter(new BaseAdapter() {

            private String[] data = new String[]{
                    "item1", "item2", "item3"};

            @Override
            public int getCount() {
                return data.length;
            }

            @Override
            public String getItem(int i) {
                return data[i];
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(android.R.layout.simple_list_item_2, null);
                }
                ((TextView) convertView.findViewById(android.R.id.text1)).setText(String.valueOf(position + 1));
//                ((TextView) convertView.findViewById(android.R.id.text1)).setText(position + 1);
                ((TextView) convertView.findViewById(android.R.id.text2)).setText(getItem(position));
                return convertView;
            }
        });
    }
}
