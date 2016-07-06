package dkkovalev.com.streamapp.Presentation;

import java.util.ArrayList;

import dkkovalev.com.streamapp.TopChannelsModel;
import dkkovalev.com.streamapp.TwitchNetworkHandler;
import dkkovalev.com.streamapp.TwitchView;

/**
 * Created by DKovalev on 14.06.16.
 */
public class Presenter extends AbstractPresenter<TwitchView> {

    private static Presenter instance = new Presenter();

    public static Presenter getInstance() {
        return instance;
    }

    public void showListOfTopGames(ArrayList<TopChannelsModel.Top> topArrayList) {

        if (isViewAttached()) {
            TwitchView twitchView = getView();
            if (twitchView != null) {
                twitchView.showCurrentTopGames(topArrayList);
            }
        }
    }

    public ArrayList<TopChannelsModel.Top> fetchTopGames() {
        TwitchNetworkHandler twitchNetworkHandler;
        if (isViewAttached()) {
            TwitchView twitchView = getView();
            if (twitchView != null) {
                twitchNetworkHandler = new TwitchNetworkHandler(twitchView);
                return twitchNetworkHandler.getCurrentTopGames();
            }
        }
        return null;
    }
}
