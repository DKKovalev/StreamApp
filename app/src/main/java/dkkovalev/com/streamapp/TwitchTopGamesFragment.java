package dkkovalev.com.streamapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import dkkovalev.com.streamapp.Presentation.Presenter;


public class TwitchTopGamesFragment extends Fragment implements TwitchView {

    private static final String TAG = "TwitchTopFragment";
    private static final int ID = 0;

    private ArrayList<TopChannelsModel.Top> tops;

    private RecyclerView twitchTopGamesView;
    private CustomRecyclerAdapter customRecyclerAdapter;
    private Presenter presenter;

    public TwitchTopGamesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_twitch_top_games, container, false);
        setupUI(view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = Presenter.getInstance();
        presenter.attachView(this);

        if (savedInstanceState != null) {
            tops = (ArrayList<TopChannelsModel.Top>) savedInstanceState.getSerializable("tops");

        } else {
            tops = presenter.fetchTopGames();
        }

        presenter.showListOfTopGames(tops);
    }

    @Override
    public void showCurrentTopGames(ArrayList<TopChannelsModel.Top> topArrayList) {
        customRecyclerAdapter = new CustomRecyclerAdapter(getActivity(), topArrayList);

        twitchTopGamesView.setAdapter(customRecyclerAdapter);
        tops = customRecyclerAdapter.getTwitchTopGamesList();

        ItemTouchHelper.Callback callback = new CustomItemTouchHelper(customRecyclerAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(twitchTopGamesView);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("tops", tops);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.detachView();
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);


    }

    private void setupUI(View view) {
        twitchTopGamesView = (RecyclerView) view.findViewById(R.id.twitch_recycler_view);

        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            twitchTopGamesView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            twitchTopGamesView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        }
    }
}
