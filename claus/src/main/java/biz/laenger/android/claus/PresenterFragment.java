package biz.laenger.android.claus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public final class PresenterFragment<V, P extends BasePresenter<V>> extends Fragment {

    private static final String ARG_PRESENTER_CLASS = "presenter_class";

    private P presenter;

    public static <V, P extends BasePresenter<V>> PresenterFragment newInstance(Class<P> presenterClass) {
        final PresenterFragment<V, P> presenterFragment = new PresenterFragment<>();

        final Bundle args = new Bundle();
        args.putSerializable(ARG_PRESENTER_CLASS, presenterClass);
        presenterFragment.setArguments(args);

        return presenterFragment;
    }

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        presenter = instantiatePresenterFromArguments(getArguments());
        presenter.onCreate(savedInstanceState);
    }

    @SuppressWarnings("unchecked")
    private P instantiatePresenterFromArguments(Bundle arguments) {
        final Class<P> presenterClass = (Class<P>) arguments.getSerializable(ARG_PRESENTER_CLASS);
        if (presenterClass == null) {
            throw new IllegalArgumentException("fragment requires argument: " + ARG_PRESENTER_CLASS);
        }
        try {
            return presenterClass.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("presenter requires public no-args constructor: " + presenterClass.getName(), e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public final void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final FragmentActivity activity = getActivity();
        ((PresenterListener<V, P>) activity).onPresenterAvailable(presenter);
        presenter.bindView((V) activity);
        ((PresenterListener<V, P>) activity).onPresenterBound();
    }

    @Override
    public void onDetach() {
        presenter.unbindView();
        super.onDetach();
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
