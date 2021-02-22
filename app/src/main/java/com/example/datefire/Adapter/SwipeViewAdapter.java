package com.example.datefire.Adapter;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.datefire.R;
import com.example.datefire.model.SwipeList;

import java.util.ArrayList;

public class SwipeViewAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<SwipeList> modelArrayList;
    //Cntructor
    public SwipeViewAdapter(Context context, ArrayList<SwipeList> modelArrayList) {

        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //Inflater Car_itmes
        View view = LayoutInflater.from(context).inflate(R.layout.card_items,container,false);

        ImageView bannerIv = view.findViewById(R.id.bannerIv);
        TextView titleTv = view.findViewById(R.id.titleTv);
        TextView descriptionTv = view.findViewById(R.id.descriptionTv);
        TextView dateTv = view.findViewById(R.id.dateTv);

        //get Data
        SwipeList model = modelArrayList.get(position);
        String title = model.getTitle();
        String description = model.getDescription();
        String date = model.getDate();
        int image = model.getImage();

        //SET DATA
        bannerIv.setImageResource(image);
        titleTv.setText(title);
        descriptionTv.setText(description);
        dateTv.setText(date);

        //handle card click
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, title+ "\n" + description+ "\n"+date, Toast.LENGTH_SHORT).show();


            }
        });
        //add view to container
        container.addView(view, position);

        return view;
    }
    public interface OnNoteListener{
        void onNotelistener(int position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

}
