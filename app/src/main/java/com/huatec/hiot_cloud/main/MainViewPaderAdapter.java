package com.huatec.hiot_cloud.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.huatec.hiot_cloud.utils.Constans;

/**
 * 适配器编写
 */
class MainViewPaderAdapter extends FragmentPagerAdapter {
    public MainViewPaderAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null ;
        switch (position){
            case Constans.MAIN_VIEWPAGER_INDEX_MESSAGE:
                //创建消息的Fragment
                break;
            case Constans.MAIN_VIEWPAGER_INDEX_EQUIPMENT:
                //创建设备的Fragment
                break;
            case Constans.MAIN_VIEWPAGER_INDEX_SCENE:
                //创建场景的Fragment
                break;
            case Constans.MAIN_VIEWPAGER_INDEX_MINE:
                //创建我的Fragment
                break;
                default:

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return Constans.MAIN_FRAGMENT_COUNT;
    }
}
