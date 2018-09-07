package com.bwie.day_008;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bwie.day_008.mvp.AccountContarct;
import com.bwie.day_008.mvp.AccountPresent;

import org.xutils.view.annotation.Event;
import org.xutils.x;

import java.util.logging.XMLFormatter;

public class MainActivity extends AppCompatActivity implements AccountContarct.View {

    /*
    *
    * 声明present
    * */

    private AccountPresent present;
    private Button but_login;
    private Button but_add;
    private EditText edit_name;
    private EditText edit_password;
    private String mMboile;
    private String mPassword;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        x.view().inject(this);
        present = new AccountPresent();
        present.attch(this);
        dialog=new ProgressDialog(this);

    }

    @Event({R.id.but_login,R.id.but_add})
    private void  accountClick(View view){

        readNameAndPassword();
        switch (view.getId()){

            case R.id.but_add:
                present.reg(mMboile, mPassword);
                break;
            case R.id.but_login:
                present.login(mMboile, mPassword);
                break;

        }
    }
    
    /*
    * 
    * 读取用户名和密码
    * 
    * */
    private  void  readNameAndPassword(){

        mMboile = edit_name.getText().toString();
        mPassword = edit_password.getText().toString();

    }
    

    /*
    * 
    * 初始化
    * 
    * */
    private void init() {
        but_login = findViewById(R.id.but_login);
        but_add = findViewById(R.id.but_add);
        edit_name = findViewById(R.id.edit_name);
        edit_password = findViewById(R.id.edit_password);
    }


    @Override
    public void showData(final String data) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,data+"ddd",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(present.isViewAttch()){

            present.detach();
        }
    }

    @Override
    public void showLoading() {

        if(dialog.isShowing()){

            dialog.show();
        }
    }

    @Override
    public void hideLoading() {

        if(dialog.isShowing()){

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    dialog.hide();
                }
            });


        }

    }

    @Override
    public void showError() {

    }
}
