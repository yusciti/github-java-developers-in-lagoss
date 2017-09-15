package com.example.yusuph.andela;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.id;
import static com.example.yusuph.andela.R.id.imageV;
import static com.example.yusuph.andela.R.id.url;
import static com.example.yusuph.andela.R.id.username;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView tv = (TextView)findViewById(R.id.share);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Checkout this awesome developers" + username + url;
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));

            }
        });
  TextView tvv = (TextView) findViewById(R.id.textView5);
        tvv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.google.com")));
            }
        });





        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setHomeButtonEnabled(true);
        }

        TextView unameP = (TextView) findViewById(R.id.textView2);
        TextView addressP = (TextView) findViewById(R.id.textView5);
        ImageView imgV = (ImageView) findViewById(R.id.imageView2);
        Context context;
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String url = intent.getStringExtra("url");
        String img = intent.getStringExtra("img");
        Integer imageId = this.getResources().getIdentifier(img,"drawable", this.getPackageName());

        unameP.setText(username);
        addressP.setText(url);
        imgV.setImageResource(imageId);
        ab.setTitle(username + " Profile's");



    }
}
