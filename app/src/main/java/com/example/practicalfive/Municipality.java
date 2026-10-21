package com.example.practicalfive;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Municipality extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipality);

        // Re-validate the name passed from MainActivity, so missing/garbage
        // extras are handled safely instead of crashing the screen.
        String name = TextProcessor.processMunicipality(
                getIntent().getStringExtra(MainActivity.EXTRA_MUNICIPALITY));
        if (name == null) {
            finish();
            return;
        }

        TextView nameView = findViewById(R.id.municipalityName);
        ImageView imageView = findViewById(R.id.municipalityImage);
        TextView infoView = findViewById(R.id.municipalityInfo);
        Button visitButton = findViewById(R.id.visitSiteButton);

        int colourRes;
        int imageRes;
        int summaryIndex;
        String website;

        switch (name) {
            case "Shanghai":
                colourRes = R.color.municipality_shanghai;
                imageRes = R.drawable.shanghai;
                summaryIndex = 1;
                website = "https://english.shanghai.gov.cn/";
                break;
            case "Chongqing":
                colourRes = R.color.municipality_chongqing;
                imageRes = R.drawable.chongqing;
                summaryIndex = 2;
                website = "https://english.cq.gov.cn/";
                break;
            case "Tianjin":
                colourRes = R.color.municipality_tianjin;
                imageRes = R.drawable.tianjin;
                summaryIndex = 3;
                website = "https://en.tj.gov.cn/";
                break;
            case "Beijing":
            default:
                colourRes = R.color.municipality_beijing;
                imageRes = R.drawable.beijing;
                summaryIndex = 0;
                website = "https://english.beijing.gov.cn/";
                break;
        }

        int colour = ContextCompat.getColor(this, colourRes);
        int lightText = ContextCompat.getColor(this, R.color.color_text_light);

        nameView.setText(name);
        nameView.setBackgroundColor(colour);
        nameView.setTextColor(lightText);

        imageView.setImageResource(imageRes);

        String[] summaries = getResources().getStringArray(R.array.municipalities_array);
        infoView.setText(summaries[summaryIndex]);
        infoView.setTextColor(colour);

        visitButton.setBackgroundColor(colour);
        visitButton.setTextColor(lightText);
        visitButton.setOnClickListener(v -> openWebsite(website));
    }

    /** Implicit Intent: ask Android to open the URL in a suitable browser. */
    private void openWebsite(String url) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, R.string.no_browser, Toast.LENGTH_SHORT).show();
        }
    }
}
