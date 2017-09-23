package com.insanus.course.aboutactivity.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.insanus.course.aboutactivity.R;
import com.insanus.course.aboutactivity.fragment.BookListFragment;
import com.insanus.course.aboutactivity.fragment.TryFragment;

public class FragmentActivity extends AppCompatActivity implements BookListFragment.Callbacks{

    private boolean mTwoScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_small);
        //双页
        if(findViewById(R.id.book_detail_container) != null) {
            mTwoScreen = true;
            ((BookListFragment) getFragmentManager().findFragmentById(R.id.book_list)).setActivateOnitemClick(true);
        }
    }

    @Override
    public void onItemSelected(Integer id) {
        if(mTwoScreen) {
            Bundle arguments = new Bundle();
            arguments.putInt(TryFragment.ITEM_ID, id);
            TryFragment fragment = new TryFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction().replace(R.id.book_detail_container, fragment).commit();
        } else {

            Intent detailIntent = new Intent(this, BookDetailActivity.class);
            detailIntent.putExtra(TryFragment.ITEM_ID, id);
            startActivity(detailIntent);

        }
    }
}
