package com.insanus.course.aboutactivity.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.insanus.course.aboutactivity.R;
import com.insanus.course.aboutactivity.mode.BookContent;

/**
 * Created by insanus on 2017/9/22.
 */

public class TryFragment extends Fragment {
    public static final String ITEM_ID = "item_id";

    BookContent.Book book;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ITEM_ID)) {
            book = BookContent.ITEM_MAP.get(
                    getArguments().getInt(ITEM_ID));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course, container, false);
        if(book != null) {
            ((TextView) view.findViewById(R.id.book_title)).setText(book.title);
            ((TextView) view.findViewById(R.id.book_desc)).setText(book.desc);
        }
        return  view;
    }

}
