package learn.gouzi.common.views.picturetitleview;

import android.content.Context;
import android.view.View;

import com.xiangxue.webview.WebviewActivity;


import learn.gouzi.base.customview.BaseCustomView;
import learn.gouzi.common.R;
import learn.gouzi.common.databinding.PictureTitleViewBinding;



//第三次修改 实现自己定义的基本自定义view
//public class PictureTitleView extends LinearLayout {
//第四次修改
//public class PictureTitleView extends LinearLayout implements IBaseCustomView<PictureTitleViewModel> {
public class PictureTitleView extends BaseCustomView<PictureTitleViewBinding,PictureTitleViewModel> {
    public PictureTitleView(Context context) {
        super(context);
        init();
    }

    @Override
    public void onRootClicked(View view) {
        WebviewActivity.startCommonWeb(getContext(),"News",data.jumpUrl);
    }

    @Override
    public int getLayoutId() {
        return  R.layout.picture_title_view;
    }


    @Override
    protected void setDataToView(PictureTitleViewModel pictureTitleViewModel) {
        binding.setViewModel(data);
    }


}
