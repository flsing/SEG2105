package com.example.eyobt.cook;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import static com.example.eyobt.cook.R.layout.list_item_ingredient;

public class AddRecipe extends AppCompatActivity {

    private Toolbar toolbar;
    private static int RESULT_LOAD_IMAGE = 1;
    private static int RESULT_ADD_INSTRUCTIONS = 2;
    private static int RESULT_ADD_INGREDIENTS = 3;

    private MenuItem addButton;
    private MenuItem saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //if editing a recipe, populate the fields
        if(getIntent().getExtras() != null && getIntent().getExtras().get("EDIT_RECIPE_INDEX") != null){
            EditText eT_RecipeName = (EditText) findViewById(R.id.editText_Title);
            EditText eT_Category = (EditText) findViewById(R.id.editText_Category);
            EditText eT_Type = (EditText) findViewById(R.id.editText_Type);
            EditText eT_Instr = (EditText) findViewById(R.id.editText_Instructions);
            ImageView recipePicture = (ImageView) findViewById(R.id.imageView_RecipeIcon);

            Recipe recipeToEdit = StoredRecipe.getInstance().getRecipes().get(getIntent().getExtras().getInt("EDIT_RECIPE_INDEX"));
            eT_RecipeName.setText(recipeToEdit.name);
            eT_Category.setText(recipeToEdit.foodCategory);
            eT_Type.setText(recipeToEdit.foodType);
            eT_Instr.setText(recipeToEdit.steps);
            recipePicture.setImageDrawable( getResources().getDrawable(recipeToEdit.recipePic));

            //ingredient list
            List<String> ingredients = new LinkedList<>();
            for (int a = 0; a < recipeToEdit.ingredients.size(); a++) {
                ingredients.add(recipeToEdit.ingredients.get(a).name);
            }
            //adapter for ingredient list
            final ListView listView = (ListView) findViewById(R.id.listView_IngredientList);
            final ArrayAdapter ingredientAdapter = new ArrayAdapter(this, list_item_ingredient, R.id.ingr_name, ingredients);
            listView.setAdapter(ingredientAdapter);
        }
    }

    //on close: ask to save recipe
    public void onBackPressed() {

        //alert to allow user to cancel recipe or save it to storage
        AlertDialog.Builder builder1 = new AlertDialog.Builder(AddRecipe.this);
        builder1.setMessage("Cancel recipe creation without saving?");
        builder1.setCancelable(true);

        //yes: end activity
        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        finish();
                        finishActivity(1);
                    }
                });

        //no: close dialog, return to activity
        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    //open system picture picker on icon click
    public void OnAddPicture(View view){
        Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);

    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //after picking an image, set it to the icon
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null); cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageView = (ImageView) findViewById(R.id.imageView_RecipeIcon);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }

        //if coming from the instruction activity, add the instructions to the text box
        if (requestCode == RESULT_ADD_INSTRUCTIONS && resultCode == RESULT_OK && null != data){

            String instr_text = data.getExtras().getString("INSTRUCTIONS");
            EditText editText = (EditText) findViewById(R.id.editText_Instructions);
            editText.setText(instr_text);
        }
        //if coming from the ingredient activity, add the ingredients to the list
        if (requestCode == RESULT_ADD_INGREDIENTS && resultCode == RESULT_OK && null != data) {
            List<String> ingredientList = (List<String>) data.getExtras().get("INGREDIENTS");

            final ListView listView = (ListView) findViewById(R.id.listView_IngredientList);
            final ArrayAdapter ingredientAdapter = new ArrayAdapter(this, list_item_ingredient, R.id.ingr_name, ingredientList);
            listView.setAdapter(ingredientAdapter);
        }
    }


    //start ingredient activity when button clicked
    public void OnIngredientAddButton(View view){
        Intent intent = new Intent (getApplicationContext(),AddIngredient.class);
        startActivityForResult(intent, RESULT_ADD_INGREDIENTS);
    }
    //start ingredient activity when button clicked
    public void OnInstructionAddButton(View view){
        Intent intent = new Intent (getApplicationContext(),AddInstruction.class);
        startActivityForResult(intent, RESULT_ADD_INSTRUCTIONS);
    }
    //create the Toolbar
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_resource, menu);

        addButton = menu.getItem(2);
        if (addButton != null) {
            addButton.setVisible(false);
            addButton.setEnabled(false);
        }
        saveButton = menu.getItem(3);
        if (saveButton != null) {
            saveButton.setVisible(true);
            saveButton.setEnabled(true);
        }
        return true;
    }
    //Method for toolbar clicks. Intents to bring to right page, message box if invalid.
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        //on save click: save recipe to singleton class, reset save button to = add button
        if (id == R.id.action_save) {
            //save recipe
            EditText eT_RecipeName = (EditText) findViewById(R.id.editText_Title);
            EditText eT_Category = (EditText) findViewById(R.id.editText_Category);
            EditText eT_Type = (EditText) findViewById(R.id.editText_Title);
            EditText eT_Instr = (EditText) findViewById(R.id.editText_Instructions);
            ImageView recipePicture = (ImageView) findViewById(R.id.imageView_RecipeIcon);

            ListView list_ingr = (ListView) findViewById(R.id.listView_IngredientList);

            StoredRecipe storedRecipe = StoredRecipe.getInstance();
            List<Ingredient> ingredients = new LinkedList<>();
            for (int a = 0; a < list_ingr.getCount(); a++) {
                ingredients.add(new Ingredient(list_ingr.getAdapter().getItem(a).toString()));
            }
            //set picture, if no picture, set to default picture
            Integer picture = (Integer) recipePicture.getTag();
            if (picture == null){
                picture = R.drawable.chef;
            }

            //if editing a recipe, delete the recipe from the singleton class first
            if(getIntent().getExtras() != null && getIntent().getExtras().get("EDIT_RECIPE_INDEX") != null) {
                storedRecipe.getRecipes().remove(getIntent().getExtras().get("EDIT_RECIPE_INDEX"));
            }
            //add new recipe using
            storedRecipe.add(new Recipe(eT_RecipeName.getText().toString(), eT_Type.getText().toString(),
                    eT_Category.getText().toString(), picture, ingredients, eT_Instr.getText().toString()));

            finish();
        }

        if(id == R.id.action_edit) {
            MessageBox("You are already adding a recipe");
            return true;
        }

        //show help pages
        if(id == R.id.action_help) {
            Intent intent = new Intent(getApplicationContext(), Help.class);
            startActivityForResult(intent, 0);
            return true;
        }

        if(id== R.id.action_add){
            MessageBox("You are already on the page!");
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

    public void MessageBox(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
