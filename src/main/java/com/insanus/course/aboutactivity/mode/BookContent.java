package com.insanus.course.aboutactivity.mode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by insanus on 2017/9/22.
 */

public class BookContent {
    //业务对象
    public static class Book {
        public Integer id;
        public String title;
        public String desc;
        public Book(Integer id, String title, String desc) {
            this.id = id;
            this.title = title;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return title;
        }
    }


    public static List<Book> ITEMS = new ArrayList<>();
    public static Map<Integer, Book> ITEM_MAP = new HashMap<>();

    static {
        addItem(new Book(0,"警察","一名高大男子躺在国立医院重症病房，陷入昏迷，据说他掌握着奥斯陆贩毒集团的内幕消息。"));
        addItem(new Book(1,"父亲的失乐园","美国国家书评人协会奖 首奖"));
    }

    public static void addItem(Book book) {
        ITEMS.add(book);
        ITEM_MAP.put(book.id, book);
    }

}
