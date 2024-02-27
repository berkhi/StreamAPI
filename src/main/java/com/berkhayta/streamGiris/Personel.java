package com.berkhayta.streamGiris;

public class Personel implements Comparable<Personel> {
    private Integer id;
    private String ad;
    private String soyad;
    private String departman;
    private Double maas;

    public void maasArtir(double oran){
        maas+=maas*oran/100;
    }

    public Personel(Integer id, String ad, String soyad, String departman, Double maas) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.departman = departman;
        this.maas = maas;
    }
    @Override
    public String toString() {
        return "Personel{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", departman='" + departman + '\'' +
                ", maas=" + maas +
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

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public Double getMaas() {
        return maas;
    }

    public void setMaas(Double maas) {
        this.maas = maas;
    }


    @Override
    public int compareTo(Personel o) {
        return (int) (this.maas-o.maas);
    }
}
