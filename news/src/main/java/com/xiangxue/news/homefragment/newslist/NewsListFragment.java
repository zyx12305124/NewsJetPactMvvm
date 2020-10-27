package com.xiangxue.news.homefragment.newslist;

import androidx.annotation.NonNull;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xiangxue.network.TecentNetworkApi;
import com.xiangxue.network.observer.BaseObserver;
import com.xiangxue.news.R;
import com.xiangxue.news.databinding.FragmentNewsBinding;
import com.xiangxue.news.homefragment.api.NewsApiInterface;
import com.xiangxue.news.homefragment.api.NewsListBean;
import learn.gouzi.base.customview.BaseCustomViewModel;
import learn.gouzi.base.mvvm.model.IBaseModelListner;
import learn.gouzi.base.mvvm.model.PagingResult;
import learn.gouzi.common.views.picturetitleview.PictureTitleViewModel;
import learn.gouzi.common.views.title.TitleViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allen on 2017/7/20.
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
public class NewsListFragment extends Fragment implements IBaseModelListner<List<BaseCustomViewModel>> {
    private NewsListRecyclerViewAdapter mAdapter;
    private FragmentNewsBinding viewDataBinding;
    private NewsListModel newsListModel;

    protected final static String BUNDLE_KEY_PARAM_CHANNEL_ID = "bundle_key_param_channel_id";
    protected final static String BUNDLE_KEY_PARAM_CHANNEL_NAME = "bundle_key_param_channel_name";


    public static NewsListFragment newInstance(String channelId, String channelName) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY_PARAM_CHANNEL_ID, channelId);
        bundle.putString(BUNDLE_KEY_PARAM_CHANNEL_NAME, channelName);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false);
        mAdapter = new NewsListRecyclerViewAdapter();
        viewDataBinding.listview.setHasFixedSize(true);
        viewDataBinding.listview.setLayoutManager(new LinearLayoutManager(getContext()));
        viewDataBinding.listview.setAdapter(mAdapter);
        newsListModel = new NewsListModel(this,
                getArguments().getString(BUNDLE_KEY_PARAM_CHANNEL_ID),
                getArguments().getString(BUNDLE_KEY_PARAM_CHANNEL_NAME));
        newsListModel.refresh();
        viewDataBinding.refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                newsListModel.refresh();
            }
        });
        viewDataBinding.refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                newsListModel.loadNextPage();
            }
        });
        return viewDataBinding.getRoot();
    }
    //第二次修改注释掉
    private List<BaseCustomViewModel> viewModels = new ArrayList<>();

    @Override
    public void onLoadSuccess(List<BaseCustomViewModel> baseCustomViewModels, PagingResult... results) {
        if (results!=null && results.length>0 && results[0].isFirstPage){
            viewModels.clear();
        }
        viewModels.addAll(baseCustomViewModels);
        mAdapter.setData(viewModels);
        viewDataBinding.refreshLayout.finishRefresh();
        viewDataBinding.refreshLayout.finishLoadMore();
    }

    @Override
    public void onLoadFail(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

}
