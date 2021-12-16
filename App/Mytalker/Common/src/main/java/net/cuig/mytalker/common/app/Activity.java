package net.cuig.mytalker.common.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public abstract class Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initWindows();
        if (initArgs(getIntent().getExtras())) {
            getContentLayoutId();
            initWidget();
            initData();
        }else {
            finish();
        }
    }
    //窗口初始化
    protected void initWindows(){

    }

    //初始化bundle
    protected boolean initArgs(Bundle bundle){
        return true;
    }
    //得到当前资源ID
    protected  abstract int getContentLayoutId();
    //初始化控件
    protected void initWidget(){

    }
    //初始化数据
    protected void initData(){

    }

    @Override
    public boolean onSupportNavigateUp() {
        //点击界面返回时finish当前界面
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        //得到当前Activity下的所有Fragment
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        //判断是否为空
        if (fragments!=null&& fragments.size()>0){
            for (Fragment fragment:fragments){
                //判断是否为能够处理的Fragment类型
                if (fragment instanceof net.cuig.mytalker.common.app.Fragment){
                    //是否拦截返回按钮
                    if(((net.cuig.mytalker.common.app.Fragment)fragment).onBackPressec()){
                        return;
                    }
                }
            }
        }
        super.onBackPressed();
        finish();
    }
}
