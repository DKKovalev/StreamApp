package dkkovalev.com.streamapp;

/**
 * Created by DKovalev on 14.06.16.
 */
public interface CustomItemTouchHelperCallback {
    boolean onItemMove(int from, int to);
    void onItemDismiss(int pos);
}
