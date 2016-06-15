package dkkovalev.com.streamapp;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DKovalev on 14.06.16.
 */
public abstract class RetrofitHandler {

    protected static final String TWITCH_BASE_KRAKEN_URL = "https://api.twitch.tv/kraken/";
    protected static final String TWITCH_STREAM_TOKEN_URL = "http://api.twitch.tv/api/";
    protected static final String TWITCH_STREAM_URL = "http://usher.twitch.tv/api";
    protected static final String MIME = "application/vnd.twitchtv.v3+json";
    protected static final String CLIENT_ID = "4xrv2me643mrppdemy0wamt069yvrgh";

    protected Retrofit setupRest(String endpoint) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(endpoint)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return restAdapter;
    }
}
