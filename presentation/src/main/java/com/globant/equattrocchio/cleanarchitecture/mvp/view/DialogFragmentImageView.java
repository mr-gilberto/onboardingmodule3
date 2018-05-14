package com.globant.equattrocchio.cleanarchitecture.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.globant.equattrocchio.cleanarchitecture.R;
import com.globant.equattrocchio.cleanarchitecture.mvp.view.base.DialogFragmentImage;
import com.globant.equattrocchio.cleanarchitecture.mvp.view.base.FragmentView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DialogFragmentImageView extends FragmentView {
    private Context context;
    private Bundle dialogBundle;

    public static final String KEY_DIALOG_IMAGE_URL = "KEY_DIALOG_IMAGE_URL";
    public static final String KEY_DIALOG_IMAGE_DESCRIPTION = "KEY_DIALOG_IMAGE_DESCRIPTION";
    public static final String KEY_DIALOG_TITLE= "KEY_DIALOG_TITLE";

    @BindView(R.id.dialog_title)
    TextView dialogTitle;
    @BindView(R.id.image_description)
    TextView imageDescription;
    @BindView(R.id.image)
    ImageView imageView;


    public DialogFragmentImageView(DialogFragmentImage fragment) {
        super(fragment);
        ButterKnife.bind(this, fragment.getView());
    }

    public void init() {
        this.context = getActivity();
        dialogBundle = getFragment().getArguments();
        setDialogContent();
    }

    public void setTextTitle(String title) {
        dialogTitle.setText(title);
    }

    public void setImageDescription(String text) {
        imageDescription.setText(text);
    }


    public void setImageResource(String url) {
        Glide.with(context)
                .load(url)
                .into(imageView);
    }

    public void setDialogContent() {
        if (dialogBundle != null) {
            setImageResource(dialogBundle.getString(KEY_DIALOG_IMAGE_URL, ""));
            setImageDescription(dialogBundle.getString(KEY_DIALOG_IMAGE_DESCRIPTION, ""));
            setTextTitle (dialogBundle.getString(KEY_DIALOG_TITLE, ""));
        }
    }

}
