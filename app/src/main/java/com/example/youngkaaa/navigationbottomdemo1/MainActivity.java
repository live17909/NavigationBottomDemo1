package com.example.youngkaaa.navigationbottomdemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private boolean isTwo = false;
    private MyNavigationBottom navigationBottom;
    private boolean isShow = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationBottom = (MyNavigationBottom) findViewById(R.id.navigationBtn1);
        navigationBottom.setOnTabListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int index, View view) {
                Log.d("kklog", "######onTabSelected index=====>" + index + "######");
                Toast.makeText(MainActivity.this, index + "", Toast.LENGTH_SHORT).show();
            }
        });
        Log.d("kklog", "######onTabSelected getSelectedIndex=====>" + navigationBottom.getSelectedIndex() + "######");
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isShow) {
                    navigationBottom.hide();
                    isShow=false;
                }else{
                    navigationBottom.show();
                    isShow=true;
                }
                Toast.makeText(MainActivity.this, "hide!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
