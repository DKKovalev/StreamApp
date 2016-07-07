package dkkovalev.com.streamapp;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import dkkovalev.com.streamapp.Presentation.Presenter;
import dkkovalev.com.streamapp.Presentation.TwitchTopStreamsFragment;


public class TwitchTopGamesFragment extends Fragment implements TwitchView, CustomRecyclerAdapter.OnRecyclerItemClickListener {

    private static final String TAG = "TwitchTopFragment";
    private static final int ID = 0;

    private ArrayList<TopChannelsModel.Top> tops;

    private RecyclerView twitchTopGamesView;
    private Presenter presenter;
    private ImageView sharedImage;

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

        CustomRecyclerAdapter customRecyclerAdapter = new CustomRecyclerAdapter(getActivity(), topArrayList);
        customRecyclerAdapter.setOnRecyclerItemClickListener(TwitchTopGamesFragment.this);

        twitchTopGamesView.setAdapter(customRecyclerAdapter);
        tops = customRecyclerAdapter.getTwitchTopGamesList();

        ItemTouchHelper.Callback callback = new CustomItemTouchHelper(customRecyclerAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(twitchTopGamesView);
    }

    @Override
    public void openCurrentTopStreamsByGameFragment(CustomRecyclerAdapter.ViewHolder viewHolder, int pos) {
        TwitchTopStreamsFragment twitchTopStreamsFragment = TwitchTopStreamsFragment.newInstance(tops.get(pos));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition transition = TransitionInflater.from(getActivity()).inflateTransition(R.transition.change_image_transform);
            Transition explode = TransitionInflater.from(getActivity()).inflateTransition(android.R.transition.explode);
            this.setSharedElementEnterTransition(transition);
            this.setExitTransition(explode);
            twitchTopStreamsFragment.setSharedElementEnterTransition(transition);
            twitchTopStreamsFragment.setEnterTransition(explode);

            sharedImage = viewHolder.getThumbnail();

            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, twitchTopStreamsFragment, twitchTopStreamsFragment.TAG)
                    .addToBackStack(twitchTopStreamsFragment.TAG)
                    .addSharedElement(sharedImage, "image")
                    .commit();
        }
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

    private void setupUI(View view) {


        twitchTopGamesView = (RecyclerView) view.findViewById(R.id.twitch_recycler_view);

        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            twitchTopGamesView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            twitchTopGamesView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        }
    }

    @Override
    public void onClick(CustomRecyclerAdapter.ViewHolder viewHolder, View view, int pos) {
        presenter.showFragmentOfTopStreams(viewHolder, pos);
    }
}
