package shens.android.shenstest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import shens.android.lib_base.mvp.BaseMvpActvity;
import shens.android.lib_base.utils.SoftKeyBoardListener;
import shens.android.lib_base.utils.ToastUtils;
import shens.android.shenstest.bean.TopImageBean;
import shens.android.shenstest.mvp.MainModel;
import shens.android.shenstest.mvp.MainPresenter;
import shens.android.shenstest.simple.pattern.factory.abstr.AudiTrunk;
import shens.android.shenstest.simple.pattern.factory.abstr.ProduceFactory;
import shens.android.shenstest.simple.pattern.factory.abstr.BmwTrunk;
import shens.android.shenstest.simple.pattern.factory.abstr.Trunk;
import shens.android.shenstest.utils.Test;
import shens.android.shenstest.widget.SheetDialog;

public class MainActivity extends BaseMvpActvity<MainPresenter> implements MainModel.View {


    private final String TAG = "MainActivity === ";


    @BindView(R.id.tv_main_msg)
    TextView tvMsg;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        showLoadingDialog();
        mPresenter.getTopImage();

//        Factory factory = new ConcreateFractory();
//
//        Product product = factory.createProduct(ProductA.class);
//        product.mecthod();

        ProduceFactory factory = new ProduceFactory();
        Trunk audiTrunk = factory.crateTrunk(AudiTrunk.class);
        audiTrunk.run();

        Trunk bmwTrunk = factory.crateTrunk(BmwTrunk.class);
        bmwTrunk.run();

        Test test = new Test();
        test.mainTest();

//        Intent intent = new Intent(this, BookManagerService.class);
//        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }


    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IBookManager iBookManager = IBookManager.Stub.asInterface(service);
            try {
                List<Book> list = iBookManager.getBookList();
                Log.d(TAG, "onServiceConnected: query book list, list type: " + list.getClass().getCanonicalName());
                Log.d(TAG, "onServiceConnected: query book list: " + list.toString());
                Book newBook = new Book("3", "Android 开发艺术探索");
                Log.d(TAG, "onServiceConnected: add book: " + newBook);
                iBookManager.addBook(newBook);
                List<Book> newList = iBookManager.getBookList();
                Log.d(TAG, "onServiceConnected: query book list: " + newList.toString());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    List<String> menus = new ArrayList<>();
    @OnClick(R.id.tv_main_msg)
    void onClick(){
//        startActivity(new Intent(this,SecondActivity.class));
//        menus.clear();
//        menus.add("第一");
//        menus.add("第二");
//        menus.add("第三");
//        menus.add("第四");

//        SheetDialog sheetDialog = SheetDialog.buildDialog(this,menus);
//        sheetDialog.setOnMenuSelect(new SheetDialog.OnMenuSelectListener() {
//            @Override
//            public void onSelect(int position) {
//                ToastUtils.showShort(menus.get(position));
//            }
//        });
//        sheetDialog.show();
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

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void showError(String msg) {
        super.showError(msg);
        hideLoadingDialog();
        tvMsg.setText("异常"+msg);
    }

    @Override
    public void getSuccess(List<TopImageBean> data) {
        hideLoadingDialog();
        tvMsg.setText("成功"+data.size());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if(mConnection!=null)
//            unbindService(mConnection);
    }
}
