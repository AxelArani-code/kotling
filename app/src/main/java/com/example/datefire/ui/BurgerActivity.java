package com.example.datefire.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.datefire.Adapter.BebidaAdapter;
import com.example.datefire.Adapter.BurgerAdapter;
import com.example.datefire.R;
import com.example.datefire.model.BurgerModel;
import com.firebase.ui.firestore.SnapshotParser;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.List;

public class BurgerActivity extends AppCompatActivity implements BebidaAdapter.OnListItemClick {

    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFirestoresList;
    private List<BurgerModel> burgerModels;
    private BurgerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger);

        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoresList = findViewById(R.id.firestore_list_Burger);

        //Query
        Query query = firebaseFirestore.collection("Hamburguesas");

        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(1000)
                .setPageSize(3)
                .build();
        //RecyclerView
        FirestorePagingOptions<BurgerModel> options = new FirestorePagingOptions.Builder<BurgerModel>()
                .setLifecycleOwner(this)
                .setQuery(query, config, new SnapshotParser<BurgerModel>() {
                    @NonNull
                    @Override
                    public BurgerModel parseSnapshot(@NonNull DocumentSnapshot snapshot) {
                        BurgerModel burgerModel = snapshot.toObject(BurgerModel.class);
                        String itemId = snapshot.getId();
                        burgerModel.setItem_id(itemId);
                        return burgerModel;
                    }
                })
                .build();

        adapter = new BurgerAdapter(options,this);

        mFirestoresList.setHasFixedSize(true);
        mFirestoresList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoresList.setAdapter(adapter);
    }

    @Override
    public void onItemClick(DocumentSnapshot snapshot, int position) {
        Log.d("Item Click ", "Clicked the item "  + position  +"And eh ID: " +snapshot.getId());
    }
}