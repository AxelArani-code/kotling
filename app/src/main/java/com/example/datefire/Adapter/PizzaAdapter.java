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
import com.example.datefire.model.ChipsModel;
import com.example.datefire.model.PizzaModel;
import com.example.datefire.ui.View.BurgerView;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PizzaAdapter extends FirestorePagingAdapter<PizzaModel, PizzaAdapter.PizzaViewHolder> implements View.OnLongClickListener {
    private List<PizzaModel> model;
    private View.OnClickListener onClickListener;
    View.OnLongClickListener onLongClickListener;
    private Context context;

    public PizzaAdapter(@NonNull FirestorePagingOptions<PizzaModel> options, Context context) {
        super(options);
        this.model = model;
        this.onClickListener = onClickListener;
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull PizzaViewHolder holder, int position, @NonNull PizzaModel model) {
        holder.presio.setText(model.getPresio());
        holder.titulo.setText(model.getTitulo());
        holder.descrp.setText(model.getDescrp());
        holder.like.setText(model.getLike());
        holder.calorias.setText(model.getCalorias());
        Picasso.get().load(model.getImg_Pizza()).into(holder.img_Pizza);
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
    public PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pizza, parent,false);
        view.setOnLongClickListener(this);
        return new PizzaViewHolder(view);
    }
    @Override
    public boolean onLongClick(View v) {
        onLongClickListener.onLongClick(v);
        return true;
    }

    public interface OnListItemClick {
        void onItemClick(DocumentSnapshot snapshot, int position);
    }

    public class PizzaViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        private TextView calorias, presio, like, tamaño, titulo , descrp;
        private ImageView img_Pizza;
        public PizzaViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.list_name_Pizza);
            descrp = itemView.findViewById(R.id.list_descrp_Pizza);
            like = itemView.findViewById(R.id.like_Pizza);
            calorias = itemView.findViewById(R.id.calorias_Pizza);
            tamaño = itemView.findViewById(R.id.porcion_Pizza);
            calorias = itemView.findViewById(R.id.calorias_Pizza);
            img_Pizza = itemView.findViewById(R.id.img_resources_Pizza);
            presio = itemView.findViewById(R.id.presio_Pizza);

            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {

        }
    }
}
