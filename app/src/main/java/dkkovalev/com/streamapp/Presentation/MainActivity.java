package dkkovalev.com.streamapp.Presentation;

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

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> stringArrayList;
    private RecyclerView recyclerView;
    private CustomRecyclerAdapter customRecyclerAdapter;
    private ItemTouchHelper.Callback callback;
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringArrayList = new ArrayList<>();
        stringArrayList.add("Hello");
        stringArrayList.add("World");
        stringArrayList.add("!!");

        customRecyclerAdapter = new CustomRecyclerAdapter(this, stringArrayList);
        callback = new CustomItemTouchHelper(customRecyclerAdapter);
        itemTouchHelper = new ItemTouchHelper(callback);

        recyclerView = (RecyclerView)findViewById(R.id.items_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customRecyclerAdapter);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }
}
