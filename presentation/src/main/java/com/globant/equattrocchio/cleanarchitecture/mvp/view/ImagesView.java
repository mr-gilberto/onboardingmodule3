package com.globant.equattrocchio.cleanarchitecture.mvp.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.globant.equattrocchio.cleanarchitecture.R;
import com.globant.equattrocchio.cleanarchitecture.mvp.view.base.MainListAdapter;
import com.globant.equattrocchio.data.response.ImageResponse;
import com.globant.equattrocchio.domain.data.Image;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImagesView extends ActivityView {

    LinearLayoutManager layoutManager;
    @BindView(R.id.recycler_main)
    RecyclerView recyclerView;
    MainListAdapter adapter;

    public ImagesView(AppCompatActivity activity) {
        super(activity);
        ButterKnife.bind(this, activity);

        init();
    }

    private void init() {
        initAdapter();
    }


    public void initAdapter() {
        final Context context = getContext();
        if (context != null) {
            layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            layoutManager.setStackFromEnd(true);
            recyclerView.setLayoutManager(layoutManager);
            adapter = new MainListAdapter(getContext() );
            adapter.setItemClickListener(getOnClickListener());
            recyclerView.setAdapter(adapter);
        }
    }

    public View.OnClickListener getOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    // TODO IMPLEMENT CLICK EVENT
            }
        };
    }


    public void setItemsAdapter(List<Image> items){
        adapter.setItems(items);
    }




}
