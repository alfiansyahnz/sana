package com.sana.models;

public class Event {

    private String id;
    private String judul;
    private String waktu;
    private String img;
    private String hari;
    private String tempat;
    private String tanggal;
    private String bulan;
    private String tahun;
    private String group;
    private String deskripsi;
    private int gabung;

    public Event(){};

    public Event(String id, String judul, String waktu, String img, String hari, String tempat, String tanggal, String bulan, String tahun, String group, String deskripsi, int gabung) {
        this.id = id;
        this.judul = judul;
        this.waktu = waktu;
        this.img = img;
        this.hari = hari;
        this.tempat = tempat;
        this.tanggal = tanggal;
        this.bulan = bulan;
        this.tahun = tahun;
        this.group = group;
        this.deskripsi = deskripsi;
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

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getGabung() {
        return gabung;
    }

    public void setGabung(int gabung) {
        this.gabung = gabung;
    }
}