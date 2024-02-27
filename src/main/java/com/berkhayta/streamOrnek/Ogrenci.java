package com.berkhayta.streamOrnek;

public class Ogrenci implements Comparable<Ogrenci> {
    private Integer id;
    private String ad;
    private String soyad;
    private String bolum;
    private Double not;

    public Ogrenci(Integer id, String ad, String soyad, String bolum, Double not) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.bolum = bolum;
        this.not = not;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", bolum='" + bolum + '\'' +
                ", not=" + not +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public Double getNot() {
        return not;
    }

    public void setNot(Double not) {
        this.not = not;
    }

    @Override
    public int compareTo(Ogrenci o) {
        return (int) (this.getNot()-o.getNot());
    }
}
