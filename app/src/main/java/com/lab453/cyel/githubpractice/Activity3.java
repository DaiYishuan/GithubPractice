package com.lab453.cyel.githubpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

// 2017/05/29 在切換頁面時加入finish()   by 劉濬

//TODO 請亦軒加入手機下翻時，螢幕保護的功能(利用FlippingManager和ScreenSaver)
//TODO 請亦軒將更動寫在前面的註解裡，像是我上面寫的那樣
public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

    public void goToActivity4(View view) {
        Intent intent=new Intent();
        intent.setClass(this,Activity4.class);
        startActivity(intent);
        finish();
    }
}
