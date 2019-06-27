package com.example.nano_science.menucrud;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FoodMenuAdapter extends ArrayAdapter<FoodMenu> {

    Context ctx;
    int layoutRes;
    List<FoodMenu> foodMenuList;
    SQLiteDatabase mDatabase;

    public FoodMenuAdapter(Context ctx, int layoutRes, List<FoodMenu> foodMenuList, SQLiteDatabase mDatabase){
        super(ctx, layoutRes, foodMenuList);

        this.ctx = ctx;
        this.layoutRes = layoutRes;
        this.foodMenuList = foodMenuList;
        this.mDatabase = mDatabase;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(layoutRes, null);

        TextView textViewFoodName = view.findViewById(R.id.textViewFoodName);
        TextView textViewFoodType = view.findViewById(R.id.textViewFoodType);
        TextView textViewRecipe = view.findViewById(R.id.textViewRecipe);
        TextView textViewPrice = view.findViewById(R.id.textViewPrice);

       final FoodMenu fm = foodMenuList.get(position);

        textViewFoodName.setText(fm.getFoodname());
        textViewFoodType.setText(fm.getFoodtype());
        textViewRecipe.setText(fm.getRecipe());
        textViewPrice.setText(String.valueOf(fm.getPrice()));


        Button buttonDelete = view.findViewById(R.id.buttonDeleteMenu);
        Button buttonEdit = view.findViewById(R.id.buttonEditMenu);

        //adding a clicklistner to button

        buttonEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                updateMenu(fm);
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteMenu(fm);

            }
        });

        return view;
    }

    private void updateMenu(final FoodMenu fm){

        final AlertDialog.Builder builder = new AlertDialog.Builder(ctx);

        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.dialog_update_menu, null);
        builder.setView(view);

        final EditText editTextFoodName = view.findViewById(R.id.editText_foodname);
        final Spinner spinner = view.findViewById(R.id.spinnerFoodtype);
        final EditText editTextRecipe = view.findViewById(R.id.editText_recipe);
        final EditText editTextPrice = view.findViewById(R.id.editText_price);

        editTextFoodName.setText(fm.getFoodname());
        editTextRecipe.setText(fm.getRecipe());
        editTextPrice.setText(String.valueOf(fm.getPrice()));

        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        view.findViewById(R.id.buttonUpdateMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String foodname = editTextFoodName.getText().toString().trim();
                String spinnermenu = spinner.getSelectedItem().toString().trim();
                String recipe = editTextRecipe.getText().toString().trim();
                String price = editTextPrice.getText().toString().trim();


                //validating editted fields

                if (foodname.isEmpty()){
                    editTextFoodName.setError("Food Name can't be empty");
                    editTextFoodName.requestFocus();
                    return;
                }

                if (recipe.isEmpty()){
                    editTextRecipe.setError("Recipe can't be empty");
                    editTextRecipe.requestFocus();
                    return;
                }

                if (price.isEmpty()){
                    editTextPrice.setError("Please enter salary accurately");
                    editTextPrice.requestFocus();
                    return;
                }


                String sql = "UPDATE food \n" + "SET foodname = ?, \n" +  "foodtype = ?, \n" +  "recipe = ?, \n" +  "price = ? \n" +  "WHERE menuid = ?; \n";

                mDatabase.execSQL(sql, new String[] {foodname, spinnermenu, recipe, price, String.valueOf(fm.getMenuid())  });

                Toast.makeText(ctx, "Menu Updated Successfully", Toast.LENGTH_SHORT).show();

                LoadMenuFromDatabaseAgain();

                alertDialog.dismiss();

            }
        });
    }

    private void  deleteMenu(final FoodMenu fm){

        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);

        builder.setTitle("Are you sure ?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                String sql = "DELETE FROM food WHERE menuid = ?";
                mDatabase.execSQL(sql, new Integer[]{fm.getMenuid()});
                LoadMenuFromDatabaseAgain();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void LoadMenuFromDatabaseAgain(){
        String sql = "SELECT * FROM food";

        Cursor cursor = mDatabase.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            foodMenuList.clear();
            do{

                foodMenuList.add(new FoodMenu(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getDouble(4)
                ) );


            }while (cursor.moveToNext());

            cursor.close();
            notifyDataSetChanged();

        }
    }


}
