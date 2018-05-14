package com.globant.equattrocchio.cleanarchitecture.mvp.view.base;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;

public class FragmentView <T extends Fragment>{
    private WeakReference<T> fragmentRef;

    public FragmentView(T fragment) {
        fragmentRef = new WeakReference<>(fragment);
    }

    @Nullable
    public Activity getActivity() {
        return fragmentRef.get().getActivity();
    }

    @Nullable
    public T getFragment() {
        return fragmentRef.get();
    }


    @Nullable
    public Context getContext() {
        return getActivity();
    }

    @Nullable
    public FragmentManager getFragmentManager() {
        Activity activity = getActivity();
        return (activity != null) ? activity.getFragmentManager() : null;
    }
}
