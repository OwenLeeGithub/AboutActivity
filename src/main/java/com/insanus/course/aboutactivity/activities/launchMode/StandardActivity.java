package com.insanus.course.aboutactivity.activities.launchMode;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.insanus.course.aboutactivity.R;
import com.insanus.course.aboutactivity.activities.view.StackView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class StandardActivity extends AppCompatActivity {
    public static Set<Context> launchModeTask = new HashSet<>();
    private StackView stackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);
        init();
        launchModeTask.add(this);
        List list = new ArrayList();
        list.addAll(launchModeTask);
        stackView.setList(list);
        stackView.invalidate();
    }

    public void onClick(View view) {
        startActivity(new Intent(this, StandardActivity.class));
    }

    private void init() {
        stackView = (StackView) findViewById(R.id.standerd_stack);
    }

    @Override
    protected void onDestroy() {
        launchModeTask.remove(this);
        List list = new ArrayList();
        list.addAll(launchModeTask);
        stackView.setList(list);
        stackView.invalidate();
        super.onDestroy();
    }
}
