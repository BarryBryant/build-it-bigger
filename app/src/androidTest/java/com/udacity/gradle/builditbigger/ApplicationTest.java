package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.concurrent.CountDownLatch;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
            super(Application.class);
        }
    String jokeResponse = null;
    CountDownLatch signal = null;

    @Override
    protected void setUp(){
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown(){
        signal.countDown();
    }

    public void testEndpointsAsyncTask() throws InterruptedException {
        new EndpointsAsyncTask(new EndpointsAsyncTask.AsyncResponse() {
            @Override
            public void processFinish(String output) {
                jokeResponse = output;
                signal.countDown();
            }
        }).execute();
        signal.await();


        assertTrue(jokeResponse != null);
    }
}