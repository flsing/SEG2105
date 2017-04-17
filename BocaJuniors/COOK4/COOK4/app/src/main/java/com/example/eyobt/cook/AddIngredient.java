package com.example.eyobt.cook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;

import static com.example.eyobt.cook.R.layout.list_item_ingredient;


public class AddIngredient extends AppCompatActivity {

    ArrayList<Ingredient> list_Ingredients = new ArrayList<>();
    ArrayList<String> list_ingr_names = new ArrayList<>();
    ArrayList<String> list_selected_Ingredients = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredient);
        for (int i = 0; i < StoredRecipe.getInstance().getRecipes().size(); i++) {
            list_Ingredients.addAll(StoredRecipe.getInstance().getIngredients(i));
        }
        //get ingredients from singleton class, ignoring any double entries
        for (int i = 0; i < list_Ingredients.size(); i++) {
            String name = list_Ingredients.get(i).name;
            if (list_ingr_names.contains(name) == false) {
                list_ingr_names.add(name);
            }
        }
        //sort ingredient list
        Collections.sort(list_ingr_names);

        //fill the list with all of the ingredients
        final ListView listView = (ListView) findViewById(R.id.listView_Ingredients);
        final ArrayAdapter ingredientAdapter = new ArrayAdapter(this, list_item_ingredient, R.id.ingr_name, list_ingr_names);
        listView.setAdapter(ingredientAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                //on item click, change background colour and add the ingredient to a list by name
                parent.getChildAt(position).setBackgroundColor(211211211);
                if (list_selected_Ingredients.contains((String) ingredientAdapter.getItem(position)) == false) {
                    list_selected_Ingredients.add((String) ingredientAdapter.getItem(position));
                }
            }
        });
    }

    //pass the list of clicked ingredients to the parent activity before closing
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("INGREDIENTS", list_selected_Ingredients);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }



}
