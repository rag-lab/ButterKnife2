package com.example.rodrigoaugusto.butterknife;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

import javax.sql.DataSource;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.internal.Util;

public class FragmentStepDetail extends android.support.v4.app.Fragment {

    View v;
    //private PlayerView playerView;
    private SimpleExoPlayer player;
    private Context mContext;
    private Unbinder unbinder;
    private String strUrl = "";
    Steps step;

    @BindView(R.id.exoPlayerView)  PlayerView playerView;

    public FragmentStepDetail() {
        super();
    }

//https://android.jlelse.eu/exoplayer-components-explained-9937e3a5d2f5

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //Steps step;
        step = new Steps(Parcel.obtain());

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            step = bundle.getParcelable("step");
            strUrl = step.getVideoURL();
            //boolean v1 = ( step.getVideoURL().equals("") );

            if( step.getVideoURL().equals("") ){
                Log.v("RAG", "no url");
            }else
            {
                Log.v("RAG", strUrl );
            }

        }else{
            Log.v("RAG", "no step detail");
        }

    }

    //https://gist.github.com/bapspatil/2613edaac7230dc5ea48091302a3250c

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_step_detail, container, false);
        unbinder = ButterKnife.bind(this, v);

        player = ExoPlayerFactory.newSimpleInstance(mContext,new DefaultTrackSelector() );
        playerView.setPlayer(player);

        DefaultDataSourceFactory dataSourceFactory =
                new DefaultDataSourceFactory(mContext, com.google.android.exoplayer2.util.Util.getUserAgent(mContext,"ExoPlayer"));

        ExtractorMediaSource mediaSource =
                new ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(step.getVideoURL()));

        player.prepare(mediaSource);
        player.setPlayWhenReady(true);

        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.v("RAG", "onDestroyView");
        unbinder.unbind();
        // Release the player when it is not needed
        player.release();


    }

    // Initialise it from onAttach()
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

}
