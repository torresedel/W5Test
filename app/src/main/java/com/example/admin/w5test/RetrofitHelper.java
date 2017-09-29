package com.example.admin.w5test;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

import com.example.admin.w5test.model.*;
import com.bumptech.glide.Glide;

/**
 * Created by Admin on 9/29/2017.
 */

public class RetrofitHelper {

    public static final String BASE_URL = "http://api.flickr.com/";
    public static final String QUERY = "kitten&format=json&nojsoncallback=1";
    private static final String TAG = "RetrofitHelperTag";

    public static Retrofit create(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static Observable<Response<Flickr>>createFlickrResponse(){
        Retrofit retrofit = create();
        FlickrService FlickrService = retrofit.create(FlickrService.class);
        return FlickrService.getFlickr();
    }

    public interface FlickrService {

        @GET(QUERY)
        Observable<Response<Flickr>> getFlickr();

    }


}
