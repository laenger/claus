package biz.laenger.android.claus;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.CallSuper;

public abstract class BasePresenter<V> {

    private V view;

    public void onCreate(Bundle savedInstanceState) {
        // ;
    }

    @CallSuper
    public void bindView(V view) {
        this.view = view;
    }

    public void unbindView() {
        // ;
    }

    public void onSavePresenterState(Bundle outState) {
        // ;
    }

    public void onDestroy() {
        // ;
    }

    protected V getView() {
        return view;
    }

    public Application getApplication() {
        return ((Activity) view).getApplication();
    }

}
