package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String tag = "MainActivity";
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            String position = savedInstanceState.getString("key");
            Log.i(tag, "helloworld-------position:"+position);
        }
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.ACT1);

        //为Button绑定监听器,采用匿名内部类
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //下面这一行，有两种方法。方法一：
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        Log.i(tag, "helloworld-------onCreate");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(tag, "helloworld-------onSaveInstanceState");
        outState.putString("key", "com.example.helloworld.MainActivity");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.i(tag, "helloworld-------onStart");
    }
    @Override
    public void onPause(){
        super.onPause();
        try  {
            Thread.sleep(100);

            Log.i(tag, "helloworld------sleep-100");
        }  catch (InterruptedException e) {
            Log.i(tag, "helloworld--InterruptedException----sleep-2000");
             e.printStackTrace();
    }
        Log.i(tag, "helloworld-------onPause, isfinish="+isFinishing());
    }

    @Override
    public void onResume(){
        super.onResume();
        ///this.finish();
        Log.i(tag, "helloworld---finsh----onResume");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i(tag, "helloworld---finsh----onStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        boolean ret = this.isFinishing();
        boolean ret1 = this.isDestroyed();
        Log.i(tag, "helloworld-------onDestroy,isfinish="+ret+",isDestory="+ret1);
    }
}