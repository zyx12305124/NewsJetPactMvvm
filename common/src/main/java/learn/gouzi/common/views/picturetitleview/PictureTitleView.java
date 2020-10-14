package learn.gouzi.common.views.picturetitleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.xiangxue.webview.WebviewActivity;


import androidx.databinding.DataBindingUtil;
import learn.gouzi.base.customview.BaseCustomView;
import learn.gouzi.base.customview.IBaseCustomView;
import learn.gouzi.common.R;
import learn.gouzi.common.databinding.PictureTitleViewBinding;



//第三次修改 实现自己定义的基本自定义view
//public class PictureTitleView extends LinearLayout {
//第四次修改
public class PictureTitleView extends LinearLayout implements IBaseCustomView<PictureTitleViewModel> {
//public class PictureTitleView extends BaseCustomView<PictureTitleViewBinding,PictureTitleViewModel> {
    //第四次修改 不需要定义变量保存了 父类已经帮我们做过了
    private PictureTitleViewBinding mBinding;
    private PictureTitleViewModel mViewModel;
    public PictureTitleView(Context context) {
        super(context);
        init();
    }

    //第四次修改
    private void init() {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.picture_title_view,this,false);
        mBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebviewActivity.startCommonWeb(getContext(),"News",mViewModel.jumpUrl);
            }
        });
        addView(mBinding.getRoot());
    }

//    @Override
//    public void onRootClicked(View view) {
//        WebviewActivity.startCommonWeb(getContext(),"News",data.jumpUrl);
//    }
//
//    @Override
//    public int getLayoutId() {
//        return R.layout.picture_title_view;
//    }


    //第三次修改 本来就有这个方法 所以自动映射到了这里 其实这里加一个override会好一点
    //第四次修改，不需要做了，父类已经做了
    @Override
    public void setData(PictureTitleViewModel data){
        mBinding.setViewModel(data);
        mBinding.executePendingBindings();
        this.mViewModel = data;
    }

//    @Override
//    protected void setDataToView(PictureTitleViewModel pictureTitleViewModel) {
//        binding.setViewModel(data);
//    }

    //这个方法一定要静态 public static在任何地方都可以调 在xml不能去new对象
    //第四次修改这个方法是通用的，把它放在common里面
//    @BindingAdapter("loadImageUrl")
//    public static void loadImageUrl(ImageView imageView, String pictureUrl){
//        if(!TextUtils.isEmpty(pictureUrl)){
//            Glide.with(imageView.getContext())
//                    .load(pictureUrl)
//                    .transition(withCrossFade())
//                    .into(imageView);
//        }
//    }
}
