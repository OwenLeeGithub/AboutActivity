package com.insanus.course.aboutactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.insanus.course.aboutactivity.activities.BundleMutual;

public class MainActivity extends AppCompatActivity {

    private final String[] activityName = {
            "观察Bundle的传递模式",
    };

    private final Class[] activities ={
            BundleMutual.class,
    };

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, activityName));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(view.getContext(), activities[position]));
            }
        });

    }

    private void init() {
        listView = (ListView) findViewById(R.id.activity_list);
    }
}
