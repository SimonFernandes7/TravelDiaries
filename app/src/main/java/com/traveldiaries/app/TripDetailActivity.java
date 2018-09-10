package com.traveldiaries.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TripDetailActivity extends AppCompatActivity {

    public TextView eventTitle, eventDistance;
    public Button joinCancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_detail);

        Events event=(Events)getIntent().getExtras().getSerializable("events");

        eventTitle = (TextView) findViewById(R.id.tripTitleTextView);
        eventDistance = (TextView) findViewById(R.id.distanceTextView);
        joinCancelButton = (Button) findViewById(R.id.joinCancelButton);

        eventTitle.setText(event.getEventsName());
        eventDistance.setText(event.getDistance());

        if (event.getOrganised()) {
            joinCancelButton.setVisibility(View.INVISIBLE);
        }else {
            joinCancelButton.setVisibility(View.VISIBLE);
        }
    }
}
