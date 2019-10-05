package com.sana.models;

public class Komunitas {
    private String id;
    private String nama;
    private String admin;
    private String anggota;
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getAnggota() {
        return anggota;
    }

    public void setAnggota(String anggota) {
        this.anggota = anggota;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
