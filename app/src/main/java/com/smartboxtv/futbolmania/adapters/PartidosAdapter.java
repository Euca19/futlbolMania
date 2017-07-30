package com.smartboxtv.futbolmania.adapters;


import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smartboxtv.futbolmania.R;
import com.smartboxtv.futbolmania.models.Game.Item;

import java.util.List;

/**
 * Created by CRG on 28/07/2017.
 */

public class PartidosAdapter extends RecyclerView.Adapter<PartidosAdapter.MyViewHolder> {

    private Context mContext;
    private List<Item> partidoList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name_equipo1, name_equipo2, estado, fecha_star, text_ubicacion;
        AppCompatTextView result_1,result_2;
        public ImageView image_equipo1, image_equipo2, marker, calendar;



        public MyViewHolder(View view) {
            super(view);
            image_equipo1 = (ImageView) view.findViewById(R.id.thumbnail_1);
            name_equipo1  = (TextView)  view.findViewById(R.id.title_1);
            result_1      = (AppCompatTextView)  view.findViewById(R.id.resul_1);
            result_2      = (AppCompatTextView)  view.findViewById(R.id.resul_2);
            image_equipo2 = (ImageView) view.findViewById(R.id.thumbnail_2);
            name_equipo2  = (TextView)  view.findViewById(R.id.title_2);
            estado        = (TextView)  view.findViewById(R.id.estado);
            fecha_star    = (TextView)  view.findViewById(R.id.text_fecha);
            text_ubicacion= (TextView)  view.findViewById(R.id.text_ubicacion);
            marker        = (ImageView) view.findViewById(R.id.marker);
            calendar      = (ImageView) view.findViewById(R.id.calendar);



        }
    }


    public PartidosAdapter(Context mContext, List<Item> partidoList) {
        this.mContext = mContext;
        this.partidoList = partidoList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.partido_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
         Item partido = partidoList.get(position);
         holder.name_equipo1.setText(partido.getHomeTeam().getName());
         holder.name_equipo2.setText(partido.getAwayTeam().getName());
         holder.result_1.setText(partido.getHomeScore().toString());
         holder.result_2.setText(partido.getAwayScore().toString());
         holder.estado.setText(partido.getEventStatus().getName().getOriginal());
         holder.text_ubicacion.setText(partido.getLocation().getOriginal());
         holder.fecha_star.setText(partido.getMatchDay().getStart());


        if (position % 2 == 0)
        {
            System.out.println("Even" );
            Glide.with(mContext).load("").placeholder(R.drawable.ic_football_shield).dontAnimate().error(R.drawable.ic_football_shield).into(holder.image_equipo1);
            Glide.with(mContext).load("").placeholder(R.drawable.ic_football_shield).dontAnimate().error(R.drawable.ic_football_shield).into(holder.image_equipo2);

        }
        else
        {
            System.out.println("Odd" );
            Glide.with(mContext).load("").placeholder(R.drawable.ic_football_par).dontAnimate().error(R.drawable.ic_football_par).into(holder.image_equipo1);
            Glide.with(mContext).load("").placeholder(R.drawable.ic_football_par).dontAnimate().error(R.drawable.ic_football_par).into(holder.image_equipo2);

        }




    }





    @Override
    public int getItemCount() {
        return partidoList.size();
    }
}


