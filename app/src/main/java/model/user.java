package model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class user implements Parcelable {

    private String fullname;
    private String email;
    private String password;
    private String homepage;
    private String about;
    private Uri imageUri;

    public user(String fullname, String email, String password, String homepage, String about, Uri imageUri)
    {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.homepage = homepage;
        this.about = about;
        this.imageUri = imageUri;
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

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
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
        dest.writeString(this.homepage);
        dest.writeString(this.about);
        dest.writeParcelable(this.imageUri,flags);
    }
    protected user(Parcel in) {
        this.fullname = in.readString();
        this.email = in.readString();
        this.password = in.readString();
        this.homepage = in.readString();
        this.about = in.readString();
        this.imageUri = in.readParcelable(Uri.class.getClassLoader());
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
