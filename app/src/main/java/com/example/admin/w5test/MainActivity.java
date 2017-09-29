package com.example.admin.w5test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aetrion.flickr.*;
import com.example.admin.w5test.model.*;
import com.bumptech.glide.Glide;
import com.example.admin.w5test.model.Flickr;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Item> items = new ArrayList<>();
    @BindView(R.id.rvFlickr)
    RecyclerView rvFlickr;

    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        rvFlickr.setLayoutManager(layoutManager);
        rvFlickr.setItemAnimator(itemAnimator);

        Observable<Response<Flickr>> flickrCall = RetrofitHelper.createFlickrResponse();
        flickrCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();


        /*flickrCall.enqueue(new retrofit2.Callback<Flickr>() {
            @Override
            public void onResponse(Call<Flickr> call, Response<Flickr> response) {

                FlickrAdapter itemsAdapter = new FlickrAdapter(response.body());
                rvFlickr.setAdapter(itemsAdapter);

            }

            @Override
            public void onFailure(Call<Flickr> call, Throwable t) {

            }
        });*/

    }
    io.reactivex.Observer<Response<Flickr>> flickrObs = new io.reactivex.Observer<Response<Flickr>>(){


        @Override
        public void onSubscribe(@NonNull Disposable d) {

        }

        @Override
        public void onNext(@NonNull Response<Flickr> flickrResponse) {
            items = flickrResponse.body().getItems();
        }

        @Override
        public void onError(@NonNull Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };
}
