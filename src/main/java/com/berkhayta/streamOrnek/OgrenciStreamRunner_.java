package com.berkhayta.streamOrnek;

import java.util.*;
import java.util.stream.Collectors;

public class OgrenciStreamRunner_ {
    /*Sorular:
       1: Öğrencilerin tamamını yazdırın.
       2: Not ortalaması 70'in üzerinde olan öğrencileri yazdırın.
       3: Endüstri Mühendisliğinde okuyan öğrencileri sayın.
       4. Adında can olan öğrencinin tüm bilgilerini yazdırın.
       5. Adı "Hakan" olan öğrenci var mı yok mu kontrol edin.
        */
    public static void main(String[] args) {
        ArrayList<Ogrenci> ogrenciler=new ArrayList<>();
        ogrenciler.add(new Ogrenci(1,"Aslıhan","Mert","EE Mühendisliği",85.0));
        ogrenciler.add(new Ogrenci(2,"Hasancan","Doganay","EE Mühendisliği",66d));
        ogrenciler.add(new Ogrenci(3,"Can Deniz","Gumus","İnşaat Mühendisliği",98d));
        ogrenciler.add(new Ogrenci(4,"Salih Ertuğrul","ER","Metalurji ve Malzeme Mühendisliği",92.5));
        ogrenciler.add(new Ogrenci(5,"Heval Can Aslan","Özen","EE Mühendisliği",90.0));
        ogrenciler.add(new Ogrenci(6,"Buse","Ölmez","Kimya Mühendisliği",65.0));
        ogrenciler.add(new Ogrenci(7,"İsmet Mustafa" , "Görgülü" , "Bilgisayar Mühendisliği" ,80.0));
        ogrenciler.add(new Ogrenci(8,"Serkan","Guner","Enerji Sistemleri Muhendisliği",80.0));
        ogrenciler.add(new Ogrenci(9, "Zeynep", "Isiklar", "EE Mühendisliği", 80.0));
        ogrenciler.add(new Ogrenci(10,"Berk","Hayta","Endüstri Mühendisliği",79d));
        ogrenciler.add(new Ogrenci(11,"Kenan Kerem","Öktener","İnşaat Mühendisliği",75d));
        ogrenciler.add(new Ogrenci(12, "Emir", "Esen", "İnşaat Mühendisliği", 75d));
        ogrenciler.add(new Ogrenci (13,"Hicran","Arslan","EE Mühendisliği",85.0d));
        ogrenciler.add(new Ogrenci(14,"İdris","Tamdoğan","EE Mühendisliği",75d));
        ogrenciler.add(new Ogrenci(15,"Sefa","Goktepe","Kimya Mühendisliği",75.0));
        ogrenciler.add(new Ogrenci(16,"Mina","Bilici","EE Mühendisliği",87d));

        System.out.println("1: Öğrencilerin tamamı:");
        ogrenciler.forEach(System.out::println);
        System.out.println("------------------------");

        System.out.println("2: Not ortalaması 70'in üzerinde olan öğrenciler:");
        ogrenciler.stream()
                .filter(ogrenci -> ogrenci.getNot() > 70)
                .forEach(System.out::println);
        System.out.println("------------------------");

        long endustriMuhendisligiOgrenciSayisi = ogrenciler.stream()
                .filter(ogrenci -> ogrenci.getBolum().equalsIgnoreCase("Endüstri Mühendisliği"))
                .count();
        System.out.println("3: Endüstri Mühendisliğinde okuyan öğrenci sayısı: " + endustriMuhendisligiOgrenciSayisi);
        System.out.println("------------------------");

        System.out.println("4: Adında 'can' olan öğrencinin tüm bilgileri:");
        ogrenciler.stream()
                .filter(ogrenci -> ogrenci.getAd().toLowerCase().contains("can"))
                .forEach(System.out::println);
        System.out.println("------------------------");

        boolean hakanVarMi = ogrenciler.stream()
                .anyMatch(ogrenci -> ogrenci.getAd().equalsIgnoreCase("Hakan"));
        System.out.println("5: Adı 'Hakan' olan öğrenci var mı? " + (hakanVarMi ? "Evet" : "Hayır"));
        System.out.println("------------------------");

        //6. Notlarına göre öğrencilerin tamamnını sıralyıp yazdırınız
        //7. Not ortalaması 70'ın üzerinde olan öğrencilerin adlarını ve bölümlerini yazdırın.
        //8. Bölümü EE Mühendisliği olan öğrencilerin sayisini bulun
        //9. En yüksek nota sahip öğrencinin bilgilerini yazdırın
        //10. Bölümlere göre öğrencilerin notlarının ortalamasını yazdırın

        System.out.println("6: Notlarına göre öğrencilerin tamamı:");
        List<Ogrenci> siraliOgrenciler = ogrenciler.stream()
                .sorted(Comparator.comparingDouble(Ogrenci::getNot))
                .collect(Collectors.toList());
        siraliOgrenciler.forEach(System.out::println);
        System.out.println("-------------------------");

        System.out.println("7: Not ortalaması 70'ın üzerinde olan öğrencilerin adları ve bölümleri:");
        ogrenciler.stream()
                .filter(ogrenci -> ogrenci.getNot() > 70)
                .forEach(ogrenci -> System.out.println(ogrenci.getAd() + " - " + ogrenci.getBolum()));
        System.out.println("-------------------------");

        long eeMuhendisligiOgrenciSayisi = ogrenciler.stream()
                .filter(ogrenci -> ogrenci.getBolum().equalsIgnoreCase("EE Mühendisliği"))
                .count();
        System.out.println("8: Bölümü EE Mühendisliği olan öğrenci sayısı: " + eeMuhendisligiOgrenciSayisi);
        System.out.println("-------------------------");

        System.out.println("9: En yüksek nota sahip öğrencinin bilgileri:");
        Ogrenci enYuksekNotluOgrenci = ogrenciler.stream()
                .max(Comparator.comparing(Ogrenci::getNot))
                .orElse(null);
        System.out.println(enYuksekNotluOgrenci);
        System.out.println("-------------------------");

        System.out.println("10: Bölümlere göre öğrencilerin notlarının ortalaması:");
        Map<String, Double> bolumeGoreOrtalamaNotlar = ogrenciler.stream()
                .collect(Collectors.groupingBy(Ogrenci::getBolum,
                        Collectors.averagingDouble(Ogrenci::getNot)));
        bolumeGoreOrtalamaNotlar.forEach((bolum, ortalamaNot) ->
                System.out.println(bolum + " - Ortalama Not: " + ortalamaNot));
        System.out.println("-------------------------");


        // 11. Not ortalaması 60-80 arasında olan öğrencilerin sayısını bulalım.
        // 12. En düşük nota sahip öğrencinin bölümünü yazdırınız.
        // 13. Ortalamaların ortalaması kaçtır?
        // 14. Notu 80 üzerinde olan kaç öğrenci vardır?

        long notOrtalamasi60_80ArasiOgrenciSayisi = ogrenciler.stream()
                .filter(ogrenci -> ogrenci.getNot() >= 60 && ogrenci.getNot() <= 80)
                .count();
        System.out.println("11: Not ortalaması 60-80 arasında olan öğrenci sayısı: " + notOrtalamasi60_80ArasiOgrenciSayisi);
        System.out.println("-------------------------");

        System.out.println("12: En düşük nota sahip öğrencinin bölümü: " +
                ogrenciler.stream()
                        .min(Comparator.comparing(Ogrenci::getNot))
                        .map(Ogrenci::getBolum)
                        .orElse("Bilgi Bulunamadı"));
        System.out.println("-------------------------");

        Double ortalamalarinOrtalamasi = ogrenciler.stream()
                .collect(Collectors.averagingDouble(Ogrenci::getNot));
        System.out.println("13: Ortalamaların ortalaması: " + ortalamalarinOrtalamasi);
        System.out.println("-------------------------");

        long notu80UzeriOgrenciSayisi = ogrenciler.stream()
                .filter(ogrenci -> ogrenci.getNot() > 80)
                .count();
        System.out.println("14: Notu 80 üzerinde olan öğrenci sayısı: " + notu80UzeriOgrenciSayisi);
        System.out.println("-------------------------");

        System.out.println("15: Her bölümdeki öğrenci sayıları:");
        Map<String, Long> bolumeGoreOgrenciSayilari = ogrenciler.stream()
                .collect(Collectors.groupingBy(Ogrenci::getBolum, Collectors.counting()));
        bolumeGoreOgrenciSayilari.forEach((bolum, sayi) -> System.out.println(bolum + ": " + sayi));
        System.out.println("-------------------------");

        Optional<String> enUzunAdliOgrenciAdi = ogrenciler.stream()
                .max(Comparator.comparingInt(ogrenci -> ogrenci.getAd().length()))
                .map(Ogrenci::getAd);
        enUzunAdliOgrenciAdi.ifPresent(ad -> System.out.println("16: Adı en uzun olan öğrencinin adı: " + ad));
        System.out.println("-------------------------");

    }

}
