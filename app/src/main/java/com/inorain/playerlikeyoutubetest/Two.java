package com.inorain.playerlikeyoutubetest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

public class Two extends Fragment {

    private static Two two = null;

    public static Two getInstance(){
        if(two == null){
            two = new Two();
        }
        return two;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.two,container,false);
        return view;
    }
}
