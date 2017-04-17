package com.example.eyobt.cook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;


public class AddInstruction extends AppCompatActivity {

    String allInstr="";
    ArrayList<String> values = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activty_add_instruction);

    }

    //adding instruction to the instruction list
    public void onAddPressed(View view) {
        EditText txt = (EditText) findViewById(R.id.editText_CustomInstruction);
        values.add(txt.getText().toString()+"\n");
        allInstr="";
        txt.setText("");

        String[] instr_strings = new String[values.size()];
        for (int j=0; j<values.size(); j++){
            instr_strings[j] = (j+1)+". "+ values.get(j);
            allInstr = allInstr.concat(instr_strings[j]);
        }

        refreshList(instr_strings);

    }

    // update the list with the parameter values
    public void refreshList(String[] values) {

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_item_ingredient, R.id.ingr_name, values);

        ListView listView_instr = (ListView) findViewById(R.id.listView_Instructions);

        listView_instr.setAdapter(adapter);

    }

    //Send instruction input to addrecipe class
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("INSTRUCTIONS", allInstr);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
