package com.globant.equattrocchio.data.Realm;

import com.globant.equattrocchio.data.mapper.Mapper;
import com.globant.equattrocchio.domain.data.Image;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.PrimaryKey;

public class ImageRealm extends RealmObject {
    @PrimaryKey
    private Integer id;
    private String url;
    private String largeUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public static void saveRealmImage(ImageRealm image, Realm realm) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(image);
        realm.commitTransaction();
    }

    public static void saveAllImages(List<Image> imageResponses, Realm realm) {
        for (int i = 0; i < imageResponses.size(); i++) {
            saveRealmImage(Mapper.imageToRealmImage(imageResponses.get(i)), realm);
        }
    }

    public static List<Image> getAllImages(Realm realm){
        final RealmResults<ImageRealm> realmImages = realm.where(ImageRealm.class).findAll();
        List<Image> imageResponses = new ArrayList<>();
        for (int i = 0; i < realmImages.size(); i++) {
            imageResponses.add(Mapper.imageRealmToImage(realmImages.get(i)));
        }
        return imageResponses;
    }

}
