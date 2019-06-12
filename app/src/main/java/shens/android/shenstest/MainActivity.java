package shens.android.shenstest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import shens.android.lib_base.mvp.BaseMvpActvity;
import shens.android.lib_http.bean.TopImageBean;
import shens.android.shenstest.mvp.MainModel;
import shens.android.shenstest.mvp.MainPresenter;

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

        Intent intent = new Intent(this, BookManagerService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
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



    @OnClick(R.id.tv_main_msg)
    void onClick(){
        startActivity(new Intent(this,SecondActivity.class));
    }

    @Override
    protected void initListener() {

        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {

            }
        }).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


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
        unbindService(mConnection);
    }
}
