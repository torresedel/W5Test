package com.example.admin.w5test.model;

import android.provider.Contacts;

/**
 * Created by Admin on 9/29/2017.
 */

public class PhotosWrapper {

    Contacts.Photos photos;

    public void setPhotos(Contacts.Photos photos) {
        this.photos = photos;
    }

    public Contacts.Photos getPhotos() {

        return photos;
    }
}
