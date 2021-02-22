package com.example.datefire.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datefire.R;
import com.example.datefire.model.BebidasModel;
import com.example.datefire.ui.View.CervezaView;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BebidaAdapter extends FirestorePagingAdapter<BebidasModel, BebidaAdapter.BebidasViewHolder> implements View.OnLongClickListener {

    private OnListItemClick OnListItemClick;
    private List<BebidasModel> model;
    private Context context;

    View.OnLongClickListener onLongClickListener;

    public BebidaAdapter(@NonNull FirestorePagingOptions<BebidasModel> options, OnListItemClick onListItemClick) {
        super(options);
        this.OnListItemClick =onListItemClick;
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull BebidasViewHolder holder, int position, @NonNull BebidasModel model) {
        holder.list_name_Bebidas.setText(model.getName());
        holder.grado_bebida.setText(model.getGrado());
        holder.ml_bebida.setText(model.getMl());
        holder.like_bebidas.setText(model.getLike());
        holder.presio.setText(model.getPresio());
        Picasso.get().load(model.getImg_resources()).into(holder.img_resources_Bebidas);
        holder.list_descrp_Bebidas.setText(model.getDescrp() + "");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               Intent intent = new Intent(holder.itemView.getContext(), CervezaView.class);
                intent.putExtra("itemDetail", model);
                holder.itemView.getContext().startActivity(intent);



            }
        });
    }

    @NonNull
    @Override
    public BebidasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single, parent,false);
        view.setOnLongClickListener(this);
        return new BebidasViewHolder(view);
    }

    public boolean onLongClickListener(View.OnLongClickListener onLongClickListener){
        this.onLongClickListener = onLongClickListener;
        return true;
    }

    @Override
    public boolean onLongClick(View v) {
        onLongClickListener.onLongClick(v);
        return true;
    }

    public class BebidasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView list_name_Bebidas,list_descrp_Bebidas ,grado_bebida, ml_bebida, like_bebidas, presio;
        private ImageView img_resources_Bebidas;
        public BebidasViewHolder(@NonNull View itemView) {
            super(itemView);
            list_name_Bebidas = itemView.findViewById(R.id.list_name_Bebidas);
            list_descrp_Bebidas = itemView.findViewById(R.id.list_descrp_Bebidas);
            grado_bebida = itemView.findViewById(R.id.grado_bebida);
            ml_bebida = itemView.findViewById(R.id.ml_bebida);
            like_bebidas = itemView.findViewById(R.id.like_bebidas);
            presio = itemView.findViewById(R.id.presio_bebidas);
            img_resources_Bebidas = itemView.findViewById(R.id.img_resources_Bebidas);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
    public interface OnListItemClick{
        void onItemClick(DocumentSnapshot snapshot, int position);
    }
}
