package com.example.datefire.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.datefire.Adapter.ChipsAdapter;
import com.example.datefire.Adapter.PizzaAdapter;
import com.example.datefire.R;
import com.example.datefire.model.ChipsModel;
import com.example.datefire.model.PizzaModel;
import com.firebase.ui.firestore.SnapshotParser;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.List;

public class PizzaActivity extends AppCompatActivity  implements PizzaAdapter.OnListItemClick{

    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFirestoresList;
    private PizzaAdapter adapter;
    private List<PizzaModel> pizzaModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoresList = findViewById(R.id.firestore_list_Pizza);

        //Query
        Query query = firebaseFirestore.collection("Pizza");

        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(1000)
                .setPageSize(3)
                .build();


        //RecyclerView
        FirestorePagingOptions<PizzaModel> options = new FirestorePagingOptions.Builder<PizzaModel>()
                .setLifecycleOwner(this)
                .setQuery(query, config, new SnapshotParser<PizzaModel>() {
                    @NonNull
                    @Override
                    public PizzaModel parseSnapshot(@NonNull DocumentSnapshot snapshot) {
                        PizzaModel pizzaModel = snapshot.toObject(PizzaModel.class);
                        String itemId = snapshot.getId();
                        pizzaModel.setItem_id(itemId);
                        return pizzaModel;
                    }
                })
                .build();

        adapter = new PizzaAdapter(options,this);
        mFirestoresList.setHasFixedSize(true);
        mFirestoresList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoresList.setAdapter(adapter);
    }

    @Override
    public void onItemClick(DocumentSnapshot snapshot, int position) {
        Log.d("Item Click ", "Clicked the item "  + position  +"And eh ID: " +snapshot.getId());
    }
}