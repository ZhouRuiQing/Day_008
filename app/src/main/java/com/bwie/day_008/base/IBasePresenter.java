package com.bwie.day_008.base;

import java.lang.ref.WeakReference;

public abstract class IBasePresenter<V extends IBaseView> {

    //弱引用
    private WeakReference<V> view;

    /*
    *
    * 和view绑定
    *
    * */
  public void  attch(V v){

      view =new WeakReference(v);

  }

  /*
  * 解绑
  *
  * */
  public void  detach(){

      if(view!=null){
          view.clear();
          view=null;
      }
  }

  //从弱引用中拿出view
  protected  V getView(){

      return view.get();
  }

  //判断view 是否绑定
  public boolean isViewAttch(){

      return view!=null && view.get()!=null;

  }

}
