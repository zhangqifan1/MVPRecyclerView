package com.bawei.mvp.GamePresenter;

import android.content.Context;

import com.bawei.mvp.Model.GameModel;
import com.bawei.mvp.Model.IGameModel;
import com.bawei.mvp.View.IGameView;

/**
 * Created by 张祺钒
 * on2017/10/18.
 */

public class Presenter {
    private IGameModel gameModel;
    private IGameView gameView;
    private Context context;

    public Presenter(IGameView gameView, Context context) {
        this.gameView = gameView;
        this.context = context;
        gameModel=new GameModel();
    }

    public void getData(String path){
        gameModel.getGameBean(gameView,path);
    }
}
