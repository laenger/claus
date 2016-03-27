package biz.laenger.android.claus;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class PresenterActivity<V, P extends BasePresenter<V>> extends AppCompatActivity implements PresenterListener<V, P> {

    private static final String TAG_PRESENTER = "PRESENTER";

    private final Class<P> presenterClass;
    private P presenter;

    protected PresenterActivity(Class<P> presenterClass) {
        this.presenterClass = presenterClass;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        final PresenterFragment presenterFragment = (PresenterFragment) fragmentManager.findFragmentByTag(TAG_PRESENTER);

        if (presenterFragment == null) {
            fragmentManager.beginTransaction().add(PresenterFragment.newInstance(presenterClass), TAG_PRESENTER).commit();
        }
    }

    @Override
    public void onPresenterReady(P presenter) {
        this.presenter = presenter;
    }

    public P getPresenter() {
        return presenter;
    }

}
