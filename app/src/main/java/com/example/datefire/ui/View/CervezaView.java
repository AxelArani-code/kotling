package com.example.datefire.ui.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.datefire.Adapter.SwipeViewAdapter;
import com.example.datefire.R;
import com.example.datefire.model.BebidasModel;
import com.example.datefire.model.SwipeList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CervezaView extends AppCompatActivity {
    private TextView list_name_Bebidas,list_descrp_Bebidas ,grado_bebida, ml_bebida, like_bebidas, presio;
    private ImageView img_resources_Bebidas;
    private BebidasModel bebidasModel;


    //actionBar
    private ActionBar actionBar;
    //Ui Views
    private ViewPager viewPager;
    private SwipeViewAdapter swipeViewAdapter;
    private ArrayList<SwipeList> modelArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        //Init actionBar
        actionBar = getSupportActionBar();
        //Init Ui Views
        viewPager = findViewById(R.id.viewPager);
        loadCards();

        initViews();
        initValues();
    }

    private void loadCards() {
        //Init List
        modelArrayList = new ArrayList<>();
        //add itmesss to list
        modelArrayList.add(new SwipeList(
                "Burgers",

                "ingredientes: " +
                        "1 pan para hamburguesa con sésamo\n" +
                        "180 gr de carne de ternera magra, bien molida\n" +
                        "Sal y pimienta, al gusto\n" +
                        "4 aros de cebolla roja, cruda\n" +
                        "2 tochas de beicon o panceta 2 lonchas finas de queso Cheddar\n" +
                        "Kétchup, al gusto\n" +
                        "Mayonesa, al gusto",
                "$250",
                R.drawable.img_1));
        modelArrayList.add(new SwipeList(
                "Lomito + Cerveza",
                "Ingrrdientes: "+
                        "300 gramos lomito\n"+
                        "1 cebolla mediana\n"+
                        "1/2 morrón\n"+
                        "50 gramos panceta ahumada o salada (a gusto de cada uno)   \n"+
                        "4 huevos\n"+
                        "50 gramos jamón cocido\n"+
                        "50 gramos que tipo tybo\n"+
                        "1 cucharada aceite girasol u oliva",
                "$450",
                R.drawable.img_2));
        modelArrayList.add(new SwipeList(
                "Mojito Cubano",
                "Ingredientes:  "+
                        "2  cucharaditas de azúcar blanco\n"+
                        "8 hojas de hierbabuena (2 ramitas de menta)\n"+
                        "30 ml de zumo de lima\n"+
                        "60 ml. de ron cubano (hemos empleado Havana Club Añejo 3 Años)\n"+
                        "1/2 lima en rodajas o cuartos\n"+
                        "1/2 lima en rodajas o cuartos\n"+
                        "Unas gotas de angostura (opcional)\n"+
                        "Hielo picado o pilé",
                "$250",
                R.drawable.img_3));
        modelArrayList.add(new SwipeList(
                "Pizza-Clasica",
                "Ingradientes: "+
                        "Queso\n"+
                        "Cebolla\n"+
                        "aceitunas\n"+
                        "Huevos\n"+
                        "Morron",
                "$280",
                R.drawable.img_4));


        //setuo adapter
        swipeViewAdapter = new SwipeViewAdapter(this,modelArrayList);
        //set adapter to view pager
        viewPager.setAdapter(swipeViewAdapter);
        //ser defaul padding from left/right
        viewPager.setPadding(100,0,100,0);
    }


    private void initViews() {
        presio = findViewById(R.id.Presio);
        list_name_Bebidas = findViewById(R.id.list_name_Bebidas);
        list_descrp_Bebidas = findViewById(R.id.list_descrp_Bebidas);
        img_resources_Bebidas = findViewById(R.id.Image_Bebidas);


    }
    private void initValues() {
        bebidasModel = (BebidasModel) getIntent().getExtras().getSerializable("itemDetail");
        Picasso.get().load(bebidasModel.getImg_resources()).into(img_resources_Bebidas);

        presio.setText(bebidasModel.getPresio());
        list_descrp_Bebidas.setText(bebidasModel.getDescrp());
        list_name_Bebidas.setText(bebidasModel.getName());


    }
}