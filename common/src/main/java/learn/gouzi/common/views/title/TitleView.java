package learn.gouzi.common.views.title;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;


import androidx.databinding.DataBindingUtil;
import learn.gouzi.base.customview.BaseCustomView;
import learn.gouzi.base.customview.IBaseCustomView;
import learn.gouzi.common.R;
import learn.gouzi.common.databinding.TitleViewBinding;

import com.xiangxue.webview.WebviewActivity;



//第三次修改 实现自己定义的基本自定义view
//public class TitleView extends LinearLayout {
//第四次修改
public class TitleView extends LinearLayout implements IBaseCustomView<TitleViewModel> {
//public class TitleView extends BaseCustomView<TitleViewBinding,TitleViewModel> {

    //第四次修改 这里也不需要保存变量了 父类已经有了
    private TitleViewBinding mBinding;
    private TitleViewModel mViewModel;

    public TitleView(Context context) {
        super(context);
        //第四次修改
        init();
    }

    //第四次修改
    private void init() {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.title_view,this,false);
        mBinding.getRoot().setOnClickListener(new OnClickListener() {
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
//        return R.layout.title_view;
//    }

    //第三次修改 本来就有这个方法 所以自动映射到了这里 其实这里加一个override会好一点
    //第四次修改 不需要做了
    @Override
    public void setData(TitleViewModel data){
        mBinding.setViewModel(data);
        mBinding.executePendingBindings();
        this.mViewModel = data;
    }

//    @Override
//    protected void setDataToView(TitleViewModel data) {
//        binding.setViewModel(data);
//    }


    /**
     * 初始化
     * 获取inflater
     * 获取子view的ViewDataBinding
     * 给子view绑定点击事件
     * 添加子view到这个自定义view
     *
     * 定义viewmodel
     * 编写设置数据的方法
     */

}
