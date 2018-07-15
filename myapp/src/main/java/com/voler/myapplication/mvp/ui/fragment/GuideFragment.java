package com.voler.myapplication.mvp.ui.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.voler.myapplication.R;
import com.voler.myapplication.widget.GuideVideoView;

/**
 * 三尺春光驱我寒，一生戎马为长安 -- 韩经录
 * Created by voler on 2016/11/14.
 */

public class GuideFragment extends Fragment {
    private GuideVideoView customVideoView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        customVideoView = new GuideVideoView(getContext());
        /**获取参数，根据不同的参数播放不同的视频**/
        int index = getArguments().getInt("index");
        Uri uri;
        if (index == 1) {
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide1);
        } else if (index == 2) {
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide2);
        } else {
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide3);
        }
        /**播放视频**/
        customVideoView.playVideo(uri);
        return customVideoView;
    }

    public void startVideo() {
        if (!isPlaying()) {
            customVideoView.start();
        }
    }

    public void pauseVideo() {
        if (isPlaying()) {
            customVideoView.pause();
        }
    }

    public boolean isPlaying() {
        return customVideoView.isPlaying();
    }


    /**
     * 记得在销毁的时候让播放的视频终止
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (customVideoView != null) {
            customVideoView.stopPlayback();
        }
    }
}
