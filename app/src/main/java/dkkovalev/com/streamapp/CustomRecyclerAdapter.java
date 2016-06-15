package dkkovalev.com.streamapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by DKovalev on 14.06.16.
 */
public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> implements CustomItemTouchHelperCallback {

    private ArrayList<String> testList;
    private Context context;

    public CustomRecyclerAdapter(Context context, ArrayList<String> testList) {
        this.testList = testList;
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

        holder.test.setText(testList.get(position));

    }

    @Override
    public int getItemCount() {
        return testList.size();
    }

    @Override
    public boolean onItemMove(int from, int to) {
        Collections.swap(testList, from, to);

        notifyItemMoved(from, to);
        return true;
    }

    @Override
    public void onItemDismiss(int pos) {
        testList.remove(pos);
        notifyItemRemoved(pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private Context context;
        private ImageView thumbnail;
        private TextView test;

        public ViewHolder(View itemView) {
            super(itemView);

            //thumbnail = (ImageView)itemView.findViewById(R.id.thumbnail);
            test = (TextView) itemView.findViewById(R.id.test);
        }
    }
}
