package com.udacity.gradle.builditbigger.free;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.b3sk.jokelibrary.JokeActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    Intent intent;
    InterstitialAd interstitialAd;
    ProgressBar spinner;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);


        interstitialAd = new InterstitialAd(getContext());
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        //On add closed launch the new joke activity
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                if (intent != null) {
                    startActivity(intent);
                }

            }
        });
        requestNewInterstitial();

        Button jokeButton = (Button) root.findViewById(R.id.joke_button);
        jokeButton.setOnClickListener(this);

        spinner = (ProgressBar) root.findViewById(R.id.joke_progress_bar);

        return root;
    }

    private void requestNewInterstitial() {

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        interstitialAd.loadAd(adRequest);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.joke_button:
                spinner.setVisibility(v.VISIBLE);
                new EndpointsAsyncTask(new EndpointsAsyncTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {
                        intent = new Intent(getContext(), JokeActivity.class);
                        intent.putExtra(JokeActivity.JOKE_KEY, output);
                        spinner.setVisibility(getView().GONE);
                        if (interstitialAd.isLoaded()) {
                            interstitialAd.show();
                        } else startActivity(intent);


                    }
                }).execute();
        }
    }
}

