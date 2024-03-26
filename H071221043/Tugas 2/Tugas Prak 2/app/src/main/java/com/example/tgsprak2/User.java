package com.example.tgsprak2;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.EditText;

import androidx.annotation.NonNull;

public class User implements Parcelable {
   private String nama;
   private String uname;
   private String note1;
   private String note2;

    protected User(Parcel in) {
        nama = in.readString();
        uname = in.readString();
        note1 = in.readString();
        note2 = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getNote1() {
        return note1;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
    }

    public String getNote2() {
        return note2;
    }

    public void setNote2(String note2) {
        this.note2 = note2;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }


    public User(String nama, String uname, String note1, String note2) {
        this.nama = nama;
        this.uname = uname;
        this.note1 = note1;
        this.note2 = note2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(uname);
        dest.writeString(note1);
        dest.writeString(note2);
    }
}
