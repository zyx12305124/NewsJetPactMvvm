package learn.gouzi.base.mvvm.model;

public interface IBaseModelListner<DATA> {
    void onLoadSuccess(DATA data,PagingResult ... results);
    void onLoadFail(String message);
}
