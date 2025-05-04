package com.yogify.study.ui.home.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.yogify.study.R;
import com.yogify.study.ui.home.dataclass.BannerHomeScreenItem;

import java.util.List;

public class BannerSliderAdapter extends SliderViewAdapter<BannerSliderAdapter.SliderAdapterVH> {

    private Context context;
    private List<BannerHomeScreenItem> mSliderItems;

    OnItemClickListner mlistner;

    public interface OnItemClickListner {
        void onItemClick(BannerHomeScreenItem bannerHomeScreenItem);

    }

    public void setOnItemClickListener(OnItemClickListner listener) {
        mlistner = listener;
    }

    public BannerSliderAdapter(Context context, List<BannerHomeScreenItem> mSliderItems) {
        this.context = context;
        this.mSliderItems = mSliderItems;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_banner_home, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        BannerHomeScreenItem sliderItem = mSliderItems.get(position);
        // viewHolder.image.setImageResource(Integer.valueOf(sliderItem.getBannerUrl()));

        Glide.with(context).load(sliderItem.getBannerUrl())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        viewHolder.progressBar.setVisibility(View.VISIBLE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        viewHolder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(viewHolder.image);
//


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlistner.onItemClick(sliderItem);
            }
        });
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }

    class SliderAdapterVH extends BannerSliderAdapter.ViewHolder {

        View itemView;
        ImageView image;
        ProgressBar progressBar;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.banner_image);
            progressBar = itemView.findViewById(R.id.banner_progressBar);

            this.itemView = itemView;
        }
    }

}