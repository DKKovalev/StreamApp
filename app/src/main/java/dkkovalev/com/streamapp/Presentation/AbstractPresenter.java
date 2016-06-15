package dkkovalev.com.streamapp.Presentation;

import java.lang.ref.WeakReference;

/**
 * Created by d.kovalev on 15.06.2016.
 */
public abstract class AbstractPresenter<ViewType> {
    private WeakReference<ViewType> viewTypeWeakReference;

    public void attachView(ViewType viewType) {
        this.viewTypeWeakReference = new WeakReference<ViewType>(viewType);
    }

    public void detachView() {
        if (viewTypeWeakReference != null) {
            viewTypeWeakReference.clear();
            viewTypeWeakReference = null;
        }
    }

    protected boolean isViewAttached() {
        return viewTypeWeakReference != null && viewTypeWeakReference.get() != null;
    }

    protected ViewType getView() {
        return viewTypeWeakReference == null ? null : viewTypeWeakReference.get();
    }
}
