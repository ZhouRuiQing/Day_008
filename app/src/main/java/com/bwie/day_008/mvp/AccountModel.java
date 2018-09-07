package com.bwie.day_008.mvp;

import com.bwie.day_008.base.MVPCallback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AccountModel implements AccountContarct.Model {

    private OkHttpClient client;

    public AccountModel() {

        client=new OkHttpClient.
                Builder().
                build();
    }

    @Override
    public void login(String mobile, String password, final MVPCallback<String> callback) {
        client.newCall(new Request
                .Builder()
                .url("https://www.zhaoapi.cn/user/login")
                .post(new FormBody
                        .Builder()
                        .add("mobile",mobile)
                        .add("passwprd",password)
                        .build())
                .build())
                .enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                callback.onsuccess(response.body().string());
                callback.onCmplte();
            }
        });
    }

    @Override
    public void reg(String mobile, String password, final MVPCallback<String> callback) {
        client.newCall(new Request
                .Builder()
                .url("https://www.zhaoapi.cn/user/reg")
                .post(new FormBody
                        .Builder()
                        .add("mobile",mobile)
                        .add("passwprd",password)
                        .build())
                .build())
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        callback.onError();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        callback.onsuccess(response.body().string());
                        callback.onCmplte();
                    }
                });

    }
}
