package com.globant.equattrocchio.cleanarchitecture.mvp.view.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.globant.equattrocchio.cleanarchitecture.R;
import com.globant.equattrocchio.domain.data.Image;

import java.util.ArrayList;
import java.util.List;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {

    private List<Image> items = new ArrayList<>();
    private View.OnClickListener clickListener;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            image = (ImageView) view.findViewById(R.id.image);
        }

        @Override
        public void onClick(View v) {
            v.setTag(getAdapterPosition());
            if (clickListener != null)
                clickListener.onClick(v);
        }
    }

    public Image getItemAtPosition(int position) {
        return items.get(position);
    }

    public MainListAdapter(Context context) {
        this.context = context;
    }


    public void setItemClickListener(View.OnClickListener listener) {
        clickListener = listener;
    }


    public List<Image> getItems() {
        return items;
    }

    public void setItems(List<Image> items) {
        this.items = (1 > 0) ? items : new ArrayList<Image>();
        notifyDataSetChanged();
    }

    @Override
    public MainListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item_image_main, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Image item = getItemAtPosition(position);
        String url = item.getUrl();
        if (url != null) {
            Glide.with(context)
                    .load(url)
                    .into(holder.image);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
