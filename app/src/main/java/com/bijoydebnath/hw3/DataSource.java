package com.bijoydebnath.hw3;

import android.content.Context;

import androidx.annotation.RawRes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSource {
    private Context context;

    public DataSource(Context context) {
        this.context = context;
    }

    public ArrayList<Category> getCategories() {

        ArrayList<Category> categoryArrayList = new ArrayList<>();

        String catString = readRawResource(R.raw.news_cat);

        try {
            JSONArray jsonArray = new JSONArray(catString);

            categoryArrayList.add(new Category(0, "Select One "));

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String title = jsonObject.getString("title");

                categoryArrayList.add(new Category(id, title));
            }

        } catch (JSONException e) {
            categoryArrayList.clear();
        }
        return categoryArrayList;

    }

    public ArrayList<News> getNewsById(int catId) {

        ArrayList<News> newsArrayList = new ArrayList<>();

        String newsString = readRawResource(R.raw.news);

        try {
            JSONArray jsonArray = new JSONArray(newsString);


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int cID = jsonObject.getInt("catId");

                if (cID == catId) {
                    int id = jsonObject.getInt("id");
                    String title = jsonObject.getString("title");
                    String description = jsonObject.getString("description");
                    String img = jsonObject.getString("img");
                    String date = jsonObject.getString("date");

                    newsArrayList.add(new News(id, title, description, date, img));
                }

            }

        } catch (JSONException e) {
            newsArrayList.clear();
        }
        return newsArrayList;

    }

    public String readRawResource(@RawRes int res) {
        return readStream(context.getResources().openRawResource(res));
    }

    private String readStream(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
