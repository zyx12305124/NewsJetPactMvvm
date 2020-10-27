package com.xiangxue.news.homefragment.newslist;

import android.util.Log;

import com.google.gson.Gson;
import com.xiangxue.network.TecentNetworkApi;
import com.xiangxue.network.observer.BaseObserver;
import com.xiangxue.news.homefragment.api.NewsApiInterface;
import com.xiangxue.news.homefragment.api.NewsChannelsBean;
import com.xiangxue.news.homefragment.api.NewsListBean;

import java.util.ArrayList;
import java.util.List;

import learn.gouzi.base.customview.BaseCustomView;
import learn.gouzi.base.customview.BaseCustomViewModel;
import learn.gouzi.base.mvvm.model.IBaseModelListner;
import learn.gouzi.base.mvvm.model.PagingResult;
import learn.gouzi.common.views.picturetitleview.PictureTitleViewModel;
import learn.gouzi.common.views.title.TitleViewModel;

public class NewsListModel {
    private String channelId,channelName;
    IBaseModelListner<List<BaseCustomViewModel>> listner;
    private int mPage = 1;
    public NewsListModel(IBaseModelListner   listner,String channelId,String channelName){
        this.listner = listner;
        this.channelId = channelId;
        this.channelName = channelName;
    }

    public void refresh(){
        mPage = 1;
        loadNextPage();
    }

    public void loadNextPage() {
        TecentNetworkApi.getService(NewsApiInterface.class)
                .getNewsList(channelId,
                        channelName, String.valueOf(mPage))
                .compose(TecentNetworkApi.getInstance().applySchedulers(new BaseObserver<NewsListBean>() {
                    @Override
                    public void onSuccess(NewsListBean newsChannelsBean) {
                        List<BaseCustomViewModel> viewModels = new ArrayList<>();
                        for (NewsListBean.Contentlist contentlist:newsChannelsBean.showapiResBody.pagebean.contentlist){
                            if (contentlist.imageurls!=null && contentlist.imageurls.size()>0){
                                PictureTitleViewModel pictureTitleViewModel = new PictureTitleViewModel();
                                pictureTitleViewModel.pictureUrl = contentlist.imageurls.get(0).url;
                                pictureTitleViewModel.jumpUrl = contentlist.link;
                                pictureTitleViewModel.title = contentlist.title;
                                viewModels.add(pictureTitleViewModel);
                            } else {
                                TitleViewModel titleViewModel = new TitleViewModel();
                                titleViewModel.jumpUrl = contentlist.link;
                                titleViewModel.title = contentlist.title;
                                viewModels.add(titleViewModel);
                            }
                        }
                        listner.onLoadSuccess(viewModels,new PagingResult(
                                mPage==1,
                                viewModels.isEmpty(),
                                viewModels.size()>=10));
                        mPage ++;
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        e.printStackTrace();
                    }
                }));
    }
}
