package android.example.com.implicitintentfromscratch;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static android.example.com.implicitintentfromscratch.view.ZodiacViewHolder.ZODIAC_IMAGE;
import static android.example.com.implicitintentfromscratch.view.ZodiacViewHolder.ZODIAC_NAME;
import static android.example.com.implicitintentfromscratch.view.ZodiacViewHolder.ZODIAC_NUMBER;

public class DisplayActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView numberTextView;
    private ImageView zodiacImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        nameTextView = findViewById(R.id.name_textview_display);
        numberTextView = findViewById(R.id.number_textview_display);
        zodiacImageView = findViewById(R.id.zodiac_imageview);

        Bundle extras = getIntent().getExtras();
        final String zodiacName = extras.getString(ZODIAC_NAME);
        String zodiacNumber = extras.getString(ZODIAC_NUMBER);
        String zodiacImage = extras.getString(ZODIAC_IMAGE);

        nameTextView.setText(zodiacName);
        numberTextView.setText(zodiacNumber);

        Picasso.get()
                .load(zodiacImage)
                .into(zodiacImageView);

        zodiacImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.astrology.com/horoscope/daily/" + zodiacName + ".html"));
                v.getContext().startActivity(intent);
            }
        });
    }
}
