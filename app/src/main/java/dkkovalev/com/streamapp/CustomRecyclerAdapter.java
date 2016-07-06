package dkkovalev.com.streamapp;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by DKovalev on 14.06.16.
 */
public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> implements CustomItemTouchHelperCallback {

    private ArrayList<TopChannelsModel.Top> twitchTopGamesList;
    private Context context;

    public CustomRecyclerAdapter(Context context, ArrayList<TopChannelsModel.Top> twitchTopGamesList) {
        this.twitchTopGamesList = twitchTopGamesList;
        this.context = context;
    }

    @Override
    public CustomRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, null);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomRecyclerAdapter.ViewHolder holder, int position) {

        TopChannelsModel.Top top = twitchTopGamesList.get(position);
        Picasso.with(context)
                .load(Uri.parse(top.getGame().getBox().getLarge()))
                .fit()
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return twitchTopGamesList.size();
    }

    @Override
    public boolean onItemMove(int from, int to) {
        Collections.swap(twitchTopGamesList, from, to);

        notifyItemMoved(from, to);
        return true;
    }

    @Override
    public void onItemDismiss(int pos) {
        twitchTopGamesList.remove(pos);
        notifyItemRemoved(pos);
    }

    public ArrayList<TopChannelsModel.Top> getTwitchTopGamesList() {
        return twitchTopGamesList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView thumbnail;

        public ViewHolder(View itemView) {
            super(itemView);

            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        }
    }
}
