package com.jkristian.speakable;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PagerFragment extends Fragment {

    static PagerFragment newInstance(int accessibilityFocusable) {
        PagerFragment instance = new PagerFragment();
        Bundle arguments = new Bundle();
        arguments.putInt("accessibilityFocusable", accessibilityFocusable);
        instance.setArguments(arguments);
        return instance;
    }

    private static final int COUNT = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle instanceState) {
        return inflater.inflate(R.layout.fragment_pager, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPager pager = (ViewPager) view;
        pager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {

            @Override
            public int getCount() {
                return COUNT;
            }

            @Override
            public Fragment getItem(int position) {
                return PageFragment.newInstance(getArguments().getInt("accessibilityFocusable"));
            }
        });
    }
}
