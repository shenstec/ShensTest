package shens.android.shenstest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import shens.android.lib_base.ui.activity.BaseActivity;
import shens.android.shenstest.bean.UserInfo;

public class SecondActivity extends BaseActivity {


    private final String TAG = "SecondActivity === ";
    @BindView(R.id.tv_main_msg)
    TextView tvMsg;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        tvMsg.setText("SecondActivity");

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void workIntent(Intent intent) {

    }
}
