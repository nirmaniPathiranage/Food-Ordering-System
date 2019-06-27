package com.example.nano_science.myapplication;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
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
    Button btnViewAll;
    Button btnUpdateData;
    Button btnDeleteData;

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
        btnViewAll = (Button)findViewById(R.id.button_view);
        btnUpdateData = (Button)findViewById(R.id.button_update);
        btnDeleteData = (Button)findViewById(R.id.button_delete);

        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }

    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        String menuid = editMenuId.getText().toString().trim();
                        String foodcode = editFoodCode.getText().toString().trim();
                        String foodname = editFoodName.getText().toString().trim();
                        String foodType = editFoodType.getText().toString().trim();
                        String recipe = editRecipe.getText().toString().trim();
                        String price = editPrice.getText().toString().trim();

                        //validate data

                        if(menuid.isEmpty()){
                            editMenuId.setError("Menu ID can't be empty");
                            editMenuId.requestFocus();
                            return;
                        }

                        if(foodcode.isEmpty()){
                            editFoodCode.setError("Food Code can't be empty");
                            editFoodCode.requestFocus();
                            return;
                        }

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


                        boolean isInserted = myDb.insertData(menuid, foodcode, foodname, foodType, recipe, price);

                        if (isInserted == true)
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void viewAll(){
        btnViewAll.setOnClickListener(
               new View.OnClickListener(){

                   @Override
                   public void onClick(View v){
                       Cursor cursor = myDb.getAllData();

                       if (cursor.getCount() == 0){

                           // show message

                           showMessage("Error", "Nothing found");
                           return;
                       }

                       StringBuffer buffer = new StringBuffer();

                       while (cursor.moveToNext()){
                           buffer.append("Menu ID : " + cursor.getString(0) + "\n");
                           buffer.append("Food Code : " + cursor.getString(1) + "\n");
                           buffer.append("Food Name : " + cursor.getString(2) + "\n");
                           buffer.append("Food Type : " + cursor.getString(3) + "\n");
                           buffer.append("Recipe : " + cursor.getString(4) + "\n");
                           buffer.append("Price : " + cursor.getString(5) + "\n\n");
                       }

                       //Show all data

                       showMessage("Data",buffer.toString());

                   }

               }
        );

    }

    public void showMessage(String title, String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void UpdateData() {
        btnUpdateData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editMenuId.getText().toString(), editFoodCode.getText().toString(), editFoodName.getText().toString(), editFoodType.getText().toString(), editRecipe.getText().toString(), editPrice.getText().toString());

                        if (isUpdate == true)
                            Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void DeleteData(){
        btnDeleteData.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Integer deletedRows = myDb.deleteData(editFoodCode.getText().toString());

                        if (deletedRows > 0)
                            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}