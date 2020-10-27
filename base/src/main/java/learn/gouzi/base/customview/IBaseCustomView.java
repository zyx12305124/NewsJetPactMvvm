package learn.gouzi.base.customview;

/**
 * Created by kila on 2020/10/12.
 */
public interface IBaseCustomView<D extends BaseCustomViewModel> {
    void setData(D data);
}
