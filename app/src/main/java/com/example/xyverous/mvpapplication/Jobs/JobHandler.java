package com.example.xyverous.mvpapplication.Jobs;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by xyverous on 23/09/2017.
 */

// this file will


public class JobHandler implements HttpRequestExecutable {


    private JobExecutable jobExecutable;
    private Context context = null;
    private HttpRequestHandler httpRequestHandler;
    private String url = null;

    public JobHandler(JobExecutable jobExecutable){
        this.jobExecutable = jobExecutable;
        this.httpRequestHandler = new HttpRequestHandler(this);
    }


    public void doJobs(String url, Context context){
        this.url = url;
        this.context = context;
        this.getRequest();
    }

    private void getRequest(){
        Log.i("Tag", "Tag");
        this.httpRequestHandler.getRequest(this.url, this.context);

    }

    @Override
    public void onSuccess(Hero[] heroes) {
        this.jobExecutable.onSuccess(heroes);

    }

    @Override
    public void onFailed() {
        Log.i("HTTPRequest", "Failed");

    }

    @Override
    public void onError() {
        Log.i("HTTPRequest", "Error");
    }
}
