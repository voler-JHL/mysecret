package com.voler.myapplication.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.TextClock;
import android.widget.VideoView;
import android.widget.ZoomControls;

import com.voler.myapplication.R;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 妈妈生活圈
 * 三尺春光驱我寒，一生戎马为长安 -- 韩经录
 * Created by voler on 2016/8/26.
 */
public class EvaluationActivity extends AppCompatActivity {
    @Bind(R.id.ratingBar)
    RatingBar ratingBar;
    @Bind(R.id.searchView)
    SearchView searchView;
    @Bind(R.id.zoomControls)
    ZoomControls zoomControls;
    @Bind(R.id.textClock)
    TextClock textClock;
    @Bind(R.id.mediaController)
    MediaController mediaController;
    @Bind(R.id.videoView)
    VideoView videoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);
        ButterKnife.bind(this);

        Uri uri = Uri.parse("http://video.bcloud.brtn.cn/50/fd/50fdac80-877d-a5af-23fa-d1694023cac6/mp4l.mp4");
        videoView.setVideoURI(uri);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                videoView.pause();
            }
        });

        videoView.setMediaController(new MediaController(this));

//       getFiles(Environment.getExternalStorageDirectory().getPath());
    }

    /*
 * 通过递归得到某一路径下所有的目录及其文件
 */
     void getFiles(String filePath) {
        File root = new File(filePath);
        File[] files = root.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
      /*
       * 递归调用
       */
                getFiles(file.getAbsolutePath());
//                System.out.println("显示" + filePath + "下所有子目录及其文件" + file.getAbsolutePath());
            } else {
                if (file.getAbsolutePath().endsWith(".mp4")) {
                    System.out.println(file.getAbsolutePath());
                    Uri uri = Uri.parse(file.getAbsolutePath());
                    videoView.setVideoURI(uri);
                    videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            videoView.pause();
                        }
                    });

//                    videoView.setVideoPath(file.getAbsolutePath());
                    videoView.setMediaController(new MediaController(this));
//                    videoView.start();
//                    videoView.requestFocus();
                    break;
                }
            }
        }
    }
}
