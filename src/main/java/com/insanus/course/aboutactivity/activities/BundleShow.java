package com.insanus.course.aboutactivity.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.insanus.course.aboutactivity.R;

public class BundleShow extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle_show);
        init();

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("BundleMutual");
        String str = bundle.getString(BundleMutual.KEY);

        textView.setText(str);

    }

    private void init() {
        textView = (TextView) findViewById(R.id.show_txt);
    }
}
