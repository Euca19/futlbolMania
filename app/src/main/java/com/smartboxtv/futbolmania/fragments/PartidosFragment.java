package com.smartboxtv.futbolmania.fragments;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.smartboxtv.futbolmania.Broadcast;
import com.smartboxtv.futbolmania.PartidoAplication;
import com.smartboxtv.futbolmania.R;
import com.smartboxtv.futbolmania.Utils.Preferences;
import com.smartboxtv.futbolmania.adapters.PartidosAdapter;
import com.smartboxtv.futbolmania.interfaces.PartidoFactory;
import com.smartboxtv.futbolmania.models.Game.DataPartido;
import com.smartboxtv.futbolmania.models.Game.Item;
import org.codehaus.jackson.map.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class PartidosFragment  extends Fragment {
    public  static final  String TAG = PartidosFragment.class.getSimpleName();
    static PartidoFactory.PartidoInterfaces service =  PartidoFactory.getClient();
    private ViewGroup rootView;

    private PartidosAdapter adapter;
    List<Item> partidoList;
    HashMap<String, String> map = new HashMap<>();
    Preferences prefs;
    RecyclerView recyclerView;
    LottieAnimationView loading;
    LottieAnimationView empty_data;
    FrameLayout text_data;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_partido, container, false);
        ButterKnife.bind(this, rootView);


        Bundle bundle = this.getArguments();
        recyclerView  = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        loading       = (LottieAnimationView) rootView.findViewById(R.id.loading);
        empty_data    = (LottieAnimationView) rootView.findViewById(R.id.empty_data);
        text_data     = (FrameLayout) rootView.findViewById(R.id.text_data);
        loading.setVisibility(View.VISIBLE);



        if(bundle != null){
        }

        partidoList = new ArrayList<>();
        adapter = new PartidosAdapter(getActivity(), partidoList);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        return rootView;

    }






    public void getPartido(){
        service.getPartido(map ).enqueue(new Callback<DataPartido>() {
            @Override
            public void onResponse(Call<DataPartido> call, Response<DataPartido> response) {
                getResponse(response.body());
                partidoList.addAll(response.body().getData().getItems());
                adapter.notifyDataSetChanged();
                loading.setVisibility(View.GONE);

                if (partidoList != null && partidoList.size() == 0){
                    empty_data.setVisibility(View.VISIBLE);
                }
            }




            @Override
            public void onFailure(Call<DataPartido> call, Throwable t) {
                Log.e("Conexion", "NO");
                loading.setVisibility(View.GONE);
                empty_data.setVisibility(View.VISIBLE);
                text_data.setVisibility(View.VISIBLE);

            }
        });


    }


    public static void getResponse(Object response){

        ObjectMapper objectM = new ObjectMapper();
        try {
            Log.e("RESPONSEDATE", objectM.writeValueAsString(response));
        }catch (Exception e){

        }
    }


     private BroadcastReceiver getPartidos = new BroadcastReceiver() {
         @Override
         public void onReceive(Context context, Intent intent) {
             prefs = new Preferences(PartidoAplication.getContext());
             map.put("Authorization", "Bearer "+ prefs.getToken() );
             getPartido();

         }
     };


    @Override
    public void onStart() {
        super.onStart();
        Broadcast.onRegister(getPartidos,"GET_ARTIST");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Broadcast.unRegister(getPartidos);
    }
}


