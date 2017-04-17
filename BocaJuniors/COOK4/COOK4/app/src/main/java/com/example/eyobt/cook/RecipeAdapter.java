package com.example.eyobt.cook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Eyob.T on 2016-11-23.
 */
public class RecipeAdapter  extends ArrayAdapter<String> {


    private final String[] foods; // recipes
    private final int[] pic; // pics for recipes

    /**
     * constructor to initilize the parameters
     * @param context
     * @param foods
     * @param pic
     */
    public RecipeAdapter(Context context, String[] foods, int[] pic) {
            super(context,R.layout.activity_recipe_layout,foods);
            this.foods=foods;
            this.pic=pic;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());

            View customView = inflater.inflate(R.layout.activity_recipe_layout,parent,false);

            // sets recipeName to reference TextView recipeName
            TextView recipeName = (TextView) customView.findViewById(R.id.recipeName);

            // sets icon to reference ImageView icon
            ImageView icon = (ImageView) customView.findViewById((R.id.icon));

            recipeName.setText(foods[position]); // sets the recipeName to the recipe's name by position from reci linkedList
            icon.setImageResource(pic[position]); // sets the image to the recipe's pic by position from reci linkedList
            return customView;
        }
    }
