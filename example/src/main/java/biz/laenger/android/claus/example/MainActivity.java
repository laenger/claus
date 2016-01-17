package biz.laenger.android.claus.example;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import biz.laenger.android.claus.ClausViewActivity;

public class MainActivity extends ClausViewActivity<MainPresenter> implements MainView, View.OnClickListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    protected MainPresenter instantiatePresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onPresenterReady(MainPresenter presenter) {
        super.onPresenterReady(presenter);
        // ...
    }

    @Override
    public void showText(String text) {
        textView.setText(text);
    }

    @Override
    public void onClick(View v) {
        getPresenter().onButtonClicked();
    }

}
