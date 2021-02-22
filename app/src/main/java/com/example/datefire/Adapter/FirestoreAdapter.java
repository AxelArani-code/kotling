package com.example.datefire.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datefire.R;
import com.example.datefire.model.ProductsModel;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.firebase.ui.firestore.paging.LoadingState;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Picasso;

public class FirestoreAdapter extends FirestorePagingAdapter<ProductsModel, FirestoreAdapter.ProductsViewHolder> {

private OnListItemClick  OnListItemClick;

    public FirestoreAdapter(@NonNull FirestorePagingOptions<ProductsModel> options, OnListItemClick onListItemClick) {
        super(options);
        this.OnListItemClick = onListItemClick;
    }

    @Override
    protected void onBindViewHolder(@NonNull ProductsViewHolder holder, int position, @NonNull ProductsModel model) {
        holder.list_name.setText(model.getName());
        Picasso.get().load(model.getImage_list()).into(holder.image_list);
        holder.list_price.setText(model.getPrice() + "");
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single, parent,false);
        return new ProductsViewHolder(view);
    }
    @Override
    protected void onLoadingStateChanged(@NonNull LoadingState state){
        super.onLoadingStateChanged(state);
        switch (state){
            case LOADING_INITIAL:
                Log.d("PAGING_LOG","Loading Initial Data");
                break;
            case LOADING_MORE:
                Log.d("PAGING_LOG","Loading  Next Page");
                break;
            case FINISHED:
                Log.d("PAGING_LOG","All Data Loaded");
                break;
            case ERROR:
                Log.d("PAGING_LOG","Error Loading Date");
                break;
            case LOADED:
                Log.d("PAGING_LOG","Total Items:  " + getItemCount());
                break;
        }
    }




    public class ProductsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView list_name, list_price;
        private ImageView image_list;

        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            list_name = itemView.findViewById(R.id.list_name);
            list_price = itemView.findViewById(R.id.list_price);
            image_list = itemView.findViewById(R.id.image_list);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            OnListItemClick.onItemClick(getItem(getAdapterPosition()),getAdapterPosition());
        }
    }
    public interface OnListItemClick{
        void onItemClick(DocumentSnapshot snapshot, int position);
    }
}
