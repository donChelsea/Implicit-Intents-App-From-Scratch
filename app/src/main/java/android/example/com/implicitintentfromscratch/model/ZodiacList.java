package android.example.com.implicitintentfromscratch.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ZodiacList {
    @SerializedName("zodiac")
    private List<Zodiac> zodiacList;

    public ZodiacList(List<Zodiac> zodiacList) {
        this.zodiacList = zodiacList;
    }

    public List<Zodiac> getZodiacList() {
        return zodiacList;
    }

    public void setZodiacList(List<Zodiac> zodiacList) {
        this.zodiacList = zodiacList;
    }
}
