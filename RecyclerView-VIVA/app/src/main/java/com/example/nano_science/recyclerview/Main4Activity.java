package com.example.nano_science.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    MenuAdapter adapter;
    List<Menu> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        menuList = new ArrayList<>();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //adding some items to our list

        menuList.add(
                new Menu(
                        1,
                        "Cheese Pizza",
                        "Thin crust cheese pizza with tomato",
                        1450,
                        R.drawable.cheesepizza));

        menuList.add(
                new Menu(
                        1,
                        "Sausage Pizza",
                        "Italian thin crust sausage pizza",
                        1750,
                        R.drawable.chickenpizza));

        menuList.add(
                new Menu(
                        1,
                        "Pasta",
                        "A plate of pasta with sausage, cheese and tomato sauce",
                        1000,
                        R.drawable.pasta));

        menuList.add(
                new Menu(
                        1,
                        "Spaghetti",
                        "A plate of spaghetti with sausage, cheese and tomato sauce",
                        1200,
                        R.drawable.spaghetti));

        menuList.add(
                new Menu(
                        1,
                        "Rice with Sea Food",
                        "A plate of fried rice with sea food ",
                        350,
                        R.drawable.seafood));

        menuList.add(
                new Menu(
                        1,
                        "Submarine",
                        "A delecious submarine bun pasted with a thin layer of cheese and sausage",
                        800,
                        R.drawable.submarine));

        menuList.add(
                new Menu(
                        1,
                        "Lasagna",
                        "Singular lasagna with cooked sausage, garlic over medium heat",
                        1000,
                        R.drawable.lasagna));




        adapter = new MenuAdapter(this, menuList);
        recyclerView.setAdapter(adapter);

    }
}
