package com.example.nano_science.menucrud;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String DATABASE_NAME = "FOA.db";

    SQLiteDatabase mDatabase;

    EditText editFoodName, editRecipe, editPrice;
    Spinner spinnerMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);

        createTable();

        editFoodName = (EditText)findViewById(R.id.editText_foodname);;
        editRecipe = (EditText)findViewById(R.id.editText_recipe);
        editPrice = (EditText)findViewById(R.id.editText_price);
        spinnerMenu = (Spinner)findViewById(R.id.spinnerFoodtype);

        findViewById(R.id.button_add).setOnClickListener(this);
        findViewById(R.id.textViewMenus).setOnClickListener(this);

    }

    private void createTable(){
        String sql = "CREATE TABLE IF NOT EXISTS food( \n" +
                "   menuid INTEGER NOT NULL CONSTRAINT foodmenu_pk PRIMARY KEY AUTOINCREMENT, \n" +
                "   foodname varchar(50) NOT NULL, \n" +
                "   foodtype varchar(50) NOT NULL, \n" +
                "   recipe varchar(200) NOT NULL, \n" +
                "   price double NOT NULL\n" +
                ");";

        mDatabase.execSQL(sql);

    }

    private void addMenu(){

        String foodname = editFoodName.getText().toString().trim();
        String foodtype = spinnerMenu.getSelectedItem().toString();
        String recipe = editRecipe.getText().toString().trim();
        String price = editPrice.getText().toString().trim();


        //validate data

        if (foodname.isEmpty()){
            editFoodName.setError("Food Name can't be empty");
            editFoodName.requestFocus();
            return;
        }

        if (recipe.isEmpty()){
            editRecipe.setError("Recipe can't be empty");
            editRecipe.requestFocus();
            return;
        }

        if (price.isEmpty() || Integer.parseInt(price) <= 0){
            editPrice.setError("Please enter salary accurately");
            editPrice.requestFocus();
            return;
        }


        String sql = "INSERT INTO food(foodname, foodtype, recipe, price)" +
                "VALUES (?, ?, ?, ?) ";

        mDatabase.execSQL(sql, new String[] {foodname, foodtype, recipe, price});

        Toast.makeText(this, "Menu Added Successfully", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_add:

                addMenu();

                break;

            case R.id.textViewMenus:

                startActivity(new Intent(this, MenuActivity.class));

                break;

        }

    }
}
