package com.lab453.cyel.githubpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lab453.cyel.githubpractice.sensors.FlippingManager;
import com.lab453.cyel.githubpractice.tools.ScreenSaver;

// 2017/05/29 在切換頁面時加入finish()   by 劉濬

//TODO 請亦軒加入手機下翻時，螢幕保護的功能(利用FlippingManager和ScreenSaver)
//TODO 請亦軒將更動寫在前面的註解裡，像是我上面寫的那樣
public class Activity3 extends AppCompatActivity {

    private FlippingManager flippingManager;
    private ScreenSaver screenSaver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (flippingManager == null) {
            flippingManager = new FlippingManager(this);
        }
        if (screenSaver == null) {
            screenSaver = new ScreenSaver(this);
        }
        //開始手機翻轉偵測
        flippingManager.start(new FlippingManager.OnScreenFlipListener() {
            @Override
            public void onScreenFlipped(int facingDirection) {
                //手機下翻時
                if (facingDirection == DIRECTION_DOWN) {
                    //開啟螢幕保護
                    screenSaver.startScreenSaving();
                }
                //手機上翻時
                else if (facingDirection == DIRECTION_UP) {
                    //關閉螢幕保護
                    screenSaver.stopScreenSaving();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        //結束手機翻轉偵測
        if (flippingManager != null) {
            flippingManager.stop();
        }
        super.onPause();
    }

    public void goToActivity4(View view) {
        Intent intent=new Intent();
        intent.setClass(this,Activity4.class);
        startActivity(intent);
        finish();
    }
}
