package dkkovalev.com.streamapp.Presentation;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import dkkovalev.com.streamapp.R;
import dkkovalev.com.streamapp.TopChannelsModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwitchTopStreamsFragment extends Fragment {

    public static final String TAG = TwitchTopStreamsFragment.class.getSimpleName();

    public static TwitchTopStreamsFragment newInstance(TopChannelsModel.Top top) {
        TwitchTopStreamsFragment twitchTopStreamsFragment = new TwitchTopStreamsFragment();
        Bundle args = new Bundle();
        args.putString("picture", top.getGame().getBox().getLarge());
        twitchTopStreamsFragment.setArguments(args);
        return twitchTopStreamsFragment;
    }


    public TwitchTopStreamsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_twitch_top_streams, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageView = (ImageView) view.findViewById(R.id.gg);
        Bundle args = getArguments();
        Picasso.with(getActivity()).load(Uri.parse(args.getString("picture"))).into(imageView);
    }
}
