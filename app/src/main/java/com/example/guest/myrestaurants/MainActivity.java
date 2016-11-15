package com.example.guest.myrestaurants;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface mathleteFont = Typeface.createFromAsset(getAssets(), "fonts/Mathlete-Bulky.otf");
        mAppNameTextView.setTypeface(mathleteFont);
        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String location = mLocationEditText.getText().toString(); //assign location value to String variable
                Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class); //transition to RestaurantActivity
                intent.putExtra("location", location); //defines our key-value pair using putExtra method, carries data to new activity
                startActivity(intent);
            }
        });
    }
}
