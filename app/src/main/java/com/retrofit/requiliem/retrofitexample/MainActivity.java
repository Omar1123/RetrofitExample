package com.retrofit.requiliem.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.retrofit.requiliem.retrofitexample.Adapters.DiscussionAdapter;
import com.retrofit.requiliem.retrofitexample.EndPoint.DiscussionsInterface;
import com.retrofit.requiliem.retrofitexample.EndPoint.RetrofitArrayAPI;
import com.retrofit.requiliem.retrofitexample.EndPoint.RetrofitObjectAPI;
import com.retrofit.requiliem.retrofitexample.models.Discussion;
import com.retrofit.requiliem.retrofitexample.models.Student;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private DiscussionAdapter adapter;
    private ArrayList<Discussion> data = new ArrayList<Discussion>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        getRetrofitArrayDiscussions();
        //loadJSON();
    }


    private void getRetrofitObject() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://androidtutorialpoint.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitObjectAPI service = retrofit.create(RetrofitObjectAPI.class);

        Call<Student> call = service.getStudentDetails();

        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                try {

                    Toast.makeText(MainActivity.this, "StudentId  :  " + response.body().getStudentId(),
                            Toast.LENGTH_LONG).show();

                    Toast.makeText(MainActivity.this, "StudentName  :  " + response.body().getStudentName(),
                            Toast.LENGTH_LONG).show();

                    Toast.makeText(MainActivity.this, "StudentMarks  : " + response.body().getStudentMarks(),
                            Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }

    private void getRetrofitArray() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://androidtutorialpoint.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitArrayAPI service = retrofit.create(RetrofitArrayAPI.class);

        Call<List<Student>> call = service.getStudentDetails();

        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                try {

                    List<Student> StudentData = response.body();

                    for (int i = 0; i < StudentData.size(); i++) {

                        if (i == 0) {

                            Toast.makeText(MainActivity.this, "StudentId  :  " + StudentData.get(i).getStudentId(),
                                    Toast.LENGTH_LONG).show();
                            Toast.makeText(MainActivity.this, "StudentName  :  " + StudentData.get(i).getStudentName(),
                                    Toast.LENGTH_LONG).show();
                            Toast.makeText(MainActivity.this, "StudentMarks  : " + StudentData.get(i).getStudentMarks(),
                                    Toast.LENGTH_LONG).show();
                        } else if (i == 1) {
                            Toast.makeText(MainActivity.this, "StudentId  :  " + StudentData.get(i).getStudentId(),
                                    Toast.LENGTH_LONG).show();
                            Toast.makeText(MainActivity.this, "StudentName  :  " + StudentData.get(i).getStudentName(),
                                    Toast.LENGTH_LONG).show();
                            Toast.makeText(MainActivity.this, "StudentMarks  : " + StudentData.get(i).getStudentMarks(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }

    private void getRetrofitArrayDiscussions() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://backtrackacademy.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DiscussionsInterface service = retrofit.create(DiscussionsInterface.class);

        Call<List<Discussion>> call = service.getDiscussions();

        call.enqueue(new Callback<List<Discussion>>() {
            @Override
            public void onResponse(Call<List<Discussion>> call, Response<List<Discussion>> response) {

                try {

                    List<Discussion> StudentData = response.body();

                    data.addAll(StudentData);
                    adapter = new DiscussionAdapter(data);
                    recyclerView.setAdapter(adapter);

                    adapter.notifyDataSetChanged();
                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<Discussion>> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }
}
