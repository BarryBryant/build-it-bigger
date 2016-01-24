package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.widget.Toast;

import com.b3sk.jokelibrary.JokeActivity;
import com.example.JokeWizard;
import com.example.joopk.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Joopk on 1/21/2016.
 */
public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;


    public interface AsyncResponse{
        void processFinish(String output);
    }

    public AsyncResponse delegate = null;

    public EndpointsAsyncTask(AsyncResponse delegate){
        this.delegate = delegate;
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-1200.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }



        JokeWizard wiz = new JokeWizard();
        String joke = wiz.getJoke();





        try {
            return myApiService.tellJoke(joke).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        delegate.processFinish(result);

    }
}