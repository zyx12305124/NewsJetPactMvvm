package com.xiangxue.news.homefragment.headlinenews;

import android.util.Log;

import com.google.gson.Gson;
import com.xiangxue.network.TecentNetworkApi;
import com.xiangxue.network.observer.BaseObserver;
import com.xiangxue.news.homefragment.api.NewsApiInterface;
import com.xiangxue.news.homefragment.api.NewsChannelsBean;

import java.util.ArrayList;
import java.util.List;

import learn.gouzi.base.mvvm.model.IBaseModelListner;

/**
 * 请求不应该放在fragment里面
 */
public class NewsChannelModel {
    IBaseModelListner<List<NewsChannelsBean.ChannelList>> listner;
    public NewsChannelModel(IBaseModelListner<List<NewsChannelsBean.ChannelList>> listner){
        this.listner = listner;
    }
    public void load() {
        TecentNetworkApi.getService(NewsApiInterface.class)
                .getNewsChannels()
                .compose(TecentNetworkApi.getInstance().applySchedulers(new BaseObserver<NewsChannelsBean>() {
                    @Override
                    public void onSuccess(NewsChannelsBean newsChannelsBean) {
                        listner.onLoadSuccess(newsChannelsBean.showapiResBody.channelList);
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        listner.onLoadFail(e.getMessage());
                    }
                }));
    }
}
