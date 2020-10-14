package learn.gouzi.base.recyclerview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import learn.gouzi.base.customview.BaseCustomView;
import learn.gouzi.base.customview.BaseCustomViewModel;
import learn.gouzi.base.customview.IBaseCustomView;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    //    第三次修改
//    private View itemView;
    private IBaseCustomView itemView;
//    private BaseCustomView itemView;
//    public BaseViewHolder(@NonNull View itemView) {
    public BaseViewHolder(@NonNull IBaseCustomView itemView) {
//    public BaseViewHolder(@NonNull BaseCustomView itemView) {
//        super(itemView);
        super((View) itemView);
        this.itemView = itemView;
    }

//    第三次修改
    public void bind(BaseCustomViewModel viewModel){
        this.itemView.setData(viewModel);
    }
}
