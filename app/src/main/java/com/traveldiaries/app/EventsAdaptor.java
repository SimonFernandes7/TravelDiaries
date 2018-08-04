package com.traveldiaries.app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EventsAdaptor extends RecyclerView.Adapter<EventsAdaptor.MyViewHolder> {

    private List<Events> eventsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView eventTitle, eventDistance;
        public ImageView eventImage;

        public MyViewHolder(View view) {
            super(view);
            eventTitle = (TextView) view.findViewById(R.id.event_name);
            eventDistance = (TextView) view.findViewById(R.id.journey_distance);
            eventImage = (ImageView) view.findViewById(R.id.event_imageView);
        }
    }

    public EventsAdaptor(List<Events> eventsList) {
        this.eventsList = eventsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.events_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Events movie = eventsList.get(position);
        holder.eventTitle.setText(movie.getEventsName());
        holder.eventDistance.setText(movie.getDistance());
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }
}
