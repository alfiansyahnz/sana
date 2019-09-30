package com.sana.models;

public class Challenge {

    private String id;
    private String judul;
    private String deskripsi;
    private String img;
    private String suka;
    private String bagi;
    private String gabung;

    public Challenge(){};

    public Challenge(String id, String judul, String deskripsi, String img, String suka, String bagi, String gabung) {
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

    public String getSuka() {
        return suka;
    }

    public void setSuka(String suka) {
        this.suka = suka;
    }

    public String getBagi() {
        return bagi;
    }

    public void setBagi(String bagi) {
        this.bagi = bagi;
    }

    public String getGabung() {
        return gabung;
    }

    public void setGabung(String gabung) {
        this.gabung = gabung;
    }
}
