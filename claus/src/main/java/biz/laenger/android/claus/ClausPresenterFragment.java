package biz.laenger.android.claus;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public abstract class ClausPresenterFragment<V> extends Fragment {

    private V view;

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public final void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        view = (V) getActivity();
        ((ClausViewActivity) view).onPresenterReady(this);
        onViewCreated();
    }

    protected V view() {
        return view;
    }

    protected abstract void onViewCreated();

}
