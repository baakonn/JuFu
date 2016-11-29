package com.juchang.jufu.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.juchang.jufu.R;
import com.juchang.jufu.util.LogUtil;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 正式的时候切换imgList
 */
public class BannerPagerAdapter extends LoopPagerAdapter {
    private int[] imgs = {
            R.drawable.banner_1,
            R.drawable.banner_1,
            R.drawable.banner_1,
            R.drawable.banner_1
    };
    private List<String> imgList  = new ArrayList<String>();

    public BannerPagerAdapter(RollPagerView viewPager, List<String> list) {
        super(viewPager);
        this.imgList = list;
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


    public void changData(){
        LogUtil.d("imgs length ="+imgs.length);
        imgs[imgs.length+1] = R.drawable.banner_1;
        notifyDataSetChanged();
    }


}
