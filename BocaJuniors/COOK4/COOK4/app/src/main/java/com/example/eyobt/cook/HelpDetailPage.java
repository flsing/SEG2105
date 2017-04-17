package com.example.eyobt.cook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;
import android.text.method.LinkMovementMethod;
import android.widget.Toast;

/**
 * The class that has all the details of the help page. It is only accessible via Help.java. Has 4 different pages
 */
public class HelpDetailPage extends AppCompatActivity {

    int text = 0;

    /**
     * On create method to create the class and the correct xml
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_detail_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Read the arguments from the Intent object.
        Intent in = getIntent ();
        text = in.getIntExtra (Help.ARG_TEXT_ID, 0);


        TextView textView = (TextView) findViewById (R.id.help_detail_text);
        textView.setMovementMethod (LinkMovementMethod.getInstance());
        textView.setText (Html.fromHtml (getString (text)));
    }

    /**
     * //Method for toolbar clicks. Intents to bring to right page, message box if invalid.
     * @param item the toolbar
     * @return
     */
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_edit) {
            MessageBox("You must be viewing a recipe");
            return true;
        }
        if (id == R.id.action_help) {
            MessageBox("You are already viewing the help page");
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

    /**
     * Method to toast a short message
     * @param message the message you would like it to display
     */
    public void MessageBox (String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}

