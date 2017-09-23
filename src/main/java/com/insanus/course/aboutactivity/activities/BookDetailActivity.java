package com.insanus.course.aboutactivity.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.insanus.course.aboutactivity.R;
import com.insanus.course.aboutactivity.fragment.TryFragment;

public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(savedInstanceState == null) {
            TryFragment fragment = new TryFragment();

            Bundle arguments = new Bundle();

            arguments.putInt(TryFragment.ITEM_ID, getIntent().getIntExtra(TryFragment.ITEM_ID, 0));

            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction().add(R.id.book_detail, fragment).commit();

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, FragmentActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
