package com.example.eyobt.cook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Help class has the details of how to help the user with information
 * It also has more buttons so that the user can get more specific information
 */
public class Help extends AppCompatActivity {

    private Toolbar toolbar;
    static public final String ARG_TEXT_ID = "text_id";

    /**
     * The oncreate method
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * When clicking on the button, it leads to the correct page.
     * @param view the buttons
     */
    public void onClickHelp(View view){
        int id = view.getId ();
        int helpDetail = -1;
        switch(id){
            case R.id.help_button1 :
                helpDetail = R.string.help_topic_search;
                break;
            case R.id.help_button2 :
                helpDetail = R.string.help_topic_add;
                break;
            case R.id.help_button3 :
                helpDetail = R.string.help_topic_modify;
                break;
            case R.id.help_button4 :
                helpDetail = R.string.help_text_delete;
                break;
            default:
                break;
        }
        if (helpDetail >= 0) startInfoActivity (helpDetail);
    }

    /**
     *
     * @param textId
     */
    public void startInfoActivity (int textId)
    {
        if (textId >= 0) {
            Intent intent = (new Intent(this, HelpDetailPage.class));
            intent.putExtra (ARG_TEXT_ID, textId);
            startActivityForResult(intent,0);
        } else {
            toast ("No information is available for topic: " + textId, true);
        }
    } // end startInfoActivity

    /**
     * Similar functionality to MessageBox. Toast a message
     * @param msg the message you would like to toast
     * @param longLength
     */
    public void toast (String msg, boolean longLength)
    {
        Toast.makeText (getApplicationContext(), msg,
                (longLength ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT)
        ).show ();
    }



    /**
     * create the Toolbar
     * @param menu the toolbar
     * @return
     */
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_resource, menu);
        return true;

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
