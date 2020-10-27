package learn.gouzi.base.recyclerview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import learn.gouzi.base.customview.BaseCustomView;
import learn.gouzi.base.customview.BaseCustomViewModel;
import learn.gouzi.base.customview.IBaseCustomView;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private IBaseCustomView itemView;
    public BaseViewHolder(@NonNull IBaseCustomView itemView) {
        super((View) itemView);
        this.itemView = itemView;
    }

    public void bind(BaseCustomViewModel viewModel){
        this.itemView.setData(viewModel);
    }
}
