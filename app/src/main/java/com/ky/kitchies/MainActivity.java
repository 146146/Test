package com.ky.kitchies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Category> lstcategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstcategory=new ArrayList<>();

        lstcategory.add(new Category("Cutles","Snack",getString(R.string.cutles),R.drawable.food1));
        lstcategory.add(new Category("Panipuri","Light Snack",getString(R.string.panipuri),R.drawable.food2));
        lstcategory.add(new Category("RusianSalad","Soup",getString(R.string.rusiansalad),R.drawable.food3));
        lstcategory.add(new Category("Sevpuri","Lightsnack",getString(R.string.sevpuri),R.drawable.food4));
        lstcategory.add(new Category("Indian Salad","Salad",getString(R.string.indiansalad),R.drawable.food5));
        lstcategory.add(new Category("Doughnut","Sweet",getString(R.string.doughnut),R.drawable.food6));

        lstcategory.add(new Category("Cutles","Snack",getString(R.string.cutles),R.drawable.food1));
        lstcategory.add(new Category("Panipuri","Light Snack",getString(R.string.panipuri),R.drawable.food2));
        lstcategory.add(new Category("RusianSalad","Soup",getString(R.string.rusiansalad),R.drawable.food3));
        lstcategory.add(new Category("Sevpuri","Lightsnack",getString(R.string.sevpuri),R.drawable.food4));
        lstcategory.add(new Category("Indian Salad","Salad",getString(R.string.indiansalad),R.drawable.food5));
        lstcategory.add(new Category("Doughnut","Sweet",getString(R.string.doughnut),R.drawable.food6));

        lstcategory.add(new Category("Cutles","Snack",getString(R.string.cutles),R.drawable.food1));
        lstcategory.add(new Category("Panipuri","Light Snack",getString(R.string.panipuri),R.drawable.food2));
        lstcategory.add(new Category("RusianSalad","Soup",getString(R.string.rusiansalad),R.drawable.food3));
        lstcategory.add(new Category("Sevpuri","Lightsnack",getString(R.string.sevpuri),R.drawable.food4));
        lstcategory.add(new Category("Indian Salad","Salad",getString(R.string.indiansalad),R.drawable.food5));
        lstcategory.add(new Category("Doughnut","Sweet",getString(R.string.doughnut),R.drawable.food6));

        lstcategory.add(new Category("Cutles","Snack",getString(R.string.cutles),R.drawable.food1));
        lstcategory.add(new Category("Panipuri","Light Snack",getString(R.string.panipuri),R.drawable.food2));
        lstcategory.add(new Category("RusianSalad","Soup",getString(R.string.rusiansalad),R.drawable.food3));
        lstcategory.add(new Category("Sevpuri","Lightsnack",getString(R.string.sevpuri),R.drawable.food4));
        lstcategory.add(new Category("Indian Salad","Salad",getString(R.string.indiansalad),R.drawable.food5));
        lstcategory.add(new Category("Doughnut","Sweet",getString(R.string.doughnut),R.drawable.food6));

        RecyclerView myrv=(RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter =new RecyclerViewAdapter(this,lstcategory);
        myrv.setLayoutManager(new GridLayoutManager(this,1));
        //for horizontal rec. view myrv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        myrv.setAdapter(myAdapter);
    }
}
