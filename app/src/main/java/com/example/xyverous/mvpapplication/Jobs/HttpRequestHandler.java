package com.example.xyverous.mvpapplication.Jobs;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;

/**
 * Created by xyverous on 23/09/2017.
 */

public class HttpRequestHandler {

    private HttpRequestExecutable httpRequestExecutable;

    public HttpRequestHandler(HttpRequestExecutable requestExecutable){
        this.httpRequestExecutable = requestExecutable;
    }


    public void getRequest(String url, Context context){

        //Do get request here

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try{

                    JSONObject object = new JSONObject(response);

                    JSONArray heroList = object.getJSONArray("heroes");

                    Hero[] heroArray = new Hero[heroList.length()];

                    JSONObject heroObject;

                    for(int i = 0, l = heroList.length(); i < l; i++){

                        heroObject = heroList.getJSONObject(i);

                        heroArray[i] = new Hero(heroObject.getString("name"), heroObject.getString("imageurl"));


                    }

                    httpRequestExecutable.onSuccess(heroArray);

                } catch(Exception exception){
                    httpRequestExecutable.onFailed();

                }

            }
        },


                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        httpRequestExecutable.onError();
                    }
                });


        RequestQueue requestQueue = Volley.newRequestQueue(context);

        //adding the string request to request queue
        requestQueue.add(request);


    }

}
