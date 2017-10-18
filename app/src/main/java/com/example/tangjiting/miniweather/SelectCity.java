package com.example.tangjiting.miniweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by tangjiting on 2017/10/18.
 */

public class SelectCity extends Activity implements View.OnClickListener{

    private ImageView mBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.select_city);

        mBackBtn = (ImageView)findViewById(R.id.title_back);
        mBackBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.title_back:
                Intent i = new Intent();
                //长春
                i.putExtra("cityCode","101060101");
                //桐城 报错了！强行退出
                //i.putExtra("cityCode","101220609");
                //安庆 报错了！强行退出
                //i.putExtra("cityCode","101220601");
                setResult(RESULT_OK,i);
                finish();
                break;
            default:
                break;
        }

    }


}
