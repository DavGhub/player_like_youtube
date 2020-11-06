package com.inorain.playerlikeyoutubetest;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

public class One extends Fragment {

    private static One one = null;

    VideoView videoView;

    public static One getInstance(){
        if(one == null){
            one = new One();
        }
        return one;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.one,container,false);

        videoView = view.findViewById(R.id.video_view);

        initializeVideoView();

        return view;
    }

    /**
     * Pause the VideoView content.
     */
    public void pauseVideo() {
        if (videoView.isPlaying()) {
            videoView.pause();
            Log.e("video view","pause");
        }
    }

    /**
     * Resume the VideoView content.
     */
    public void startVideo() {
        if (!videoView.isPlaying()) {
            videoView.start();
            Log.e("video view","play");
        }
    }

    /**
     * Initialize ViedeoView with a video by default.
     */
    private void initializeVideoView() {
        Uri path = Uri.parse("https://mnmedias.api.telequebec.tv/m3u8/29880.m3u8");
//        videoView.setVideoURI(path);
        videoView.setVideoPath("https://bitdash-a.akamaihd.net/content/sintel/hls/playlist.m3u8");
        videoView.start();
    }
}
