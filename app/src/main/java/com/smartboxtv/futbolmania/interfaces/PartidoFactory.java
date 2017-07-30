package com.smartboxtv.futbolmania.interfaces;

import com.smartboxtv.futbolmania.models.Authenticate.LoginModel;
import com.smartboxtv.futbolmania.models.Game.DataPartido;
import com.smartboxtv.futbolmania.models.Login;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;



public class PartidoFactory {
    private static PartidoInterfaces futbolApiInterface;

    Map<String, String> map = new HashMap<>();

    public static PartidoInterfaces getClient() {
        if (futbolApiInterface == null) {
            OkHttpClient okClient = new OkHttpClient.Builder()

                    .addInterceptor(
                            new Interceptor() {
                                @Override
                                public Response intercept(Chain chain) throws IOException {
                                    Request original = chain.request();
                                    // Request customization: add request headers
                                    Request.Builder requestBuilder = original.newBuilder()
                                            //   .header("Authorization", token)
                                            .method(original.method(), original.body());
                                    Request request = requestBuilder.build();

                                    long t1 = System.nanoTime();
                                    System.out.println(
                                            String.format("Sending request %s on %s%n%s", request.url(), chain.connection(),
                                                    request.headers()));

                                    return chain.proceed(request);
                                }
                            })
                    .connectTimeout(90, TimeUnit.SECONDS)
                    .readTimeout(90, TimeUnit.SECONDS)
                    .writeTimeout(90, TimeUnit.SECONDS)

                    .build();
            //Url
            Retrofit client = new Retrofit.Builder().baseUrl("http://fxservicesstaging.nunchee.com/api/1.0/")
                    .client(okClient)


                    .addConverterFactory(GsonConverterFactory.create())

                    .build();

            futbolApiInterface = client.create(PartidoInterfaces.class);



        }
        return futbolApiInterface;
    }


    static class LoggingInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            long t1 = System.nanoTime();
            System.out.println(
                    String.format("Sending request %s on %s%n%s", request.url(), chain.connection(),
                            request.headers()));

            Response response = chain.proceed(request);

            long t2 = System.nanoTime();
            System.out.println(
                    String.format("Received response for %s in %.1fms%n%s", response.request().url(),
                            (t2 - t1) / 1e6d, response.headers()));

            return response;
        }
    }


    public interface PartidoInterfaces {

        @POST("auth/users/login/anonymous") //Autenticate
        Call<Login> getAuthenticate(
                @HeaderMap HashMap<String,String> headers,
                @Body LoginModel body
        );

        @GET("sport/events") //Partido
        Call<DataPartido> getPartido(
                @HeaderMap HashMap<String,String> headers


        );


    }


}
