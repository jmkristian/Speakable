package com.jkristian.speakable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle instanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle instanceState) {
        super.onViewCreated(view, instanceState);
        view.findViewById(R.id.simple)
            .setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_main, PagerFragment.newInstance(0))
                        .addToBackStack(null)
                        .commit();
                }
            });
        view.findViewById(R.id.accessible)
            .setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_main, PagerFragment.newInstance(R.id.caption))
                        .addToBackStack(null)
                        .commit();
                }
            });
    }
}
