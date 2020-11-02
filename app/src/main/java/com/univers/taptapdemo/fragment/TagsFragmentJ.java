package com.univers.taptapdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.partner.tabtools.verticalTab.TabAdapter;
import com.partner.tabtools.verticalTab.TabView;

/**
 * Created by Jay.Xu
 *
 * @since 2020/10/29
 */
public class TagsFragmentJ extends Fragment {
    private TabAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       adapter = new TabAdapter() {
           @Override
           public int getCount() {
               return 0;
           }

           @Override
           public TabView.TabBadge getBadge(int position) {
               return null;
           }

           @Override
           public TabView.TabIcon getIcon(int position) {
               return null;
           }

           @Override
           public TabView.TabTitle getTitle(int position) {
               return null;
           }

           @Override
           public int getBackground(int position) {
               return 0;
           }
       };
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
