package com.e.countrylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.e.countrylist.Api.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RetrofitClient retrofitClient;
    String TAG="MainActivity";
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofitClient=new RetrofitClient();
        Call<List<Model>> call=retrofitClient.getService().getALLCountries();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "YAH!!!" + response.body());

                    if(response.body() != null){
                        generateDataList(response.body());
                        Log.d(TAG, "Users fetched from api is of size " + response.body());

                    }
                } else{
                    //todo 5:  In this section, your call to the server was actually successful, but for some reasons, you couldn't get the suppossed payload
                    Log.d(TAG, "The api returned an error " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.i(TAG, "Error : " + t.getMessage());
                Log.d(TAG, "Error : " + t.getLocalizedMessage());

            }
        });


    }

    private void generateDataList(List<Model> body) {
        recyclerView=findViewById(R.id.recyclerView);
        adapter=new MyAdapter(this,body);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
