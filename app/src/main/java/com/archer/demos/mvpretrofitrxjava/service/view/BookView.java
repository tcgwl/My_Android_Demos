package com.archer.demos.mvpretrofitrxjava.service.view;

import com.archer.demos.mvpretrofitrxjava.service.entity.Book;

/**
 * Created by Archer on 2017/12/7.
 */

public interface BookView extends View {
    void onSuccess(Book book);
    void onFailure(String message);
}
