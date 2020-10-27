package learn.gouzi.common.views.databinding;

import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * Created by kila on 2020/10/12.
 */
public class CommonBindingAdapters {


    //这个方法一定要静态 public static在任何地方都可以调 在xml不能去new对象
    //第四次修改这个方法是通用的，把它放在common里面
    @BindingAdapter("loadImageUrl")
    public static void loadImageUrl(ImageView imageView, String pictureUrl){
        if(!TextUtils.isEmpty(pictureUrl)){
            Glide.with(imageView.getContext())
                    .load(pictureUrl)
                    .transition(withCrossFade())
                    .into(imageView);
        }
    }
}
