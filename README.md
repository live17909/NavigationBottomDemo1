# NavigationBottomDemo1
模仿知乎的底部导航栏

# 原版如下：

# 功能介绍：
###       定义方法：
####          1> 在res/menu文件夹下创建NavigationBottom要使用的menu文件，如下：
             
             <menu xmlns:android="http://schemas.android.com/apk/res/android"
             xmlns:app="http://schemas.android.com/apk/res-auto">

                <item
                    android:title="item1"
                    app:nb_tabActiveResId="@drawable/doc_active"
                    app:nb_tabInActiveResId="@drawable/doc_inactive"
                    app:nb_insetLeft="24dp"
                    app:nb_insetTop="14dp"
                    app:nb_insetRight="24dp"
                    app:nb_insetBottom="14dp"
                    />
                <item
                    android:title="item2"
                    app:nb_tabActiveResId="@drawable/find_active"
                    app:nb_tabInActiveResId="@drawable/find_inactive" />
            
                <item
                    android:title="item3"
                    app:nb_tabActiveResId="@drawable/notification_active"
                    app:nb_tabInActiveResId="@drawable/notification_inactive" />
            
                <item
                    android:title="item4"
                    app:nb_tabActiveResId="@drawable/message_active"
                    app:nb_tabInActiveResId="@drawable/message_inactive" />
            
                <item
                    android:title="item5"
                    app:nb_tabActiveResId="@drawable/more_active"
                    app:nb_tabInActiveResId="@drawable/more_inactive" />
            
            </menu>
            
#####            关于以上属性的介绍：
       
             android:title : 这是<item>标签中默认必须要写的参数，暂时没用到，可以在类BottomMenuItem中通过getTitle()拿到当前tab的title
             
             app:nb_tabActiveResId : 为当前item(即当前tab）设置当其选中时的图片id。
             
             app:nb_tabInActiveResId : 为当前item(即当前tab）设置当其未选中时的图片id。
             
             app:nb_insetLeft : 设置当前Item(即当前ab)的背景图片距离左边缘的距离，具体下面有图解
             
             app:nb_insetTop : 设置当前Item(即当前ab)的背景图片距离上边缘的距离，具体下面有图解
             
             app:nb_insetRight ： 设置当前Item(即当前ab)的背景图片距离右边缘的距离，具体下面有图解
             
             app:nb_insetBottom ： 设置当前Item(即当前ab)的背景图片距离下边缘的距离，具体下面有图解
             
#####            注意：
             默认内部的insetLeft,insetRight,insetTop,insetBottom 默认是12dp。当你设置了app:nb_insetLeft 、  app:nb_insetTop 、app:nb_insetRight、
             app:nb_insetBottom 时，便以设置的属性大小为准，当没有设置时，以默认值12dp为准。
             这样的话，当你设置了图标之后，发现有个别图标和其他不同大小，可以通过以上四个属性来微调指定图标大小，以达到整体一致的目的。
             
#####           inset的图解：  
    
####          2> 在xml文件中使用<MyNavigationBottom></MyNavigationBottom>：

             <com.example.navigationbottom.MyNavigationBottom
              android:id="@+id/navigationBtn1"
              android:layout_width="match_parent"
              android:layout_height="48dp"
              android:layout_alignParentBottom="true"
              android:background="@color/bottomBg"
              app:nb_xmlResource="@menu/navigation_btn"
              app:nb_defaultIndex="3"
              app:nb_scrollDuration="300"
              app:elevation="8dp">
              
#####            关于以上属性的介绍：
              app:nb_xmlResource ： 为NavigationBottom设置menu文件资源，即上面定义的menu资源id
              app:nb_defaultIndex : 为NavigationBottom设置初始选中的是哪一个tab。传入index即可，index类似于数组，从0开始。
              app:nb_scrollDuration ： 设置当NavigationBottom隐藏所需的时间。即可以设置其下降隐藏的速度
#####            注意：
               MyNavigationBottom标签中的layout_width最好为match_parent。当为具体大小时，会抛出异常 ： IllegalArgumentException (NavigationBottom's width must be match_parent,which couldn't less than screenSize)
               当为wrap_content时，内部onMeasure()中会自动将其调整为match_parent。
               而对于layout_height 请不要设置为match_parent ,设置为具体的数值，比如48dp
               
###       使用方法：
             1） 在xml中定义之后，在代码中找到它：
                  navigationBottom = (MyNavigationBottom) findViewById(R.id.navigationBtn1);
             2） 然后你可以设置监听事件：
             
                   navigationBottom.setOnTabListener(new OnTabSelectListener() {
                        @Override
                        public void onTabSelected(int index, View view) {
                            Log.d("kklog", "######onTabSelected index=====>" + index + "######");
                            Toast.makeText(MainActivity.this, index + "", Toast.LENGTH_SHORT).show();
                        }
                    });
                    
             3） 当然，还有隐藏的方法：
                   navigationBottom.hide();
             4)   同理，还有显示的方法：
                   navigationBottom.show(); 
             5)   最后，当你需要知道当前选中的是哪一个tab时，可以这样做：
                   navigationBottom.getSelectedIndex();
        
# 运行截图：
     
              
              
              
              
