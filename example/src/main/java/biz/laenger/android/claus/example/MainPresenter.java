package biz.laenger.android.claus.example;

import biz.laenger.android.claus.ClausPresenterFragment;

public class MainPresenter extends ClausPresenterFragment<MainView> {

    private int counter = 0;

    @Override
    protected void onViewCreated() {
        updateText();
    }

    public void onButtonClicked() {
        counter++;
        updateText();
    }

    private void updateText() {
        view().showText(String.format("button clicked %d times", counter));
    }

}
