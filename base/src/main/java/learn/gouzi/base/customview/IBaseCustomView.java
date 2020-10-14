package learn.gouzi.base.customview;

/**
 * Created by kila on 2020/10/12.
 */
//第三次修改定义一个base的自定义view基类
public interface IBaseCustomView<D extends BaseCustomViewModel> {
    void setData(D data);
}
