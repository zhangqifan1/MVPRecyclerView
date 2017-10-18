package com.bawei.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.mvp.Adapters.MyRecycleViewAdapter;
import com.bawei.mvp.GamePresenter.Presenter;
import com.bawei.mvp.JsonBeans.GameBean;
import com.bawei.mvp.View.IGameView;

public class MainActivity extends AppCompatActivity implements IGameView {

    private Presenter presenter;
    private RecyclerView mRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter = new Presenter(this, this);
        presenter.getData(Const.GAME_PATH);

    }

    @Override
    public void setGameBean(GameBean gameBean) {
        MyRecycleViewAdapter adapter = new MyRecycleViewAdapter(gameBean, this);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.setAdapter(adapter);
        System.out.println("00000000000");
    }

    private void initView() {
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
    }
}
