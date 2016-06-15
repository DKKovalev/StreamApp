package dkkovalev.com.streamapp.Presentation;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

import dkkovalev.com.streamapp.CustomItemTouchHelper;
import dkkovalev.com.streamapp.CustomRecyclerAdapter;
import dkkovalev.com.streamapp.R;
import dkkovalev.com.streamapp.TwitchTopGamesFragment;

public class MainActivity extends AppCompatActivity {

    private TwitchTopGamesFragment twitchTopGamesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        twitchTopGamesFragment = new TwitchTopGamesFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, twitchTopGamesFragment, twitchTopGamesFragment.getClass().getSimpleName()).commit();
    }
}
