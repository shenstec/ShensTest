package shens.android.shenstest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 远程数据服务
 */
public class BookManagerService extends Service {

    private CopyOnWriteArrayList<Book> list = new CopyOnWriteArrayList<>();

    private Binder mBinder = new IBookManager.Stub(){

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public List<Book> getBookList() throws RemoteException {
            return list;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            list.add(book);
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
