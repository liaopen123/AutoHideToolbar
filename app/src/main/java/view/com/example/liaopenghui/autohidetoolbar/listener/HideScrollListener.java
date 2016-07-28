package view.com.example.liaopenghui.autohidetoolbar.listener;

import android.util.Log;
import android.widget.AbsListView;

/**
 * Created by liaopenghui on 16/7/28.
 */
public abstract class HideScrollListener implements AbsListView.OnScrollListener {
    private static final int HIDE_THRESHOLD = 20; //隐藏阈值

    private int mScrolledDistance = 0;        //y距离
    private boolean mControlsVisible = true;
    private String TAG = "HideScrollListener";
    private int lastVisibleItem = 0;//刚开始是第0个


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        Log.e(TAG,"lastVisibleItem:"+lastVisibleItem+"firstVisibleItem:"+firstVisibleItem);
        if(firstVisibleItem == 0){
            if(!mControlsVisible) {
                onShow();
                mControlsVisible = true;
            }

        }else if(lastVisibleItem>firstVisibleItem){
            //下拉
            if(!mControlsVisible){
                onShow();
                mControlsVisible = true;
            }
        }else if(lastVisibleItem<firstVisibleItem){

            Log.e(TAG,"上拉了!!");
            if(mControlsVisible){
                Log.e(TAG,"上拉了1111111!!");
                onHide();
                mControlsVisible = false;
            }
        }

    lastVisibleItem = firstVisibleItem;


    }

    public abstract void onHide();
    public abstract void onShow();


    }

