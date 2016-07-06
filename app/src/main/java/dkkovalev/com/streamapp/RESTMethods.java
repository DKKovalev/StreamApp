package dkkovalev.com.streamapp;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by d.kovalev on 15.06.2016.
 */
public interface RESTMethods {
   /* @GET("/streams/{channel}")
    void twitchGetChannel(@Path("channel") String channel, Callback<ChannelModel> channelModelCallback);

    @GET("/channels/{channel}/access_token")
    void twitchGetToken(@Path("channel") String channel, Callback<TokenModel> tokenModelCallback);*/

    @GET("games/top")
    Observable<TopChannelsModel> twitchGetTop(@Query("limit") int limit);

  /*  @GET("/streams")
    void twitchGetChannelsByGame(@Query("game") String game, Callback<com.moodappinc.streamappa.InnerLayer.Models.Twitch.GamesModel> gamesModelCallback);

    @GET("/channel/hls/{channel}.m3u8")
    void twitchGetStream(@Path("channel") String channel
            , @Query("player") String player
            , @Query("token") String token
            , @Query("sig") String sig
            , @Query("allow_audio_only") String audioOnly
            , @Query("allow_source") String allowSource, @Query("type") String type
            , @Query("p") int randomInt
            , Callback<Response> streamCallback);

    @GET("/media/live/list")
    void hitboxGetGames(Callback<HitboxLiveStreams> gamesModelCallback);*/
}
