package com.smartboxtv.futbolmania.interfaces;

import android.util.Log;
import org.codehaus.jackson.map.ObjectMapper;




public class CallsRetrofit {

    static PartidoFactory.PartidoInterfaces service =  PartidoFactory.getClient();

    public static void getResponse(Object response){
        ObjectMapper objectM = new ObjectMapper();
        try {
            Log.e("RESPONSE", objectM.writeValueAsString(response));
        }catch (Exception e){

        }
    }
}
