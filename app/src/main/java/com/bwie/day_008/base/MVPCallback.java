package com.bwie.day_008.base;

public interface MVPCallback<T> {

    void onsuccess(T data);
    void onError();
    void onCmplte();
}
