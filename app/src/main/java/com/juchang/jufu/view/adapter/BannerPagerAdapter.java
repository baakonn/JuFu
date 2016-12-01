package com.juchang.jufu.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.juchang.jufu.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 正式的时候切换imgList
 */
public class BannerPagerAdapter extends LoopPagerAdapter {
//    private int[] imgs = {
//            R.drawable.banner_1,
//            R.drawable.banner_1,
//            R.drawable.banner_1,
//            R.drawable.banner_1
//    };
    private List<Integer> imgList  = new ArrayList<Integer>();


    public BannerPagerAdapter(RollPagerView viewPager) {
        this(viewPager, null);
    }
    public BannerPagerAdapter(RollPagerView viewPager, List<Integer> list) {
        super(viewPager);
        for (int i = 0; i < 4; i++) {
            imgList.add(R.drawable.banner_1);
        }
//        this.imgList = list;
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        view.setImageResource(imgList.get(position));
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

    @Override
    public int getRealCount() {
        return imgList.size();
    }


    public void changData(){
        imgList.add(R.drawable.banner_1);
        notifyDataSetChanged();
    }


}
