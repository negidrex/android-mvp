package com.example.xyverous.mvpapplication.Jobs;

/**
 * Created by xyverous on 23/09/2017.
 */

public interface JobExecutable {

    void onSuccess(Hero[] heroes);
    void onFailed(String message);

}
