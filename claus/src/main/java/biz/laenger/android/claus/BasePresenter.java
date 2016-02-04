package biz.laenger.android.claus;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public abstract class BasePresenter<V> {

    private V view;

    public void onCreate(Bundle savedInstanceState) {
        // ;
    }

    public void onViewCreated(V view) {
        this.view = view;
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
