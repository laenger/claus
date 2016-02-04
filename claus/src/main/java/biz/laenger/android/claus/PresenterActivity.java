package biz.laenger.android.claus;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class PresenterActivity<V, P extends BasePresenter<V>> extends AppCompatActivity {

    private static final String TAG_PRESENTER = "PRESENTER";

    private P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        final PresenterFragment presenterFragment = (PresenterFragment) fragmentManager.findFragmentByTag(TAG_PRESENTER);

        if (presenterFragment == null) {
            final P presenter = instantiatePresenter();
            fragmentManager.beginTransaction().add(new PresenterFragment<V, P>(presenter), TAG_PRESENTER).commit();
        }
    }

    protected abstract P instantiatePresenter();

    protected void onPresenterReady(P presenter) {
        this.presenter = presenter;
    }

    public P getPresenter() {
        return presenter;
    }

}
