package dkkovalev.com.streamapp.Presentation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import dkkovalev.com.streamapp.R;
import dkkovalev.com.streamapp.TwitchTopGamesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();

        Fragment twitchTopGamesFragment = fragmentManager.findFragmentById(R.id.fragment_container);
        if (twitchTopGamesFragment == null) {
            twitchTopGamesFragment = new TwitchTopGamesFragment();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, twitchTopGamesFragment, twitchTopGamesFragment.getClass().getSimpleName()).commit();
        }
    }
}
