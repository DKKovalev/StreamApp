package dkkovalev.com.streamapp;

import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by d.kovalev on 15.06.2016.
 */
public class TwitchNetworkHandler extends RetrofitHandler {

    private static final String TAG = "TWITCH_RETROFIT_ERROR";

    private TwitchView twitchView;

    public TwitchNetworkHandler(TwitchView twitchView) {
        this.twitchView = twitchView;
    }

    public ArrayList<TopChannelsModel.Top> getCurrentTopGames() {

        final ArrayList<TopChannelsModel.Top> topList = new ArrayList<>();

        RESTMethods restMethods = setupRest(TWITCH_BASE_KRAKEN_URL).create(RESTMethods.class);
        Observable<TopChannelsModel> call = restMethods.twitchGetTop(30);

        call.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<TopChannelsModel>() {
                    @Override
                    public void call(TopChannelsModel topChannelsModel) {
                        twitchView.showCurrentTopGames(topChannelsModel.getTopList());
                        topList.addAll(topChannelsModel.getTopList());
                    }
                });

        return topList;
    }

    /*public void getChannelsByGame(String game) {
        RESTMethods restMethods = setupRest(TWITCH_BASE_KRAKEN_URL).create(RESTMethods.class);
        restMethods.twitchGetChannelsByGame(game, new Callback<GamesModel>() {
            @Override
            public void success(GamesModel gamesModel, Response response) {
                twitchView.showListOfTopStreams();
            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }*/

   /* public void getToken(final String channel) {
        RESTMethods restMethods = setupRest(TWITCH_STREAM_TOKEN_URL).create(RESTMethods.class);
        restMethods.twitchGetToken(channel, new Callback<TokenModel>() {
            @Override
            public void success(TokenModel tokenModel, Response response) {
                String token = tokenModel.getToken();
                token = token.replace("\\", "");
                //getStream(channel, token, tokenModel.getSig());
                String url = TWITCH_STREAM_URL + "channel/hls/" + channel + ".m3u8?player=twitchweb&&token=" + token + "&sig=" + tokenModel.getSig() + "&allow_audio_only=true&allow_source=true&type=any&p=556852";
                twitchView.showStreamFragment(url);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }*/
}
