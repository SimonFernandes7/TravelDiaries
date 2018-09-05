package com.traveldiaries.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OrganisedTrips extends AppCompatActivity {

    private List<Events> eventsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EventsAdaptor mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organised_trips);

        recyclerView = (RecyclerView) findViewById(R.id.orgnisers_recycler_view);

        mAdapter = new EventsAdaptor(eventsList);

        recyclerView.setHasFixedSize(true);

        // vertical RecyclerView
        // keep movie_list_row.xml width to `match_parent`
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        // horizontal RecyclerView
        // keep movie_list_row.xml width to `wrap_content`
        // RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(mLayoutManager);

        // adding inbuilt divider line
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);

        // row click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Events event = eventsList.get(position);
                Toast.makeText(getApplicationContext(), event.getEventsName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareOrganisedData();

    }

    private void prepareOrganisedData() {
        Events movie = new Events("Rajmachi", "15 km", true);
        eventsList.add(movie);

        movie = new Events("Leh Ladakh Bike Trip", "20 km", true);
        eventsList.add(movie);

        movie = new Events("Star Wars", "10 km", true);
        eventsList.add(movie);

        movie = new Events("Shaun the Sheep", " 7 km", true);
        eventsList.add(movie);

        movie = new Events("The Martian", "14 km", true);
        eventsList.add(movie);

        movie = new Events("Mission: Impossible Rogue Nation", "29 km", true);
        eventsList.add(movie);

        movie = new Events("Up", "9 km", true);
        eventsList.add(movie);

        movie = new Events("Star Trek", "16 km", true);
        eventsList.add(movie);

        movie = new Events("The LEGO Movie", "14 km", true);
        eventsList.add(movie);

        movie = new Events("Iron Man", "30 km", true);
        eventsList.add(movie);

        movie = new Events("Aliens", "7 km", true);
        eventsList.add(movie);

        movie = new Events("Chicken Run", "11 km", true);
        eventsList.add(movie);

        movie = new Events("Back to the Future", "5 km", true);
        eventsList.add(movie);

        movie = new Events("Raiders of the Lost Ark", "81 km", true);
        eventsList.add(movie);

        movie = new Events("Goldfinger", "5 km", true);
        eventsList.add(movie);

        movie = new Events("Guardians of the Galaxy", "14 km", true);
        eventsList.add(movie);

        // notify adapter about data set changes
        // so that it will render the list with new data
        mAdapter.notifyDataSetChanged();
    }
}
