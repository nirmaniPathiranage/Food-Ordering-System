package com.example.nano_science.menucrud;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    SQLiteDatabase mDatabase;
    List<FoodMenu> foodMenuList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mDatabase = openOrCreateDatabase(MainActivity.DATABASE_NAME, MODE_PRIVATE, null);

        foodMenuList = new ArrayList<>();

        listView = (ListView)findViewById(R.id.listViewMenus);

        loadMenusFromDatabase();
    }

    private void loadMenusFromDatabase(){

        String sql = "SELECT * FROM food";

         Cursor cursor = mDatabase.rawQuery(sql, null);

         if (cursor.moveToFirst()){
             do{

                 foodMenuList.add(new FoodMenu(
                       cursor.getInt(0),
                         cursor.getString(1),
                         cursor.getString(2),
                         cursor.getString(3),
                         cursor.getDouble(4)

                 ) );


             }while (cursor.moveToNext());

             FoodMenuAdapter adapter = new FoodMenuAdapter(this, R.layout.list_layout_menus, foodMenuList, mDatabase);
             listView.setAdapter(adapter);

         }

    }
}
