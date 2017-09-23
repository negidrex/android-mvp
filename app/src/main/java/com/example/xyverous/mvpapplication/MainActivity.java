package com.example.xyverous.mvpapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.xyverous.mvpapplication.Jobs.Hero;
import com.example.xyverous.mvpapplication.Jobs.JobExecutable;
import com.example.xyverous.mvpapplication.Jobs.JobHandler;


public class MainActivity extends AppCompatActivity implements JobExecutable {

    private JobHandler jobHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.jobHandler = new JobHandler(this);

        this.jobHandler.doJobs("https://simplifiedcoding.net/demos/view-flipper/heroes.php", this);
    }

    @Override
    public void onSuccess(Hero[] heroes) {
        for (int i = 0, l = heroes.length; i < l; i ++){
            Log.i("Hero " + i + " name: ", heroes[i].getHeroName());
            Log.i("Hero " + i + " image: ", heroes[i].getHeroImage());
        }

    }

    @Override
    public void onFailed(String message) {
        Log.i("Tag", message);

    }

}