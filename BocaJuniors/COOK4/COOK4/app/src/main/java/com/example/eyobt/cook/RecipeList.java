package com.example.eyobt.cook;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 *RecipeList class. Stores the information that will go into the list. Allows for deleting of items.
 */
public class RecipeList extends AppCompatActivity {

    private Toolbar toolbar;
    ListView listView;
    String type;

    /**
     *OnCreate method to create the items in the list.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            type = extras.getString("key");
        }

        Toast.makeText(RecipeList.this, type, Toast.LENGTH_SHORT).show();


        setContentView(R.layout.activity_recipe_list);
        listView= (ListView) findViewById(R.id.recipeList);

        StoredRecipe storedRecipe = StoredRecipe.getInstance();
        List<Recipe> listOfRecipe = storedRecipe.getRecipes();

        int [] pic = new int [listOfRecipe.size()];

        String[] names = new String[listOfRecipe.size()];{
            for (int i =0; i <listOfRecipe.size();i++){
                names[i] = listOfRecipe.get(i).name;
                pic[i] = listOfRecipe.get(i).recipePic;
            }


        };

        //add names
        final ArrayList<String> listNames = new ArrayList<String>();
        for (int i=0;i<names.length;i++){
            listNames.add(names[i]);
        }
        //Add pictures
        final ArrayList<Integer> listPic = new ArrayList<Integer>();
        for (int i=0;i<pic.length;i++){
            listPic.add(pic[i]);
        }

        // add both names and pictures to the adapter
        final ArrayAdapter adapter = new RecipeAdapter(this,names,pic);

        listView.setAdapter(adapter);

        //To delete a recipe longClickListener enabled
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(final AdapterView<?> arg0, View arg1,
                                           final int pos, long id) {

                //alert dialog pops up
                AlertDialog.Builder builder = new AlertDialog.Builder(RecipeList.this);
                builder.setTitle("Delete");
                builder.setMessage("Are you sure you want to delete this recipe?");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    /**
                     *
                     * @param dialog the pop up box
                     * @param ii the position of what you click
                     */
                    public void onClick(DialogInterface dialog, int ii) {

                        StoredRecipe.getInstance().reci.remove(pos);

                        adapter.notifyDataSetChanged();

                        listView.refreshDrawableState();

                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int ii) {
                                dialog.dismiss();
                            }
                        }
                );
                builder.show();
                return true;
            }
        });
        //notify the change
        adapter.notifyDataSetChanged();

        //Listener for when you click on a recipe in the list it brings it to the right page.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             *
             * @param parent
             * @param view the view
             * @param position the position where you will click on
             * @param id
             */
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);

                Intent intent = new Intent (getApplicationContext(), RecipeDetail.class);
                intent.putExtra("key",position);
                startActivityForResult(intent,0);


            }
        });

    }


    /**
     *We couldnt end up using this function but the purpose was to display the image and name of each recipe on the list.
     * @param recipes a list of all the recipes
     */
    public  void recieveRecipes(List<Recipe> recipes){
        setContentView(R.layout.activity_recipe_list);
        final ListView listView = (ListView) findViewById(R.id.recipeList);

        StoredRecipe storedRecipe = StoredRecipe.getInstance();
        List<Recipe> listOfRecipe = storedRecipe.getRecipes();

        int [] pic = new int [recipes.size()];

        String[] names = new String[recipes.size()];{

            for (int i =0; i <recipes.size();i++){
                names[i] =recipes.get(i).name;
                pic[i] = recipes.get(i).recipePic;

            }


        };

        final ArrayList<String> listNames = new ArrayList<String>();
        for (int i=0;i<names.length;i++){
            listNames.add(names[i]);
            listNames.add(names[i]);
        }

        final ArrayList<Integer> listPic = new ArrayList<Integer>();
        for (int i=0;i<pic.length;i++){
            listPic.add(pic[i]);
        }



    }

    /**
     *Create toolbar
     * @param menu the toolbar
     * @return
     */
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_resource, menu);
        return true;

    }

}
