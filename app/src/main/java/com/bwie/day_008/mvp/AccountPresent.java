package com.bwie.day_008.mvp;

import com.bwie.day_008.base.MVPCallback;

public class AccountPresent extends AccountContarct.Present {

    private AccountModel model;

    public AccountPresent(AccountModel model) {
        this.model = model;
    }

    public AccountPresent() {
        model = new AccountModel();
    }

    @Override
    public void login(String mobile, String password) {

        getView().showLoading();
        model.login(mobile, password, new MVPCallback<String>() {
            @Override
            public void onsuccess(String data) {
                getView().showData(data);
            }

            @Override
            public void onError() {

            }

            @Override
            public void onCmplte() {

                getView().hideLoading();

            }
        });
    }

    @Override
    public void reg(String mobile, String password) {

        if (isViewAttch()) {
            getView().showLoading();
        }

        model.reg(mobile, password, new MVPCallback<String>() {
            @Override
            public void onsuccess(String data) {

                getView().showData(data);
            }

            @Override
            public void onError() {

            }

            @Override
            public void onCmplte() {

                getView().hideLoading();

            }
        });

    }
}
