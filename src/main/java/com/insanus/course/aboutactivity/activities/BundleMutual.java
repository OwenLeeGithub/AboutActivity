package com.insanus.course.aboutactivity.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.insanus.course.aboutactivity.R;

public class BundleMutual extends AppCompatActivity {

    public static final String KEY = "BUNDLE_KEY";
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle_mutual);
        init();
    }

    private void init() {
        editText = (EditText) findViewById(R.id.bundle_edit);
    }

    public void onClick(View view) {
        String str = editText.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString(KEY, str);

        Intent intent = new Intent(this, BundleShow.class);
        intent.putExtra("BundleMutual", bundle);
        startActivity(intent);
    }
}
