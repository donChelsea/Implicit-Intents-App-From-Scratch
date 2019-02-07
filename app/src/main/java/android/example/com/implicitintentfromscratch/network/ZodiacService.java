package android.example.com.implicitintentfromscratch.network;

import android.example.com.implicitintentfromscratch.model.ZodiacList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ZodiacService {

    @GET("JDVila/storybook/master/zodiac.json")
    Call<ZodiacList> getZodiacList();
}
