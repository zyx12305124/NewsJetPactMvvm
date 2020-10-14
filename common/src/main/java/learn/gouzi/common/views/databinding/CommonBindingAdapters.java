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
