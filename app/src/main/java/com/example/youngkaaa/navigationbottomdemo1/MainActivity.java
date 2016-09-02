package com.example.youngkaaa.navigationbottomdemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.navigationbottom.MyNavigationBottom;
import com.example.navigationbottom.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {
    private MyNavigationBottom navigationBottom;
    private boolean isShow = true;
    private RecyclerView recyclerView;
    private MyRecycelerAdapter recycelerAdapter;
    private int lastX;
    private int lastY;
    private int x;
    private int y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerViewMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recycelerAdapter=new MyRecycelerAdapter();
        recyclerView.setAdapter(recycelerAdapter);
        navigationBottom = (MyNavigationBottom) findViewById(R.id.navigationBtn1);
        navigationBottom.setOnTabListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int index, View view) {
                Log.d("kklog", "######onTabSelected index=====>" + index + "######");
                Toast.makeText(MainActivity.this, "Selected "+index, Toast.LENGTH_SHORT).show();
            }
        });
        Log.d("kklog", "######onTabSelected getSelectedIndex=====>" + navigationBottom.getSelectedIndex() + "######");
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                x= (int) motionEvent.getX();
                y= (int) motionEvent.getY();
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_MOVE:
                        int deltaY=y-lastY;
                        if(deltaY>=0){  //down
                            navigationBottom.show();
                        }else{  //up
                            navigationBottom.hide();

                        }
                        break;
                }
                lastX=x;
                lastY=y;
                return false;
            }
        });

    }
}
