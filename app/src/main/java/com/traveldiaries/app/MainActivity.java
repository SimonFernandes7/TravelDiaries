package com.traveldiaries.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.DefaultItemAnimator;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private List<Events> eventsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EventsAdaptor mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

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

        prepareTravelData();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_edit_profile) {
            // Handle the profile Edit action

            Intent i= new Intent(this,EditProfile.class);
            startActivity(i);
        } else if (id == R.id.nav_past_trips) {
            // Handle the Past Trips action
        } else if (id == R.id.nav_managed_trips) {
            // Handle the Organised Trips action
        } else if (id == R.id.nav_contacts) {
            // Handle the Check friends action
        } else if (id == R.id.nav_notifications) {
            // Handle the Notification List action
        } else if (id == R.id.nav_share) {
            // Handle the Send Invites action
        } else if (id == R.id.nav_help) {
            // Handle the send Help action
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    /**
     * Prepares sample data to provide data set to adapter
     */
    private void prepareTravelData() {
        Events movie = new Events("Rajmachi", "15 km");
        eventsList.add(movie);

        movie = new Events("Leh Ladakh Bike Trip", "20 km");
        eventsList.add(movie);

        movie = new Events("Star Wars", "10 km");
        eventsList.add(movie);

        movie = new Events("Shaun the Sheep", " 7 km");
        eventsList.add(movie);

        movie = new Events("The Martian", "14 km");
        eventsList.add(movie);

        movie = new Events("Mission: Impossible Rogue Nation", "29 km");
        eventsList.add(movie);

        movie = new Events("Up", "9 km");
        eventsList.add(movie);

        movie = new Events("Star Trek", "16 km");
        eventsList.add(movie);

        movie = new Events("The LEGO Movie", "14 km");
        eventsList.add(movie);

        movie = new Events("Iron Man", "30 km");
        eventsList.add(movie);

        movie = new Events("Aliens", "7 km");
        eventsList.add(movie);

        movie = new Events("Chicken Run", "11 km");
        eventsList.add(movie);

        movie = new Events("Back to the Future", "5 km");
        eventsList.add(movie);

        movie = new Events("Raiders of the Lost Ark", "81 km");
        eventsList.add(movie);

        movie = new Events("Goldfinger", "5 km");
        eventsList.add(movie);

        movie = new Events("Guardians of the Galaxy", "14 km");
        eventsList.add(movie);

        // notify adapter about data set changes
        // so that it will render the list with new data
        mAdapter.notifyDataSetChanged();
    }
}
