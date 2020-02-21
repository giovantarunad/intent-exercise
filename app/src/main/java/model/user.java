package model;

import android.os.Parcel;
import android.os.Parcelable;

public class user implements Parcelable {

    private String fullname;
    private String email;
    private String password;
    private String confirmpassword;
    private String homepage;
    private String about;

    public user(String fullname, String email, String password, String confirmpassword, String homepage, String aboutyou) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.homepage = homepage;
        this.about = about;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fullname);
        dest.writeString(this.email);
        dest.writeString(this.password);
        dest.writeString(this.confirmpassword);
        dest.writeString(this.homepage);
        dest.writeString(this.about);
    }
    protected user(Parcel in) {
        this.fullname = in.readString();
        this.email = in.readString();
        this.password = in.readString();
        this.confirmpassword = in.readString();
        this.homepage = in.readString();
        this.about = in.readString();
    }

    public static final Creator<user> CREATOR = new Creator<user>() {
        @Override
        public user createFromParcel(Parcel in) {
            return new user(in);
        }

        @Override
        public user[] newArray(int size) {
            return new user[size];
        }
    };
}
