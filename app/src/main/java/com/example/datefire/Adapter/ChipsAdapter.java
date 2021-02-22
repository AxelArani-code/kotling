package com.example.datefire.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datefire.R;
import com.example.datefire.model.ChipsModel;
import com.example.datefire.ui.View.BurgerView;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChipsAdapter extends FirestorePagingAdapter<ChipsModel, ChipsAdapter.ChipsViewHolder> implements View.OnLongClickListener {

    private List<ChipsModel> model;
    private View.OnClickListener onClickListener;
    View.OnLongClickListener onLongClickListener;
    private Context context;

    public ChipsAdapter(@NonNull FirestorePagingOptions<ChipsModel> options, Context context) {
        super(options);
        this.model = model;
        this.onClickListener = onClickListener;
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ChipsViewHolder holder, int position, @NonNull ChipsModel model) {
        holder.presio.setText(model.getPresio());
        holder.titulo.setText(model.getTitulo());
        holder.descrp.setText(model.getDescrp());
        holder.like.setText(model.getLike());
        holder.calorias.setText(model.getCalorias());
        Picasso.get().load(model.getImg_Papas()).into(holder.img_Papas);
        holder.tamaño.setText(model.getTamaño() + "");


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
    public ChipsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_chips, parent,false);
        view.setOnLongClickListener(this);
        return new ChipsViewHolder(view);
    }

    @Override
    public boolean onLongClick(View v) {
        onLongClickListener.onLongClick(v);
        return true;
    }

    public interface OnListItemClick {
        void onItemClick(DocumentSnapshot snapshot, int position);
    }

    public class ChipsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView calorias, presio, like, tamaño, titulo , descrp;
        private ImageView img_Papas;
        public ChipsViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.list_name_Chips);
            descrp = itemView.findViewById(R.id.list_descrp_Chips);
            like = itemView.findViewById(R.id.like_Chips);
            calorias = itemView.findViewById(R.id.calorias_Chips);
            tamaño = itemView.findViewById(R.id.porcion_Chips);
            calorias = itemView.findViewById(R.id.calorias_Chips);
            img_Papas = itemView.findViewById(R.id.img_resources_Chips);
            presio = itemView.findViewById(R.id.presio_Chips);
            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {

        }
    }
}
