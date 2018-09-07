package com.bwie.day_008.mvp;


/*
* 账户的契约
*
* */

import com.bwie.day_008.base.IBaseModel;
import com.bwie.day_008.base.IBasePresenter;
import com.bwie.day_008.base.IBaseView;
import com.bwie.day_008.base.MVPCallback;

public interface AccountContarct {

     /*
     * 账户的view
     *
     * */
     interface View extends IBaseView<String>{

         /**
         * 显示进度条
         */
        void showLoading();

         /**
          * 隐藏进度条
          */
         void hideLoading();

         /**
          * 显示错误信息
          */
         void showError();
     }

     /*
     *
     * Model层
     * */
     interface Model extends IBaseModel{

         void login(String mobile,String password,MVPCallback<String> callback);
         void reg(String mobile,String password,MVPCallback<String> callback);
     }
   /*
   * Presenter模板
   *
   * */
     abstract class Present extends IBasePresenter<View>{

         abstract void login(String mobile,String password);
         abstract void reg(String mobile,String password);
     }


}
