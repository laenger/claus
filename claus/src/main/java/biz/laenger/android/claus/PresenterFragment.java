package biz.laenger.android.claus;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

@SuppressLint("ValidFragment")
final class PresenterFragment<V, P extends BasePresenter<V>> extends Fragment {

    private final P presenter;

    public PresenterFragment(P presenter) {
        this.presenter = presenter;
    }

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        presenter.onCreate(savedInstanceState);
    }

    @Override
    @SuppressWarnings("unchecked")
    public final void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final FragmentActivity activity = getActivity();
        presenter.onViewCreated((V) activity);
        ((PresenterActivity<V, P>) activity).onPresenterReady(presenter);
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSavePresenterState(outState);
    }

}
