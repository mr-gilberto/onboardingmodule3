package com.globant.equattrocchio.cleanarchitecture.mvp.view.base;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.globant.equattrocchio.cleanarchitecture.R;
import com.globant.equattrocchio.cleanarchitecture.mvp.presenter.DialogFragmentImagePresenter;
import com.globant.equattrocchio.cleanarchitecture.mvp.view.DialogFragmentImageView;

public class DialogFragmentImage extends DialogFragment {

    private DialogFragmentImagePresenter presenter;

    public DialogFragmentImage() {
        super();
    }

    public static DialogFragmentImage newInstance(String title, String description, String url) {
        DialogFragmentImage dialogFragment = new DialogFragmentImage();
        Bundle fragmentBundle = new Bundle();
        fragmentBundle.putString(DialogFragmentImageView.KEY_DIALOG_IMAGE_DESCRIPTION, description);
        fragmentBundle.putString(DialogFragmentImageView.KEY_DIALOG_TITLE, description);
        fragmentBundle.putString(DialogFragmentImageView.KEY_DIALOG_IMAGE_URL, url);
        dialogFragment.setArguments(fragmentBundle);
        return dialogFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View customDialogFragment = inflater.inflate(R.layout.dialog_fragment_image, container, false);
        return customDialogFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new DialogFragmentImagePresenter(new DialogFragmentImageView(this));
        presenter.init();
    }

}
