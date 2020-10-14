package com.xiangxue.news.homefragment.newslist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import learn.gouzi.base.customview.BaseCustomViewModel;
import learn.gouzi.base.recyclerview.BaseViewHolder;
import learn.gouzi.common.views.picturetitleview.PictureTitleView;
import learn.gouzi.common.views.picturetitleview.PictureTitleViewModel;
import learn.gouzi.common.views.title.TitleView;

import java.util.List;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;


/**
 * Created by Allen on 2017/7/20.
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
//第三次修改
//public class NewsListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
public class NewsListRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private final int VIEW_TYPE_PICTURE_TITLE = 1;
    private final int VIEW_TYPE_TITLE = 2;
    //第二次修改注释掉 并且修改
//    private List<NewsListBean.Contentlist> mItems;
    private List<BaseCustomViewModel> mItems;

    private Context mContext;

    NewsListRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    //第二次修改注释掉 并且修改
//    void setData(List<NewsListBean.Contentlist> items) {
//        mItems = items;
//        notifyDataSetChanged();
//    }
    void setData(List<BaseCustomViewModel> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mItems != null) {
            return mItems.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        //第二次修改注释掉 并且修改
        if (mItems != null && mItems.get(position) instanceof PictureTitleViewModel) {
//        if (mItems != null && mItems.get(position).imageurls != null && mItems.get(position).imageurls.size() > 1) {
            return VIEW_TYPE_PICTURE_TITLE;
        }
        return VIEW_TYPE_TITLE;
    }

    @Override
//第三次修改
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_PICTURE_TITLE) {
            //第一次修改
//            view = LayoutInflater.from(mContext).inflate(R.layout.picture_title_view, parent, false);
//            return new PictureTitleViewHolder(view);
            return new BaseViewHolder(new PictureTitleView(parent.getContext()));
        } else if (viewType == VIEW_TYPE_TITLE) {

            //第一次修改
//            view = LayoutInflater.from(mContext).inflate(R.layout.title_view, parent, false);
//            return new TitleViewHolder(view);
            return new BaseViewHolder(new TitleView(parent.getContext()));
        }

        return null;
    }


    //第一次修改
//    private class PictureTitleViewHolder extends RecyclerView.ViewHolder {
//        public TextView titleTextView;
//        public AppCompatImageView picutureImageView;
//
//        public PictureTitleViewHolder(@NonNull View itemView) {
//            super(itemView);
//            titleTextView = itemView.findViewById(R.id.item_title);
//            picutureImageView = itemView.findViewById(R.id.item_image);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    WebviewActivity.startCommonWeb(mContext, "News", v.getTag()+"");
//                }
//            });
//        }
//    }


    //第一次修改
//    private class TitleViewHolder extends RecyclerView.ViewHolder {
//        public TextView titleTextView;
//
//        public TitleViewHolder(@NonNull View itemView) {
//            super(itemView);
//            titleTextView = itemView.findViewById(R.id.item_title);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    WebviewActivity.startCommonWeb(mContext, "News", v.getTag()+"");
//                }
//            });
//        }
//    }
    @Override
    //第三次修改 这里每次都要类型转换很麻烦
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {

        //第三次修改新增代码 这句牛逼 绑定数据到view上永远都不用变
        holder.bind(mItems.get(position));

        //第二次修改注释掉
//        holder.itemView.setTag(mItems.get(position).link);
//        if(holder.itemView instanceof PictureTitleView){ //第三次修改直接把第二次修改的代码都注释了
            //第二次修改 数据不应该在适配器这里像第一次那样转化，应该在请求的成功的时候就进行转化。 与数据相关的操作都需要在model里面做（第三次）
            //所以下面的都不需要了
//            PictureTitleViewModel viewModel = new PictureTitleViewModel();
//            viewModel.jumpUrl = mItems.get(position).link;
//            viewModel.title =  mItems.get(position).title;
//            viewModel.pictureUrl =  mItems.get(position).imageurls.get(0).url;
            //第三次修改 这里每次都要类型转换很麻烦
            //第二次修改 直接用
//            ((PictureTitleView)holder.itemView).setData((PictureTitleView)mItems.get(position));
//            ((PictureTitleView)holder.itemView).setData((PictureTitleViewModel) mItems.get(position));//第三次修改直接把第二次修改的代码都注释了
            //第一次修改
//            ((PictureTitleViewHolder) holder).titleTextView.setText(mItems.get(position).title);
//            Glide.with(holder.itemView.getContext())
//                    .load(mItems.get(position).imageurls.get(0).url)
//                    .transition(withCrossFade())
//                    .into(((PictureTitleViewHolder) holder).picutureImageView);
//        } else if (holder.itemView instanceof TitleView){//第三次修改直接把第二次修改的代码都注释了
//            TitleViewModel viewModel = new TitleViewModel();
//            viewModel.jumpUrl = mItems.get(position).link;
//            viewModel.title =  mItems.get(position).title;
//            ((TitleView)holder.itemView).setData(viewModel);
            //第二次修改 直接用
//            ((TitleView)holder.itemView).setData((TitleViewModel) mItems.get(position));//第三次修改直接把第二次修改的代码都注释了
            //第三次修改 这里每次都要类型转换很麻烦
//        }

        //第一次修改
//        else if(holder instanceof TitleViewHolder) {
//            ((TitleViewHolder) holder).titleTextView.setText(mItems.get(position).title);
//        }
    }
}
