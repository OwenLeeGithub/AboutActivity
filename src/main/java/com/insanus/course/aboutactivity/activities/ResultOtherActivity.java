package com.insanus.course.aboutactivity.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.insanus.course.aboutactivity.R;

public class ResultOtherActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_other);
        init();

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("ResultActivity");
        String str = bundle.getString(ResultActivity.KEY);

        textView.setText(str);


        bundle.putString("ResultOtherActivity", "返回的值");
        intent.putExtras(bundle);
        setResult(0, intent);
    }

    private void init() {
        textView = (TextView) findViewById(R.id.result_txt);
    }
}
