package com.bawei.mvp.Model;

import com.bawei.mvp.View.IGameView;

/**
 * Created by 张祺钒
 * on2017/10/18.
 */
public interface IGameModel {
    void getGameBean(IGameView iGameView,String path);
}
