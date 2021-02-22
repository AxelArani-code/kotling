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
import com.example.datefire.R;
import com.example.datefire.model.BurgerModel;
import com.example.datefire.model.ChipsModel;
import com.firebase.ui.firestore.SnapshotParser;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.List;

public class ChipsActivity extends AppCompatActivity implements ChipsAdapter.OnListItemClick {
    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFirestoresList;
    private ChipsAdapter adapter;
    private List<ChipsModel> chipsModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chips2);

        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoresList = findViewById(R.id.firestore_list_Chips);

        //Query
        Query query = firebaseFirestore.collection("Chips");

        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(1000)
                .setPageSize(3)
                .build();
        //RecyclerView
        FirestorePagingOptions<ChipsModel> options = new FirestorePagingOptions.Builder<ChipsModel>()
                .setLifecycleOwner(this)
                .setQuery(query, config, new SnapshotParser<ChipsModel>() {
                    @NonNull
                    @Override
                    public ChipsModel parseSnapshot(@NonNull DocumentSnapshot snapshot) {
                        ChipsModel chipsModel = snapshot.toObject(ChipsModel.class);
                        String itemId = snapshot.getId();
                        chipsModel.setItem_id(itemId);
                        return chipsModel;
                    }
                })
                .build();
        adapter = new ChipsAdapter(options,this);
        mFirestoresList.setHasFixedSize(true);
       mFirestoresList.setLayoutManager(new LinearLayoutManager(this));
       mFirestoresList.setAdapter(adapter);
    }

    @Override
    public void onItemClick(DocumentSnapshot snapshot, int position) {
        Log.d("Item Click ", "Clicked the item "  + position  +"And eh ID: " +snapshot.getId());
    }
}