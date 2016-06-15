package dkkovalev.com.streamapp.Presentation;

import dkkovalev.com.streamapp.TwitchNetworkHandler;
import dkkovalev.com.streamapp.TwitchView;

/**
 * Created by DKovalev on 14.06.16.
 */
public class Presenter extends AbstractPresenter<TwitchView> {

    private TwitchNetworkHandler twitchNetworkHandler;

    public void showListOfTopGames() {

        if (isViewAttached()) {
            TwitchView twitchView = getView();
            if (twitchView != null) {
                twitchNetworkHandler = new TwitchNetworkHandler(twitchView);
                twitchView.showCurrentTopGames(twitchNetworkHandler.getCurrentTopGames());
            }
        }
    }
}
