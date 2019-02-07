package android.example.com.implicitintentfromscratch.view;

import android.content.Context;
import android.content.Intent;
import android.example.com.implicitintentfromscratch.DisplayActivity;
import android.example.com.implicitintentfromscratch.R;
import android.example.com.implicitintentfromscratch.model.Zodiac;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ZodiacViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTv;
    private TextView numberTv;
    Context context;
    public static final String ZODIAC_NAME = "zodiac_name";
    public static final String ZODIAC_NUMBER = "zodiac_number";
    public static final String ZODIAC_IMAGE = "zodiac_image";


    public ZodiacViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTv = itemView.findViewById(R.id.name_textview);
        numberTv = itemView.findViewById(R.id.number_textview);
    }

    public void onBind(final Zodiac zodiac) {
        nameTv.setText(zodiac.getName());
        numberTv.setText(zodiac.getNumber());
        nameTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = new Bundle();
                extras.putString(ZODIAC_NAME, zodiac.getName());
                extras.putString(ZODIAC_NUMBER, zodiac.getNumber());
                extras.putString(ZODIAC_IMAGE, zodiac.getImage());
                Intent intent = new Intent(v.getContext(), DisplayActivity.class);
                intent.putExtras(extras);
                v.getContext().startActivity(intent);
            }
        });
    }
}
