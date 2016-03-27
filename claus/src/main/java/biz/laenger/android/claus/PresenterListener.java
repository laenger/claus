package biz.laenger.android.claus;

public interface PresenterListener<V, P extends BasePresenter<V>> {
    void onPresenterReady(P presenter);
}
