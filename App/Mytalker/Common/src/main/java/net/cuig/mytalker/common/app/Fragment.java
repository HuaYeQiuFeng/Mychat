package net.cuig.mytalker.common.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class Fragment extends android.support.v4.app.Fragment {
    protected View mRoot;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //初始化参数
        initArgs(getArguments());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
  if (mRoot==null) {
      int layId = getContentlayoutId();
      View root = inflater.inflate(layId, container, false);
      initWidget(root);
      mRoot=root;
  }else {
      if (mRoot.getParent()!=null){
          //把当前Root从父控件移除
          ((ViewGroup)mRoot.getParent()).removeView(mRoot);
      }
  }
        return mRoot;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }
    //初始化bundle
    protected void initArgs(Bundle bundle){
    }
    protected abstract int getContentlayoutId();

    protected  void initWidget(View root){

    }
    protected void initData(){

    }
    //返回按键时调用
    public boolean onBackPressec(){
        return false;
    }
}
