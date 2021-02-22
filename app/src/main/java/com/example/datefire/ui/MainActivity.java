package com.example.datefire.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.datefire.Adapter.SwipeViewAdapter;
import com.example.datefire.R;
import com.example.datefire.model.SwipeList;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.firestore.FirebaseFirestore;
import com.zolad.zoominimageview.ZoomInImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //actionBar
    private ActionBar actionBar;

    //Ui Views
    private ViewPager viewPager;

    private ArrayList<SwipeList> modelArrayList;
    private SwipeViewAdapter swipeViewAdapter;


    //Variables Id
    private Button button, ButtomShare ;
    private ZoomInImageView buttomShow;
    private CardView itmes_pizzas, itmes_cerveza, itmes_Hamburgesas,itmes_Papas;
    private FirebaseFirestore firebaseFirestore;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Definig Cards
        itmes_pizzas = (CardView) findViewById(R.id.itmes_pizzas);
        itmes_cerveza = (CardView) findViewById(R.id.itmes_cerveza);
        itmes_Papas = (CardView) findViewById(R.id.itmes_Papas);
        itmes_Hamburgesas =(CardView)findViewById(R.id.itmes_Hamburgesas);

//Add Click listener to the cards
        itmes_pizzas.setOnClickListener(this);


        //Login Cerveza
        itmes_cerveza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(MainActivity.this);

                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);

                progressDialog.getWindow().setBackgroundDrawableResource(
                        android.R.color.transparent
                );
                Thread timer = new Thread(){
                    @Override
                    public void run() {
                        try {
                            sleep(2500);
                            Intent intent = new Intent(getApplicationContext(), BebidasActivity.class);
                            startActivity(intent);
                            progressDialog.dismiss();
                            super.run();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                };
                timer.start();
            }
        });


        //Login Cerveza
        itmes_Hamburgesas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(MainActivity.this);

                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);

                progressDialog.getWindow().setBackgroundDrawableResource(
                        android.R.color.transparent
                );
                Thread timer = new Thread(){
                    @Override
                    public void run() {
                        try {
                            sleep(2500);
                            Intent intent = new Intent(getApplicationContext(), BurgerActivity.class);
                            startActivity(intent);
                            progressDialog.dismiss();
                            super.run();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                };
                timer.start();
            }
        });

        //Login Cerveza
        itmes_Papas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(MainActivity.this);

                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);

                progressDialog.getWindow().setBackgroundDrawableResource(
                        android.R.color.transparent
                );
                Thread timer = new Thread(){
                    @Override
                    public void run() {
                        try {
                            sleep(2500);
                            Intent intent = new Intent(getApplicationContext(), ChipsActivity.class);
                            startActivity(intent);
                            progressDialog.dismiss();
                            super.run();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                };
                timer.start();
            }
        });

        //Login Cerveza
        itmes_pizzas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(MainActivity.this);

                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);

                progressDialog.getWindow().setBackgroundDrawableResource(
                        android.R.color.transparent
                );
                Thread timer = new Thread(){
                    @Override
                    public void run() {
                        try {
                            sleep(2500);
                            Intent intent = new Intent(getApplicationContext(), PizzaActivity.class);
                            startActivity(intent);
                            progressDialog.dismiss();
                            super.run();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                };
                timer.start();
            }
        });



        ZoomInImageView Click =findViewById(R.id.buttomShow);
        Click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        MainActivity.this, R.style.BottomSheetDialogTheme
                );
                View bottomShertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_dialogo,(LinearLayout)findViewById(R.id.bottomShetContainer));

                bottomShertView.findViewById(R.id.buttomShare).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Compartir
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        String shareBody = "Your bdy here";
                        String shareSub = "Suscribete";
                        intent.putExtra(intent.EXTRA_SUBJECT,shareBody);
                        intent.putExtra(intent.EXTRA_TEXT,shareSub);
                        startActivity(Intent.createChooser(intent, "Compartir"));

                        Toast.makeText(MainActivity.this,"",Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.setContentView(bottomShertView);
                bottomSheetDialog.show();
            }
        });

        //Buttom
        //button.setOnClickListener(this);



        //Init actionBar
        actionBar = getSupportActionBar();
        //Init Ui Views
        viewPager = findViewById(R.id.viewPager);
        loadCards();



        //set viewpager change listener
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //ill just change the title of actionbar
               /* String title = modelArrayList.get(position).getTitle();
                actionBar.setTitle(title);*/
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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



    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.itmes_cerveza : intent = new Intent(this, BebidasActivity.class); startActivity(intent); break;
            case R.id.itmes_Hamburgesas : intent = new Intent(this, BurgerActivity.class); startActivity(intent); break;
            default:break;
        }

    }


}