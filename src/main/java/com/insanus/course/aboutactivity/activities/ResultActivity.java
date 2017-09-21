package com.insanus.course.aboutactivity.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.insanus.course.aboutactivity.R;

public class ResultActivity extends AppCompatActivity {

    private Button button;
    public final static String KEY = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, ResultOtherActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(KEY, "这是一个文本");
                intent.putExtra("ResultActivity", bundle);
                startActivityForResult(intent, 0);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0 && resultCode == 0) {
            Bundle bundle = data.getExtras();
            String result = bundle.getString("ResultOtherActivity");
            button.setText(result);
        }
    }

    private void init() {
        button = (Button) findViewById(R.id.result_btn);
    }
}
