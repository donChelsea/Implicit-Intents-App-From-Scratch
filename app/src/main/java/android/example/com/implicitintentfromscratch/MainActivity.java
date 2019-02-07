package android.example.com.implicitintentfromscratch;

import android.example.com.implicitintentfromscratch.controller.ZodiacAdapter;
import android.example.com.implicitintentfromscratch.model.Zodiac;
import android.example.com.implicitintentfromscratch.model.ZodiacList;
import android.example.com.implicitintentfromscratch.network.RetrofitSingleton;
import android.example.com.implicitintentfromscratch.network.ZodiacService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Retrofit retrofit;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = this.findViewById(R.id.recycler_view);
        retrofit = new RetrofitSingleton().getInstance();
        ZodiacService zodiacService = retrofit.create(ZodiacService.class);
        Call<ZodiacList> zodiacListCall = zodiacService.getZodiacList();
        zodiacListCall.enqueue(new Callback<ZodiacList>() {
            @Override
            public void onResponse(Call<ZodiacList> call, Response<ZodiacList> response) {
                Log.d(TAG, response.body().getZodiacList().get(0).getName());
                List<Zodiac> zodiacList = response.body().getZodiacList();
                ZodiacAdapter adapter = new ZodiacAdapter(getApplicationContext(), zodiacList);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ZodiacList> call, Throwable t) {
                Log.d(TAG, "onFailure: something went wrong " + t.getMessage());
            }
        });

    }
}


