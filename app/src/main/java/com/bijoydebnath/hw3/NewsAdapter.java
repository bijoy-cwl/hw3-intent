package com.bijoydebnath.hw3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {

    private ArrayList<News> newsArrayList;
    private Context context;

    public NewsAdapter(@NonNull Context context, ArrayList<News> newsArrayList) {
        super(context, R.layout.news_item, newsArrayList);
        this.context = context;
        this.newsArrayList = newsArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        News news = getItem(position);

        final View result;
        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.news_item, parent, false);
            viewHolder.titleTV = (TextView) convertView.findViewById(R.id.titleTV);
            viewHolder.desTV = (TextView) convertView.findViewById(R.id.desTV);
            viewHolder.dateTV = (TextView) convertView.findViewById(R.id.dateTV);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.titleTV.setText(news.getTitle());
        viewHolder.desTV.setText(news.getDescription());
        viewHolder.dateTV.setText(news.getDate());

        Picasso.get().load(news.getImg()).placeholder(R.mipmap.ic_launcher).into(viewHolder.imageView);

        return convertView;
    }

    private static class ViewHolder {
        TextView titleTV;
        TextView desTV;
        TextView dateTV;
        ImageView imageView;

    }
}
