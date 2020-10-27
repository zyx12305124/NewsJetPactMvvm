package learn.gouzi.base.customview;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * Created by kila on 2020/10/12.
 * 这里是工厂方法（创建型）模板（行为型,某些步骤不清楚，所以留给派生类去实现)
 */

public abstract class BaseCustomView<VIEW extends ViewDataBinding,DATA extends BaseCustomViewModel>
        extends LinearLayout implements IBaseCustomView<DATA>{
    protected VIEW binding;
    protected DATA data;
    public BaseCustomView(Context context) {
        super(context);
        init();
    }

    public BaseCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BaseCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public BaseCustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    /**
     * 初始化view 把databinding拿进来
     */
    public void init(){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = DataBindingUtil.inflate(inflater,getLayoutId(),this,false);
        binding.getRoot().setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onRootClicked(v);
            }
        });
        addView(binding.getRoot());

    }

    public abstract void onRootClicked(View view);

    public abstract int getLayoutId();

    @Override
    public void setData(DATA data){
        setDataToView(data);
        binding.executePendingBindings();
        this.data = data;
    }

    protected abstract void setDataToView(DATA data);
}
