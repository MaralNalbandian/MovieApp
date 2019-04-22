package com.example.tanmay.bingeapp;

import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.*;
import android.content.Intent;

import android.widget.Toast;

//import com.example.tanmay.bingeapp.Adapter.MovieAdapter;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;


public class MovieScreenThree extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {


    public static final String API_KEY = "AIzaSyAMxhaOYLErwOJGmFIwB7q34KAKCG3Je-g";

    public static final String VIDEO_ID = "MFWF9dU5Zc0";

    public ImageButton likeListBtn;
    public ImageButton likeBtn;
    public ImageButton dislikeBtn;
    //Button play;
    VideoView video;
    MediaController mediaC;

    public void viewList() {
        likeListBtn = (ImageButton) findViewById(R.id.likeListBtn);
        likeListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openLikeList = new Intent(MovieScreenThree.this, LikeScreen.class);
                startActivity(openLikeList);
            }
        });
    }

    public void like() {
        likeBtn = (ImageButton) findViewById(R.id.likeBtn);
        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openAnothermovie = new Intent(MovieScreenThree.this, MovieScreen.class);
                startActivity(openAnothermovie);
            }
        });
    }

    public void dislike () {
        dislikeBtn = (ImageButton) findViewById(R.id.dislikeBtn);
        dislikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openAnothermovie = new Intent(MovieScreenThree.this, MovieScreen.class);
                startActivity(openAnothermovie);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_screenthree);
        //play = (Button) findViewById(R.id.playBtn);
        video = (VideoView) findViewById(R.id.videoDisplay);
        mediaC = new MediaController(this);
        viewList();
        like();
        dislike();
        // addToList();

        //Initializing YouTube Player View
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(API_KEY, this);


    }


    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Failure to Initialize!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        //add listeners to YoutTubePlayer instance
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);


        //start buffering
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }
    }

    private PlaybackEventListener playbackEventListener = new PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }

    };

    private PlayerStateChangeListener playerStateChangeListener = new PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(ErrorReason errorReason) {

        }
    };
}
