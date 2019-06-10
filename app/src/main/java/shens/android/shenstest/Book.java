package shens.android.shenstest;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {


    private String bookId;
    private String bookName;

    protected Book(Parcel in) {
        bookId = in.readString();
        bookName = in.readString();
    }

    public Book(String bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bookId);
        dest.writeString(bookName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
