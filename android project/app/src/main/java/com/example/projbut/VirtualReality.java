package com.example.nidhi.projbut;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VirtualReality extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    Button button;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtual_reality);
        button=(Button)findViewById(R.id.button7);
        youTubePlayerView =(YouTubePlayerView)findViewById(R.id.you_TubePlayerView);
        onInitializedListener=new YouTubePlayer.OnInitializedListener()
        {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("Fdd7_zroiI0");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize(PlayerConfig.API_KEY,onInitializedListener);
            }
        });
    }


}
