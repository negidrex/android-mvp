package com.example.xyverous.mvpapplication.Jobs;

/**
 * Created by xyverous on 23/09/2017.
 */

public interface HttpRequestExecutable {

    void onSuccess(Hero[] heroes);
    void onError();
    void onFailed();

}
