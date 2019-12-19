package com.example.hongligs.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hongligs.R;

/**
 * A simple {@link Fragment} subclass.
 * 网文小说
 */
public class DTGNovelFragment extends Fragment {


    public DTGNovelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dtgnovel, container, false);
    }

}
