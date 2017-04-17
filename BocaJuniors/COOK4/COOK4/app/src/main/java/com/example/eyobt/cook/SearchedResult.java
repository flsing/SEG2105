package com.example.eyobt.cook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SearchedResult extends AppCompatActivity {
String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searched_result);

        // sets reference for the ListView to display recipes
       final ListView listView= (ListView) findViewById(R.id.resultList);

        StoredRecipe storedRecipe = StoredRecipe.getInstance();
        List<Recipe> searchResults = storedRecipe.getSearchedRecipes(); // gets searched recipes

        int [] pic = new int [searchResults.size()]; // array with pictures of searched recipes

        String[] names = new String[searchResults.size()];{  // array with names of searched recipes

            for (int i =0; i <searchResults.size();i++){
                names[i] = searchResults.get(i).name;
                pic[i] = searchResults.get(i).recipePic;
            }


        };

        ArrayAdapter adapter = new RecipeAdapter(this,names,pic); // custom adapter

        listView.setAdapter(adapter);

        /**
        * sends index of clicked recipe and opens RecipeDetail class
        */
        adapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
//DO SOMETHING with your item, maybe open a new activity!
                Intent intent = new Intent (getApplicationContext(), RecipeDetail.class);
                intent.putExtra("key",position); // sends position of clicked recipe to RecipeDetail class
                startActivityForResult(intent,0);


            }
        });

    }
}
