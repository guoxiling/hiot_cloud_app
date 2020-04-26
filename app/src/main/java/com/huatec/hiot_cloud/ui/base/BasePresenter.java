package com.huatec.hiot_cloud.ui.base;


/**
 * MVP架构presenter基类
 */
//定义泛型类型V,继承自BaseView，它的泛型上限必须是BaseView的子类
public class BasePresenter<V extends BaseView> {
    private V view;
    public BasePresenter() {
    }
    public void setView(V view){
        this.view = view;
    }
    public V getView(){
        return view;
    }

    public void destroy(){
        if (viewAttached()){
            view = null;
        }
    }
    public boolean viewAttached(){
        return view != null;
    }
}
