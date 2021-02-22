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
import com.example.datefire.model.BurgerModel;
import com.example.datefire.ui.View.BurgerView;
import com.example.datefire.ui.View.CervezaView;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BurgerAdapter extends FirestorePagingAdapter<BurgerModel, BurgerAdapter.BurgerViewHolder>implements View.OnLongClickListener {

    private List<BurgerModel> model;
    private View.OnClickListener onClickListener;
    private Context context;

    View.OnLongClickListener onLongClickListener;

    public BurgerAdapter(@NonNull FirestorePagingOptions<BurgerModel> options, Context context) {
        super(options);
        this.model = model;
        this.onClickListener = onClickListener;
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull BurgerViewHolder holder, int position, @NonNull BurgerModel model) {
        holder.titulo.setText(model.getTitulo());
        holder.like.setText(model.getLike());
        holder.descrp.setText(model.getDescrp());
        holder.presio.setText(model.getPresio());
        holder.tamaño.setText(model.getTamaño());
        Picasso.get().load(model.getImg_Hambur()).into(holder.img_Hambur);
        holder.calorias.setText(model.getCalorias() + "");


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(holder.itemView.getContext(), BurgerView.class);
                intent.putExtra("itemDetail", model);
                holder.itemView.getContext().startActivity(intent);



            }
        });
    }

    @NonNull
    @Override
    public BurgerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_burger, parent,false);
        view.setOnLongClickListener(this);
        return new BurgerViewHolder(view);
    }

    public boolean onLongClickListener(View.OnLongClickListener onLongClickListener){
        this.onLongClickListener = onLongClickListener;
        return true;
    }
    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    public class BurgerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView calorias, presio, like, tamaño, titulo , descrp;
        private ImageView img_Hambur;
        public BurgerViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.list_name_Burger);
            calorias = itemView.findViewById(R.id.calorias_Buerger);
            presio = itemView.findViewById(R.id.presio_Burger);
            like = itemView.findViewById(R.id.like_Burger);
            descrp = itemView.findViewById(R.id.list_descrp_Burger);
            tamaño = itemView.findViewById(R.id.tamaño_Buerger);
            img_Hambur = itemView.findViewById(R.id.img_resources_Burger);


        }

        @Override
        public void onClick(View v) {

        }
    }
    public interface OnListItemClick{
        void onItemClick(DocumentSnapshot snapshot, int position);
    }
}
