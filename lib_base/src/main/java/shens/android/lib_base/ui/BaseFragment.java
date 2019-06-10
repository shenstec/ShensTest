package shens.android.lib_base.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shens.android.base.R;

import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends RxFragment {
    private Unbinder unbinder;

    private ProgressDialog loadingDialog = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(),container);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(getActivity());
        // bundle数据处理
        Intent intent = getActivity().getIntent();
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
        intent.setClass(getContext(), cls);
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
        intent.setClass(getContext(), cls);
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
            loadingDialog = new ProgressDialog(getContext());
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

}
