package com.example.facabookv2.data;


import io.reactivex.rxjava3.core.Observable;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {

    private static final String BASE_URL="https://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static PostsClient Instance;

  //builder of Retrofit
    public PostsClient() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

    //retrofit fill each post interface for each client(builder)
        postInterface =retrofit.create(PostInterface.class);
    }
   //instance for each client
    public static PostsClient getInstance() {
        if(null==Instance){
            Instance=new PostsClient();
        }
        return Instance;
    }
 // Method will return what fill in the interface(by retrofit)
    public Observable getPosts(){
        return postInterface.getPosts();
    }

}
