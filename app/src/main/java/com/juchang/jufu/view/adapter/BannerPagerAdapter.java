package com.juchang.jufu.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.juchang.jufu.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

public class BannerPagerAdapter extends LoopPagerAdapter {
    private int[] imgs = {
            R.drawable.banner_1,
            R.drawable.banner_1,
            R.drawable.banner_1,
            R.drawable.banner_1
    };

    public BannerPagerAdapter(RollPagerView viewPager) {
        super(viewPager);
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        view.setImageResource(imgs[position]);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

    @Override
    public int getRealCount() {
        return imgs.length;
    }
}
