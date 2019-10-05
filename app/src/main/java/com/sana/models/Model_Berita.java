package com.sana.models;

public class Model_Berita {

    private String id;
    private String judul;
    private String deskripsi;
    private String img;

    public Model_Berita(){};

    public Model_Berita(String id, String judul, String deskripsi, String img) {
        this.id = id;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
