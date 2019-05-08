package com.example.nano_science.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    MenuAdapter adapter;
    List<Menu> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        menuList = new ArrayList<>();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //adding some items to our list

        menuList.add(
                new Menu(
                        1,
                        "Milk Rice",
                        "3 cubes of Milk rice with a delicious dish of onion salad",
                        100,
                        R.drawable.milkrice));

        menuList.add(
                new Menu(
                        1,
                        "Noodles",
                        "A plate of vegetable noodles with a chicken curry",
                        220,
                        R.drawable.noodles));

        menuList.add(
                new Menu(
                        1,
                        "Vegetable Rolls",
                        "3 vegetable rolls with a spicy dish",
                        150,
                        R.drawable.rolls));

        menuList.add(
                new Menu(
                        1,
                        "Sandwiches",
                        "2 pieces of sandwiches with fish and meat",
                        140,
                        R.drawable.sandwiches));

        menuList.add(
                new Menu(
                        1,
                        "Pastry",
                        "2 fish pastries with mixed fish",
                        100,
                        R.drawable.pastry));

        menuList.add(
                new Menu(
                        1,
                        "Sausage Bun",
                        "2 sausage buns with tomato sauce",
                        140,
                        R.drawable.sausagebun));

        menuList.add(
                new Menu(
                        1,
                        "Chickpeas",
                        "A plate of fried chickpeas mixed with onion",
                        110,
                        R.drawable.chickpeas));




        adapter = new MenuAdapter(this, menuList);
        recyclerView.setAdapter(adapter);


    }
}
