package com.ky.kitchies;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    List<Category> lstcategory;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_home,container,false);

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

        RecyclerView myrv=(RecyclerView) view.findViewById(R.id.recyclerview_id2);
        RecyclerViewAdapter myAdapter =new RecyclerViewAdapter(this.getActivity(),lstcategory);
        myrv.setLayoutManager(new GridLayoutManager(this.getActivity(),2));
        myrv.setAdapter(myAdapter);

        return view;
    }

}
