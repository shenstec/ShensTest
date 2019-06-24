package shens.android.lib_base.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import shens.android.base.R;
import shens.android.lib_base.utils.ToastUtils;

/**
 * Created by shenshilei on 2019/4/22.
 * email ssl_java@163.com
 * site http://www.houziyou.com
 */
public abstract class BaseActivity extends RxAppCompatActivity {

    private Unbinder unbinder;

    private ProgressDialog loadingDialog = null;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);

        // bundle数据处理
        Intent intent = getIntent();
        if (intent != null) {
            workIntent(intent);
        }


        // 初始化需要的控件
        initView();
        initView(savedInstanceState);
        // 初始化监听
        initListener();
        // 初始化数据
        initData();

    }

    protected abstract int getLayoutId();


    /**
     * go to activity - bundle
     */
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * go to activity - bundle
     */
    public void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }


    protected abstract void initData();

    protected abstract void initListener();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initView();

    protected abstract void workIntent(Intent intent);


    /**
     * show loading
     *
     * @param title tip
     */
    protected void showLoadingDialog(String title) {
        createLoadingDialog();
        loadingDialog.setMessage(title);
        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    /**
     * show loading
     */
    protected void showLoadingDialog() {
        createLoadingDialog();
        loadingDialog.setMessage(getString(R.string.cm_string_run_load_tip));
        if (!loadingDialog.isShowing())
            loadingDialog.show();
    }

    /**
     * create loading
     */
    private void createLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = new ProgressDialog(this);
            loadingDialog.setCancelable(true);
            loadingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /**
     * dismiss loading
     */
    protected void hideLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    protected void showShort(String msg){
        ToastUtils.showShort(msg);
    }

}
