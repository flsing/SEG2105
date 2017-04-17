package com.example.eyobt.cook;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;

public class RecipeDetail extends AppCompatActivity {


    private Toolbar toolbar;
    private int position;
    TextView instructions,recipeName;
    ImageView recipeImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ListView listView_Ingr = (ListView) findViewById(R.id.listView_Ingredients);

        /**
         * receives index from SearchedRecipe and initializes var. position
         */
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             position = extras.getInt("key");
        }
        StoredRecipe storedRecipe = StoredRecipe.getInstance();
       List<Recipe> recipes = storedRecipe.getRecipes(); // gets ALL stored recipes
        Recipe aRecipe = recipes.get(position); // gets the recipe at [position]


String[] recipeArray = new String [recipes.size()]; // array with name of recipe

        for (int i =0; i <recipeArray.length;i++) {
            recipeArray[i] = recipes.get(i).name;
        }

        int[] recipePic = new int [recipes.size()]; // array with picture of recipe
        for (int i =0; i <recipePic.length;i++) {
            recipePic[i] = recipes.get(i).recipePic;
        }

        List<Ingredient> listOfIngredients = storedRecipe.getIngredients(position); // gets list of ingredients for recipe at [position]
        String stepsOfRecipe = storedRecipe.getSteps(aRecipe); // gets steps for recipe at [position]



        String[] ingredients = new String[listOfIngredients.size()];
        String  steps = stepsOfRecipe;

        /**
         * populates ingredients[] with ALL ingredients of recipe at [position]
         */
        for (int i =0; i <listOfIngredients.size();i++) {
            ingredients[i] = listOfIngredients.get(i).name;
        }

        /**
         * sends array of ingredients to be displayed on screen
         */
        ArrayAdapter adapterIngredients = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ingredients);

        // initializing instruction in recipe_layout
        instructions = (TextView)findViewById(R.id.steps);
        instructions.setText(steps);

        // initializing recipe name in recipe_layout
        recipeName = (TextView)findViewById(R.id.textView_RecipeName);
        recipeName.setText(recipeArray[position]);

        // initializing picture in recipe_layout
        recipeImg = (ImageView)findViewById(R.id.imageView_RecipeIcon);
        recipeImg.setImageResource(recipePic[position]);

        listView_Ingr.setAdapter(adapterIngredients);

    }
    //create the Toolbar
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_resource, menu);
        return true;

    }

    //Method for toolbar clicks. Intents to bring to right page, message box if invalid.
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.action_edit) {
            Intent intent = new Intent (getApplicationContext(), AddRecipe.class);
            intent.putExtra("EDIT_RECIPE_INDEX", position);
            startActivityForResult(intent,0);
            return true;

        }
        if(id == R.id.action_help) {
            Intent intent = new Intent(getApplicationContext(), Help.class);
            startActivityForResult(intent, 0);
            return true;
        }

        if(id== R.id.action_add){
            Intent intent = new Intent (getApplicationContext(), AddRecipe.class);
            startActivityForResult(intent,0);
            return true;
        }
        if(id== R.id.action_show_all){
            Intent intent = new Intent (getApplicationContext(),RecipeList.class);
            startActivityForResult(intent,0);
            return true;
        }

        if (id==android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}