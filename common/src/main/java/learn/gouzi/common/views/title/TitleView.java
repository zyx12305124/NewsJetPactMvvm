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
//public class TitleView extends LinearLayout implements IBaseCustomView<TitleViewModel> {
public class TitleView extends BaseCustomView<TitleViewBinding,TitleViewModel> {
    public TitleView(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.title_view;
    }

    @Override
    public void onRootClicked(View view) {
        WebviewActivity.startCommonWeb(getContext(),"News",data.jumpUrl);
    }

    @Override
    protected void setDataToView(TitleViewModel titleViewModel) {
        binding.setViewModel(data);
    }

}
