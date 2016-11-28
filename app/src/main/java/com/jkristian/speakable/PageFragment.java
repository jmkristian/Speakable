package com.jkristian.speakable;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;

public class PageFragment extends Fragment {

    static PageFragment newInstance(int accessibilityFocusable) {
        PageFragment instance = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt("accessibilityFocusable", accessibilityFocusable);
        instance.setArguments(arguments);
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle instanceState) {
        return inflater.inflate(R.layout.page, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int accessibilityFocusable = getArguments().getInt("accessibilityFocusable", 0);
        View target = view.findViewById(accessibilityFocusable);
        if (target != null) {
            target.setAccessibilityDelegate(new View.AccessibilityDelegate() {
                @Override
                public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                    super.onInitializeAccessibilityNodeInfo(host, info);
                    info.setFocusable(true);
                }
            });
        }
        View action = view.findViewById(R.id.action);
        if (action != null) {
            action.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }
    }
}
