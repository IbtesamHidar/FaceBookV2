package com.example.facabookv2.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.facabookv2.data.PostsClient;
import com.example.facabookv2.pojo.PostModel;

import java.util.List;



import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {

 // list of posts which will be returned from retrofit
    MutableLiveData<List<PostModel>> postsMutableLiveData =new MutableLiveData<>();

 // fun which will get the posts from retrofit "tied view model with Retrofit"
    public void getPosts(){
      Observable observable= PostsClient.getInstance().getPosts()
              .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread());



        Observer observer=new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@androidx.annotation.NonNull Object o) {
                postsMutableLiveData.setValue((List<PostModel>) o);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };


        observable.subscribe(observer);
    }
}
//    .observeOn(AndroidSchedulers.mainThread());