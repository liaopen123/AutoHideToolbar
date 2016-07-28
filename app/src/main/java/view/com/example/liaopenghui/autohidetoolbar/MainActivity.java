package view.com.example.liaopenghui.autohidetoolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import view.com.example.liaopenghui.autohidetoolbar.listener.HideScrollListener;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView lv;
    private String TAG = "MainActivity";
    private int lastVisibleItem = 0;
    private boolean mControlsVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initListView();

    }



    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //剩下的就不管了

    }

    private void initListView() {
        View view = View.inflate(MainActivity.this, R.layout.headview,null);
        lv = (ListView) findViewById(R.id.lv);
        lv.addHeaderView(view);
        lv.setAdapter(new MyAdapter());

        lv.setOnScrollListener(new HideScrollListener() {
            @Override
            public void onHide() {
                Log.e(TAG,"HIDE");
                hideViews();
            }

            @Override
            public void onShow() {
                Log.e(TAG,"SHOW");
                showViews();
            }
        });




    }
    private void hideViews() {
        toolbar.animate().translationY(-toolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));

    }

    private void showViews() {
        toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));

    }



    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(MainActivity.this, R.layout.item_lv, null);
            return view;
        }
    }
}
