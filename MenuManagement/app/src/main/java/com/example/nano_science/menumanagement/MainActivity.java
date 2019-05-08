package com.example.nano_science.menumanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editMenuId, editFoodCode, editFoodName, editFoodType, editRecipe, editPrice;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        editMenuId = (EditText)findViewById(R.id.editText_menuid);
        editFoodCode = (EditText)findViewById(R.id.editText_foodcode);
        editFoodName = (EditText)findViewById(R.id.editText_foodname);
        editFoodType = (EditText)findViewById(R.id.editText_foodtype);
        editRecipe = (EditText)findViewById(R.id.editText_recipe);
        editPrice = (EditText)findViewById(R.id.editText_price);
        btnAddData = (Button)findViewById(R.id.button_add);

        AddData();

    }

    public void AddData(){
        btnAddData.setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    boolean isInserted = myDb.insertData(editMenuId.getText().toString(),
                            editFoodCode.getText().toString(),
                            editFoodName.getText().toString(),
                            editFoodType.getText().toString(),
                            editRecipe.getText().toString(),
                            editPrice.getText().toString());

                    if (isInserted = true)
                        Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();

                }
            }
            );
    }

}
