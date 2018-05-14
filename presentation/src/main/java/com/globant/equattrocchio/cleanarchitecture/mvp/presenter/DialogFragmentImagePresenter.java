package com.globant.equattrocchio.cleanarchitecture.mvp.presenter;

import com.globant.equattrocchio.cleanarchitecture.mvp.view.DialogFragmentImageView;

public class DialogFragmentImagePresenter {
    private DialogFragmentImageView view;

    public DialogFragmentImagePresenter(DialogFragmentImageView view) {
        this.view = view;
    }

    public void init() {
        view.init();
    }
}
