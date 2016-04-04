package biz.laenger.android.claus.example;

import biz.laenger.android.claus.BasePresenter;

public class MainPresenter extends BasePresenter<MainView> {

    private int counter = 0;

    @Override
    public void bindView(MainView view) {
        super.bindView(view);
        updateText();
    }

    public void onButtonClicked() {
        counter++;
        updateText();
    }

    private void updateText() {
        getView().showText(String.format("button clicked %d times", counter));
    }

}
