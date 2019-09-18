package com.sana.models;

public class Model_Challenge {

    private String id;
    private String judul;
    private String deskripsi;
    private String img;
    private int suka;
    private int bagi;
    private int gabung;

    public Model_Challenge(){};

    public Model_Challenge(String id, String judul, String deskripsi, String img, Integer suka, Integer bagi, Integer gabung) {
        this.id = id;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.img = img;
        this.suka = suka;
        this.bagi = bagi;
        this.gabung = gabung;
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

    public Integer getSuka() {
        return suka;
    }

    public void setSuka(Integer suka) {
        this.suka = suka;
    }

    public Integer getBagi() {
        return bagi;
    }

    public void setBagi(Integer bagi) {
        this.bagi = bagi;
    }

    public Integer getGabung() {
        return gabung;
    }

    public void setGabung(Integer gabung) {
        this.gabung = gabung;
    }
}
