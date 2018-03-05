package com.ky.kitchies;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

import com.yalantis.pulltomakesoup.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    List<Category> lstcategory;
    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_category,container,false);

        lstcategory=new ArrayList<>();

        lstcategory.add(new Category("Snaks","Snack",getString(R.string.cutles),R.drawable.food1));
        lstcategory.add(new Category("Soup and Drinkd","Light Snack",getString(R.string.panipuri),R.drawable.food2));
        lstcategory.add(new Category("Curries","Soup",getString(R.string.rusiansalad),R.drawable.food3));
        lstcategory.add(new Category("Children Specail","Lightsnack",getString(R.string.sevpuri),R.drawable.food4));
        lstcategory.add(new Category("Punjabi","Salad",getString(R.string.indiansalad),R.drawable.food5));
        lstcategory.add(new Category("Gujarati","Sweet",getString(R.string.doughnut),R.drawable.food6));

        lstcategory.add(new Category("Snaks","Snack",getString(R.string.cutles),R.drawable.food1));
        lstcategory.add(new Category("Soup and Drinkd","Light Snack",getString(R.string.panipuri),R.drawable.food2));
        lstcategory.add(new Category("Curries","Soup",getString(R.string.rusiansalad),R.drawable.food3));
        lstcategory.add(new Category("Children Specail","Lightsnack",getString(R.string.sevpuri),R.drawable.food4));
        lstcategory.add(new Category("Punjabi","Salad",getString(R.string.indiansalad),R.drawable.food5));
        lstcategory.add(new Category("Gujarati","Sweet",getString(R.string.doughnut),R.drawable.food6));

        lstcategory.add(new Category("Snaks","Snack",getString(R.string.cutles),R.drawable.food1));
        lstcategory.add(new Category("Soup and Drinkd","Light Snack",getString(R.string.panipuri),R.drawable.food2));
        lstcategory.add(new Category("Curries","Soup",getString(R.string.rusiansalad),R.drawable.food3));
        lstcategory.add(new Category("Children Specail","Lightsnack",getString(R.string.sevpuri),R.drawable.food4));
        lstcategory.add(new Category("Punjabi","Salad",getString(R.string.indiansalad),R.drawable.food5));
        lstcategory.add(new Category("Gujarati","Sweet",getString(R.string.doughnut),R.drawable.food6));

        RecyclerView myrv=(RecyclerView) view.findViewById(R.id.recyclerview_id1);
        RecyclerViewAdapter myAdapter =new RecyclerViewAdapter(this.getActivity(),lstcategory);
        myrv.setLayoutManager(new GridLayoutManager(this.getActivity(),1));
        myrv.setAdapter(myAdapter);

        final PullToRefreshView mPullToRefreshView;

        mPullToRefreshView = (PullToRefreshView) view.findViewById(R.id.pullrefresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //To Load New Category.
            }
        });

        return view;
    }

}
