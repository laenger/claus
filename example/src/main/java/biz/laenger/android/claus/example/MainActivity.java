package biz.laenger.android.claus.example;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import biz.laenger.android.claus.PresenterActivity;

public class MainActivity extends PresenterActivity<MainView, MainPresenter> implements MainView, View.OnClickListener {

    private TextView textView;

    public MainActivity() {
        super(MainPresenter.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        findViewById(R.id.button).setOnClickListener(this);
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
