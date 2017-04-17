package com.example.eyobt.cook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.eyobt.cook.R.id.editText;

public class SearchRecipe extends AppCompatActivity {
    // instance variables
    private Toolbar toolbar;
    private EditText ingredients;
   private Spinner fType, fCategory; // fType = dropdown menu for Food Type
                                     // fCategory = dropdown menu for Food Category

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cook);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        Spinner a = (Spinner) findViewById(R.id.spin);
        Spinner b = (Spinner) findViewById(R.id.spin2);
        fType = a;
        fCategory = b;

        // Toast for foodType so selected item will show on screen
        fType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SearchRecipe.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // Toast for foodCategory so selected item will show on screen
        fCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SearchRecipe.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ;
    }

    public void OnSearchButton(View view){

        ingredients = (EditText)findViewById(editText);
        String category = fCategory.getSelectedItem().toString(); //casting spinner to a string obj
        String type = fType.getSelectedItem().toString();  //casting spinner to a string obj
        Toast toast = new Toast(getApplicationContext());
        String ingredient = ingredients.getText().toString(); //casting EditText input to a string obj
        Boolean a = TextUtils.isEmpty(ingredients.getText()); // checking if user has any input

        // no ingredient inputed -> enter algorithm or searching by Food Type only
        if (a){

           Intent i= new Intent(SearchRecipe.this,Progress.class);
            StoredRecipe storedRecipe = StoredRecipe.getInstance();
            storedRecipe.searchByType(type); // sending selected type to method containing algorithm
            startActivityForResult(i, 0);

        }
        //  ingredient inputed -> enter algorithm or searching by Food Category and ingredients
        else if (!a) {
          Intent  intent = new Intent(this, SearchedResult.class);
            StoredRecipe storedRecipe = StoredRecipe.getInstance();
            storedRecipe.searchByIngredient(category,ingredient); //sending selected category & ingredients
            startActivityForResult(intent, 0);                    // to method containing algorithm

         //   Toast.makeText(SearchRecipe.this, ingredients.getText(), Toast.LENGTH_SHORT).show();
        }
        // extra else just incase there happens to be an error; informs user of help page
        else {
            Toast.makeText(SearchRecipe.this, "Please refer to help page", Toast.LENGTH_SHORT).show();
    }

    }


        //create the Toolbar
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.menu_resource, menu);
            return true;

        }
        //Method for toolbar clicks. Intents to bring to right page, message box if invalid.
        public boolean onOptionsItemSelected (MenuItem item){
            int id = item.getItemId();

            if (id == R.id.action_edit) {
                MessageBox("You must be viewing a recipe");
                return true;
            }
            if (id == R.id.action_help) {
                Intent intent = new Intent(getApplicationContext(), Help.class);
                startActivityForResult(intent, 0);
                return true;
            }


            if (id == R.id.action_add) {
                Intent i = new Intent(getApplicationContext(), AddRecipe.class);
                startActivityForResult(i, 0);
                return true;
            }
            if (id == R.id.action_show_all) {
                Intent intent = new Intent(getApplicationContext(), RecipeList.class);
                startActivityForResult(intent, 0);
                return true;
            }


            if (id == android.R.id.home) {
                onBackPressed();
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

        //Method to toast a short message
        public void MessageBox (String message){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }





    }


