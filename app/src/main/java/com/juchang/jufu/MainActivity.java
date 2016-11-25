package com.juchang.jufu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juchang.jufu.fragment.FindFragment;
import com.juchang.jufu.fragment.HomeFragment;
import com.juchang.jufu.fragment.MeFragment;
import com.juchang.jufu.fragment.MessageFragment;
import com.juchang.jufu.util.LogUtil;
import com.juchang.jufu.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.juchang.jufu.R.id.find;
import static com.juchang.jufu.R.id.me;

/**
 * @author mayakun
 * UpdateDate: 2016-11-25
 * Version:0.1
 * Introduce: 主页面
 */
public class MainActivity extends FragmentActivity {
    @BindView(R.id.home)
    TextView mHome;
    @BindView(R.id.message)
    TextView mMessage;
    @BindView(find)
    TextView mFind;
    @BindView(me)
    TextView mMe;
    @BindView(R.id.add)
    ImageView mAdd;

    // Fragment界面list
    private List<Class> fragmentList = new ArrayList<Class>();
    private Class<?> _currClass = String.class;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LogUtil.d("onCreate-------------");
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState != null) {  // "内存重启"时调用
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            LogUtil.d("savedInstanceState is not null");
            List<Fragment> list = getSupportFragmentManager().getFragments();
            LogUtil.d("list.size()===="+ list.size());

            for (Fragment fragment : list) {
                LogUtil.d("fragment-name-----"+fragment.getClass().getName());
                beginTransaction.hide(fragment);
            }
            beginTransaction.commit();
        }

        initFragmentList();
    }

    @OnClick({R.id.home, R.id.message, find, me})
    public void tabOnClick(View view) {
        int tag = Integer.parseInt(view.getTag().toString());
        switchFragmentByTag(fragmentList.get(tag));
    }

    @OnClick(R.id.add)
    public void tabAddOnClick() {
        ToastUtil.showShort(this, "add");
    }

    /**
     * 初始化
     */
    private void initFragmentList() {
        fragmentList.add(HomeFragment.class);
        fragmentList.add(MessageFragment.class);
        fragmentList.add(FindFragment.class);
        fragmentList.add(MeFragment.class);

        switchFragmentByTag(HomeFragment.class);
    }

    /**
     * 切换界面通过Tag
     *
     * @param _class 目标界面
     */
    private void switchFragmentByTag(Class<?> _class) {
        if (_class != _currClass) {
            //beginTransaction 事物操作和findFragmentByTag 是异步的
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            // 从 FragmentManager 中获取对应的Fragment
            Fragment showFragment = getSupportFragmentManager().findFragmentByTag(_class.getName());
            if (showFragment == null) {
                // 如果没有，则初始化Fragment ，并添加到FragmentManager中
                showFragment = Fragment.instantiate(this, _class.getName());
                beginTransaction.add(R.id.container, showFragment, _class.getName());
            } else {
                if (showFragment.isAdded()) {
                    beginTransaction.show(showFragment);
                }
            }
            // 隐藏不需要展示的界面
            Fragment hideFragment = getSupportFragmentManager().findFragmentByTag(_currClass.getName());
            if (hideFragment != null && hideFragment.isAdded()) {
                beginTransaction.hide(hideFragment);
            }

            beginTransaction.commit();
            _currClass = _class;
            //修改tab选中状态
            setSelectStatus();
        }
    }

    /**
     * 修改选中状态
     */
    private void setSelectStatus() {
        mHome.setSelected(HomeFragment.class.equals(_currClass));
        mMessage.setSelected(MessageFragment.class.equals(_currClass));
        mFind.setSelected(FindFragment.class.equals(_currClass));
        mMe.setSelected(MeFragment.class.equals(_currClass));
    }


    /**
     * 销毁Fragment
     */
    private void removeFragment() {
        LogUtil.d("removeFragment------");
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        for (Class<?> clazz : fragmentList) {
            Fragment fragment = getSupportFragmentManager().findFragmentByTag(clazz.getName());
            if(fragment != null) {
                beginTransaction.remove(fragment);
            }
        }
//        beginTransaction.commit();
        fragmentList.clear();

    }
    @Override
    protected void onDestroy() {
        LogUtil.d("onDestroy-----------");
        removeFragment();
        super.onDestroy();
    }

}
