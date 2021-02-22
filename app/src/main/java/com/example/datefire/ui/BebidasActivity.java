package com.example.datefire.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.datefire.Adapter.BebidaAdapter;
import com.example.datefire.R;
import com.example.datefire.model.BebidasModel;
import com.firebase.ui.firestore.SnapshotParser;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.List;

public class BebidasActivity extends AppCompatActivity implements BebidaAdapter.OnListItemClick {

    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFirestoresList;

    private TextView list_name_Bebidas,list_descrp_Bebidas;
    private BottomSheetDialog bottomSheetDialog;
    private int position;

    private List<BebidasModel> bebidasModels;

    BebidaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);

        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoresList = findViewById(R.id.firestore_list);


        //Query
        Query query = firebaseFirestore.collection("Bebidas");

        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(1000)
                .setPageSize(3)
                .build();
        //RecyclerView
        FirestorePagingOptions<BebidasModel> options = new FirestorePagingOptions.Builder<BebidasModel>()
                .setLifecycleOwner(this)
                .setQuery(query, config, new SnapshotParser<BebidasModel>() {
                    @NonNull
                    @Override
                    public BebidasModel parseSnapshot(@NonNull DocumentSnapshot snapshot) {
                        BebidasModel bebidasModel = snapshot.toObject(BebidasModel.class);
                        String itemId = snapshot.getId();
                        bebidasModel.setItem_id(itemId);
                        return bebidasModel;
                    }
                })
                .build();

        adapter = new BebidaAdapter(options,this);

        mFirestoresList.setHasFixedSize(true);
        mFirestoresList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoresList.setAdapter(adapter);
    }


    @Override
    public void onItemClick(DocumentSnapshot snapshot,int position) {
        Log.d("Item Click ", "Clicked the item "  + position  +"And eh ID: " +snapshot.getId());
    }
}