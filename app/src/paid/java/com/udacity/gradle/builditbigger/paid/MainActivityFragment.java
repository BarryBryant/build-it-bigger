package com.udacity.gradle.builditbigger.paid;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.b3sk.jokelibrary.JokeActivity;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {
    Intent intent;
    ProgressBar spinner;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button jokeButton = (Button) root.findViewById(R.id.joke_button);
        jokeButton.setOnClickListener(this);

        spinner = (ProgressBar) root.findViewById(R.id.joke_progress_bar);



        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.joke_button:
                spinner.setVisibility(v.VISIBLE);
                new EndpointsAsyncTask(new EndpointsAsyncTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {
                        spinner.setVisibility(getView().GONE);
                        intent = new Intent(getContext(), JokeActivity.class);
                        intent.putExtra(JokeActivity.JOKE_KEY, output);
                        startActivity(intent);
                    }
                }).execute();
        }
    }
}