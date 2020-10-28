package com.ps.petfollowing.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class page_adapter extends FragmentPagerAdapter {

private ArrayList<Fragment> fragments;

    public page_adapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;


    }

    @Override
    public Fragment getItem(int i) {

        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
