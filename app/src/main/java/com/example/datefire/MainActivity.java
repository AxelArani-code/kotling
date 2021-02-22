package com.example.datefire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.datefire.Adapter.FirestoreAdapter;
import com.example.datefire.model.ProductsModel;
import com.firebase.ui.firestore.SnapshotParser;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MainActivity extends AppCompatActivity implements FirestoreAdapter.OnListItemClick {

private FirebaseFirestore firebaseFirestore;
private RecyclerView mFirestoresList;
private FirestoreAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoresList = findViewById(R.id.firestore_list);

     //Query
        Query query = firebaseFirestore.collection("Products");

        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(10)
                .setPageSize(3)
                .build();
        //RecyclerView
        FirestorePagingOptions<ProductsModel> options = new FirestorePagingOptions.Builder<ProductsModel>()
                .setLifecycleOwner(this)
                .setQuery(query, config, new SnapshotParser<ProductsModel>() {
                    @NonNull
                    @Override
                    public ProductsModel parseSnapshot(@NonNull DocumentSnapshot snapshot) {
                        ProductsModel productsModel = snapshot.toObject(ProductsModel.class);
                        String itemId = snapshot.getId();
                        productsModel.setItem_id(itemId);
                        return productsModel;
                    }
                })
                .build();

        adapter = new FirestoreAdapter(options,this);

        mFirestoresList.setHasFixedSize(true);
        mFirestoresList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoresList.setAdapter(adapter);
    }

    @Override
    public void onItemClick(DocumentSnapshot snapshot,int position) {
        Log.d("Item Click ", "Clicked the item "  + position  +"And eh ID: " +snapshot.getId());
    }
}