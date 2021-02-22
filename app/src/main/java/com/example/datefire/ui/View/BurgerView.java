package com.example.datefire.ui.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.datefire.R;
import com.example.datefire.model.BurgerModel;
import com.squareup.picasso.Picasso;

public class BurgerView extends AppCompatActivity {
    private TextView calorias, presio, like, tamaño, titulo , descrp;
    private ImageView img_Hambur;
    private BurgerModel burgerModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_view);

        initViews();
        initValues();
    }

    private void initViews() {
        presio = findViewById(R.id.Presio_Burger);
        titulo = findViewById(R.id.list_name_Burger);
        img_Hambur = findViewById(R.id.Image_Burger);
        descrp = findViewById(R.id.list_descrp_Burger);
    }
    private void initValues() {
        burgerModel = (BurgerModel) getIntent().getExtras().getSerializable("itemDetail");
        Picasso.get().load(burgerModel.getImg_Hambur()).into(img_Hambur);

        presio.setText(burgerModel.getPresio());
        titulo.setText(burgerModel.getTitulo());
        descrp.setText(burgerModel.getDescrp());


    }
}