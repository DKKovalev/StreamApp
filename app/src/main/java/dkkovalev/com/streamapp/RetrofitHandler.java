package dkkovalev.com.streamapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DKovalev on 14.06.16.
 */
public class RetrofitHandler {

    private static final String TWITCH_BASE_KRAKEN_URL = "https://api.twitch.tv/kraken/";
    private static final String TWITCH_STREAM_TOKEN_URL = "http://api.twitch.tv/api/";
    private static final String TWITCH_STREAM_URL = "http://usher.twitch.tv/api";
    private static final String MIME = "application/vnd.twitchtv.v3+json";
    private static final String CLIENT_ID = "4xrv2me643mrppdemy0wamt069yvrgh";

    public Retrofit setupRest(String endpoint) {

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return restAdapter;
    }



}
