package com.example.nhom09_124lttd01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ViewPagerBannerAdapter extends PagerAdapter {

    private List<PhotoBanner> mlistPhotoBanner;

    public ViewPagerBannerAdapter(List<PhotoBanner> mlistPhotoBanner) {
        this.mlistPhotoBanner = mlistPhotoBanner;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo, container, false);
        ImageView imgPhoto = view.findViewById(R.id.img_photo);

        PhotoBanner photoBanner = mlistPhotoBanner.get(position);
        imgPhoto.setImageResource(photoBanner.getResourceID());

        container.addView(view);


        return view;
    }

    @Override
    public int getCount() {
        if(mlistPhotoBanner != null) {
            return mlistPhotoBanner.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }
}
