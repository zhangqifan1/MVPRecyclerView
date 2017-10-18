package com.bawei.mvp.Model;

import com.bawei.mvp.JsonBeans.GameBean;
import com.bawei.mvp.View.IGameView;
import com.bawei.mvp.network.OkhttpUtils;
import com.bawei.mvp.network.ResultCallback;
import com.squareup.okhttp.Request;

/**
 * Created by 张祺钒
 * on2017/10/18.
 */

public class GameModel implements IGameModel {


    @Override
    public void getGameBean(final IGameView iGameView, String path) {
        OkhttpUtils.getAsyn(path, new ResultCallback<GameBean>() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(GameBean response) {
                iGameView.setGameBean(response);
            }
        });
    }
}
