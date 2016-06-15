package dkkovalev.com.streamapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import dkkovalev.com.streamapp.Presentation.Presenter;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class AbstractFragment extends Fragment implements TwitchView {

    private Presenter presenter;

    public AbstractFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(presenter == null){
            presenter = new Presenter();
            presenter.attachView(this);
        }
    }



    @Override
    public void onResume() {
        super.onResume();
        //presenter.attachView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detachView();
    }
}
