package com.ky.kitchies;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CategoryDetail extends AppCompatActivity {

    private TextView tvtitle, tvdescriptioin, tvcategory;
    private ImageView img;
    Dialog mydialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        mydialog = new Dialog(this);

        tvtitle = (TextView) findViewById(R.id.txttitle);
        tvcategory = (TextView) findViewById(R.id.txtcategory);
        tvdescriptioin = (TextView) findViewById(R.id.txtdescription);
        img = (ImageView) findViewById(R.id.categorythumbnail);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        String Category = intent.getExtras().getString("Category");
        int image = intent.getExtras().getInt("Thumbnail");

        tvtitle.setText(Title);
        tvdescriptioin.setText(Description);
        tvcategory.setText(Category);
        //img.setImageResource(image);
        Picasso.with(this).load(image).into(img);
    }

    public void showpopup(View v) {
        TextView txtclose;
        mydialog.setContentView(R.layout.convertor_popup);
        txtclose = (TextView) mydialog.findViewById(R.id.txtclose);

        final NumberPicker convertor1 = (NumberPicker) mydialog.findViewById(R.id.convertor1);
        final NumberPicker convertor2 = (NumberPicker) mydialog.findViewById(R.id.convertor2);
        final NumberPicker convertor3 = (NumberPicker) mydialog.findViewById(R.id.convertor3);

        final String[] values1 = {"1/3tbsp", "1tbsp", "2tbsp", "3 1/3tbsp", "6 2/3tbsp", "1tbsp oil", "1tbsp butter", "1tbsp honey","1tbsp flour","1tbsp sugar"};
        final String[] values2 = {"1tsp", "3tsp", "6tsp", "10tsp", "20tsp", "3tsp oil", "3tsp butter", "3tsp honey","3tsp flour","3tsp sugar"};
        final String[] values3 = {"5ml", "15ml", "30ml", "50ml", "100ml", "10ml", "10gm", "20gm","15gm","15gm"};

        convertor1.setWrapSelectorWheel(false);
        convertor2.setWrapSelectorWheel(false);
        convertor3.setWrapSelectorWheel(false);

        convertor1.setMinValue(0);
        convertor1.setMaxValue(values1.length - 1);
        convertor2.setMinValue(0);
        convertor2.setMaxValue(values2.length - 1);
        convertor3.setMinValue(0);
        convertor3.setMaxValue(values3.length - 1);

        convertor1.setDisplayedValues(values1);
        convertor2.setDisplayedValues(values2);
        convertor3.setDisplayedValues(values3);

        convertor1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                final int a = convertor1.getValue();
                convertor2.setValue(a);
                convertor3.setValue(a);
            }
        });

        convertor2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                final int a = convertor2.getValue();
                convertor1.setValue(a);
                convertor3.setValue(a);
            }
        });

        convertor3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                final int a = convertor3.getValue();
                convertor2.setValue(a);
                convertor1.setValue(a);
            }
        });


        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
}
