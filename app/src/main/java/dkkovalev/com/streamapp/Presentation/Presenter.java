package dkkovalev.com.streamapp.Presentation;

import java.util.ArrayList;

import dkkovalev.com.streamapp.CustomRecyclerAdapter;
import dkkovalev.com.streamapp.TopChannelsModel;
import dkkovalev.com.streamapp.TwitchNetworkHandler;
import dkkovalev.com.streamapp.TwitchView;

/**
 * Created by DKovalev on 14.06.16.
 */
public class Presenter extends AbstractPresenter<TwitchView> {

    public static Presenter getInstance() {
        Presenter instance = new Presenter();
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
        if (isViewAttached()) {
            TwitchView twitchView = getView();
            if (twitchView != null) {
                return new TwitchNetworkHandler(twitchView).getCurrentTopGames();
            }
        }
        return null;
    }

    public void showFragmentOfTopStreams(CustomRecyclerAdapter.ViewHolder viewHolder, int pos) {
        if (isViewAttached()) {
            TwitchView twitchView = getView();
            if (twitchView != null) {
                twitchView.openCurrentTopStreamsByGameFragment(viewHolder, pos);
            }
        }
    }
}
