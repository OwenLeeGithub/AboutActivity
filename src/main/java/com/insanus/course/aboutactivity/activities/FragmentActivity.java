package com.insanus.course.aboutactivity.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.insanus.course.aboutactivity.R;
import com.insanus.course.aboutactivity.fragment.BookListFragment;
import com.insanus.course.aboutactivity.fragment.TryFragment;

public class FragmentActivity extends AppCompatActivity implements BookListFragment.Callbacks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    @Override
    public void onItemSelected(Integer id) {
        Bundle arguments = new Bundle();
        arguments.putInt(TryFragment.ITEM_ID, id);
        TryFragment fragment = new TryFragment();
        fragment.setArguments(arguments);
        getFragmentManager().beginTransaction().replace(R.id.book_detail_container, fragment).commit();
    }
}
