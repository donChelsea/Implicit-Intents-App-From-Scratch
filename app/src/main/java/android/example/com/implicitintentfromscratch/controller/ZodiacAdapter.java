package android.example.com.implicitintentfromscratch.controller;

import android.content.Context;
import android.example.com.implicitintentfromscratch.R;
import android.example.com.implicitintentfromscratch.model.Zodiac;
import android.example.com.implicitintentfromscratch.view.ZodiacViewHolder;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ZodiacAdapter extends RecyclerView.Adapter<ZodiacViewHolder> {
    List<Zodiac> zodiacList;
    Context context;

    public ZodiacAdapter(Context context, List<Zodiac> zodiacList) {
        this.context = context;
        this.zodiacList = zodiacList;
    }

    @NonNull
    @Override
    public ZodiacViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.zodiac_list_view, viewGroup, false);
        return new ZodiacViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZodiacViewHolder zodiacViewHolder, int i) {
        zodiacViewHolder.onBind(zodiacList.get(i));
    }

    @Override
    public int getItemCount() {
        return zodiacList.size();
    }
}
