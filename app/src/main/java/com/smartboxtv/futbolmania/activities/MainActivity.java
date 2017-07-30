package com.smartboxtv.futbolmania.activities;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.smartboxtv.futbolmania.Broadcast;
import com.smartboxtv.futbolmania.PartidoAplication;
import com.smartboxtv.futbolmania.R;
import com.smartboxtv.futbolmania.Utils.Preferences;
import com.smartboxtv.futbolmania.fragments.PartidosFragment;
import com.smartboxtv.futbolmania.interfaces.PartidoFactory;
import com.smartboxtv.futbolmania.models.Authenticate.AppModel;
import com.smartboxtv.futbolmania.models.Authenticate.DeviceModel;
import com.smartboxtv.futbolmania.models.Authenticate.LoginModel;
import com.smartboxtv.futbolmania.models.Authenticate.UserModel;
import com.smartboxtv.futbolmania.models.Login;
import org.codehaus.jackson.map.ObjectMapper;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity  {
    //Servicio
    static PartidoFactory.PartidoInterfaces service =  PartidoFactory.getClient();
    HashMap<String, String> map = new HashMap<>();
    Preferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map.put("Content-Type", "application/json");
        map.put("Authorization", "Basic cHJ1ZWJhc2RldjpwcnVlYmFzZGV2U2VjcmV0");
        getAuthenticate();
        prefs = new Preferences(PartidoAplication.getContext());

       PartidosFragment fragment = new PartidosFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();

    }



    public void getAuthenticate()  {
        final HashMap  <String, String> profile = new HashMap<>();
        profile.put("language", "es");
        UserModel usermodel = new UserModel(profile);
        DeviceModel deviceModel = new DeviceModel("1234567", "MyPhone", "6.0", "640", "960", "Lg", "android");
        AppModel appModel   = new AppModel("1.0.0");
        LoginModel loginmodel = new LoginModel(usermodel, deviceModel, appModel);

        service.getAuthenticate(map,loginmodel).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                getResponse(response.body());
                Log.e("TOKEN", response.body().getData().getAccessToken());
                prefs.setToken(response.body().getData().getAccessToken());
                Broadcast.getPartidos()

                ;

            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {

                Broadcast.getPartidos();

            }
        });


    }


    public static void getResponse(Object response){

        ObjectMapper objectM = new ObjectMapper();
        try {
            Log.e("RESPONSE", objectM.writeValueAsString(response));
        }catch (Exception e){

        }
    }
}
