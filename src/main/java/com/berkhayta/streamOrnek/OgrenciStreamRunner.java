package com.berkhayta.streamOrnek;

import java.util.*;
import java.util.stream.Collectors;

public class OgrenciStreamRunner {
    public static void main(String[] args) {
        ArrayList<Ogrenci> ogrenciler=new ArrayList<>();
        ogrenciler.add(new Ogrenci(1,"Aslıhan","Mert","Elektrik Elektronik Mühendisliği",85.0));
        ogrenciler.add(new Ogrenci(2,"Hasancan","Doganay","Elektrik Elektronik Mühendisliği",66d));
        ogrenciler.add(new Ogrenci(3,"Can Deniz","Gumus","İnşaat Mühendisliği",98d));
        ogrenciler.add(new Ogrenci(4,"Salih Ertuğrul","ER","Metalurji ve Malzeme Mühendisliği",92.5));
        ogrenciler.add(new Ogrenci(5,"Heval Can Aslan","Özen","Elektrik Elektronik Mühendisliği",90.0));
        ogrenciler.add(new Ogrenci(6,"Buse","Ölmez","Kimya Mühendisliği",65.0));
        ogrenciler.add(new Ogrenci(7,"İsmet Mustafa" , "Görgülü" , "Bilgisayar Mühendisliği" ,80.0));
        ogrenciler.add(new Ogrenci(8,"Serkan","Guner","Enerji Sistemleri Mühendisliği",80.0));
        ogrenciler.add(new Ogrenci(9, "Zeynep", "Isiklar", "Elektrik Elektronik Mühendisliği", 80.0));
        ogrenciler.add(new Ogrenci(10,"Berk","Hayta","Endüstri Mühendisliği",79d));
        ogrenciler.add(new Ogrenci(11,"Kenan Kerem","Öktener","İnşaat Mühendisliği",75d));
        ogrenciler.add(new Ogrenci(12, "Emir", "Esen", "İnşaat Mühendisliği", 75d));
        ogrenciler.add(new Ogrenci (13,"Hicran","Arslan","Elektrik Elektronik Mühendisliği",85.0d));
        ogrenciler.add(new Ogrenci(14,"İdris","Tamdoğan","Elektrik Elektronik Mühendisliği",75d));
        ogrenciler.add(new Ogrenci(15,"Sefa","Goktepe","Kimya Mühendisliği",75.0));
        ogrenciler.add(new Ogrenci(16,"Mina","Bilici","Elektrik Elektronik Mühendisliği",87d));


        //Sorular:
        // 1: Öğrencilerin tamamını yazdırın.
        System.out.println("--------Soru 1-----------");
        ogrenciler.stream()
                .forEach(System.out::println);

//        2: Not ortalaması 70'in üzerinde olan öğrencileri yazdırın.
        System.out.println("--------Soru 2-----------");
        ogrenciler.stream()
                .filter(ogrenci -> ogrenci.getNot()>70)
                .forEach(ogrenci-> System.out.println(ogrenci));
//        3: Endüstri Mühendisliğinde okuyan öğrencileri sayın.
        System.out.println("--------Soru 3-----------");
        long count = ogrenciler.stream()
                .filter(ogrenci -> ogrenci.getBolum().toLowerCase().contains("endüstri"))
                .count();
        System.out.println(count);

//        4. Adında can olan öğrencinin tüm bilgilerini yazdırın.
        System.out.println("--------Soru 4-----------");
        ogrenciler.stream()
                .filter(ogrenci -> ogrenci.getAd().toLowerCase().contains("can"))
                .forEach(System.out::println);
//        5. Adı "Hakan" olan öğrenci var mı yok mu kontrol edin.
        System.out.println("--------Soru 5-----------");
        boolean hakanVarMi=ogrenciler.stream()
                .anyMatch(ogrenci -> ogrenci.getAd().equalsIgnoreCase("hakan"));
        if(hakanVarMi)
            System.out.println("Adı hakan olan bir öğrenci bulundu");
        else
            System.out.println("Adı hakan olan bir öğrenci bulunamadı");
        //Alternatif 2:
        System.out.println("--------Soru 5 Alternatif 2-----------");
        ogrenciler.stream()
                .map(o->o.getAd())
                .filter(ad->ad.equalsIgnoreCase("hakan"))
                .findFirst()
                .ifPresentOrElse(
                        ad-> System.out.println(ad+ "adlı öğrenci var"),
                        ()-> System.out.println("Aranan öğrenci yok"));


        // 6. Notlarına göre öğrencilerin tamamını sıralayıp yazdırınız.
        System.out.println("--------Soru 6-----------");
        ogrenciler.stream()
                .sorted(Ogrenci::compareTo)
                .forEach(ogrenci -> System.out.println(ogrenci));
        System.out.println("--------Soru 6 Alternatif 2-----------");
        ogrenciler.stream()
                .sorted((o1,o2)-> (int) (o2.getNot()-o1.getNot()))
                .forEach(System.out::println);
        System.out.println("--------Soru 6 Alternatif 3-----------");
        ogrenciler.stream()
                .sorted(Comparator.comparingDouble(Ogrenci::getNot).reversed())
                .forEach(System.out::println);



        // 7. Not ortalaması 70'in üzerinde olan öğrencilerin adlarını ve bölümlerini yazdırın.
        System.out.println("--------Soru 7-----------");
        ogrenciler.stream()
                .filter(ogrenci -> ogrenci.getNot()>70)
                .forEach(ogrenci -> System.out.println(ogrenci.getAd()+" "+ogrenci.getBolum()));


        // 8. Bölümü Elektrik Elektronik Mühendisliği olan öğrencilerin sayısını bulunuz.
        System.out.println("--------Soru 8-----------");
        long count1 = ogrenciler.stream()
                .filter(ogrenci -> ogrenci.getBolum().contains("Elektrik Elektronik"))
                .count();
        System.out.println(count1);

        // 9. En yüksek nota sahip öüğrencinin bilgilerini yazdırın.
        System.out.println("--------Soru 9-----------");
        Optional<Ogrenci> max = ogrenciler.stream()
                .max(Comparator.comparingDouble(Ogrenci::getNot));
        if(max.isPresent())
            System.out.println(max.get());

        System.out.println("--------Soru 9 Alternatif 2-----------");
        ogrenciler.stream()
                .sorted(Comparator.comparingDouble(Ogrenci::getNot).reversed())
                .limit(1)
                .forEach(System.out::println);


        // 10. Bölümlere göre öğrencilerin notlarının ortalamasını yazdırın.
        // EE 60
        // İnş 70
        System.out.println("--------Soru 10 -----------");
        Map<String, Double> collect = ogrenciler.stream()
                .collect(Collectors.groupingBy(Ogrenci::getBolum, TreeMap::new, Collectors.averagingDouble(Ogrenci::getNot)));
        collect.forEach((k,v)-> System.out.println(k+" "+v));

        // 11. Not ortalaması 60-80 arasında olan öğrencilerin sayısını bulalım.
        System.out.println("--------Soru 11 -----------");
        long count2 = ogrenciler.stream()
                .filter(ogrenci -> ogrenci.getNot() > 60 && ogrenci.getNot() < 80)
                .count();
        System.out.println(count2);


        // 12. En düşük nota sahip öğrencinin bölümünü yazdırınız.
        System.out.println("--------Soru 12 -----------");
        ogrenciler.stream()
                .sorted(Comparator.comparingDouble(Ogrenci::getNot))
                .limit(1)
                .forEach(o-> System.out.println(o.getBolum()));

        // 13. Notların ortalaması kaçtır?
        System.out.println("--------Soru 13 -----------");
        Double collect1 = ogrenciler.stream()
                .collect(Collectors.averagingDouble(Ogrenci::getNot));
        System.out.println(collect1);

        System.out.println("--------Soru 12 Alternatif -----------");
        //Aggregate Fonx: Min Max Sum Count Average
        DoubleSummaryStatistics summaryStatistics = ogrenciler.stream()
                .collect(Collectors.summarizingDouble(Ogrenci::getNot));
        System.out.println("Summary:"+summaryStatistics.getAverage());

        // 14. Notu 80 üzerinde olan kaç öğrenci vardır?
        System.out.println("--------Soru 14 -----------");
        long count3 = ogrenciler.stream()
                .filter(ogrenci -> ogrenci.getNot() > 80)
                .count();
        System.out.println(count3);

        // 15. Her bölümdeki öğrenci sayısı kaçtır yazdırın.
        System.out.println("--------Soru 15 -----------");
         ogrenciler.stream()
                .collect(Collectors.groupingBy(Ogrenci::getBolum, Collectors.counting()))
                 .forEach((bolum,sayi)-> System.out.println(bolum+" "+sayi));


        // 16. Adı en uzun olan öğrencinin adı nedir?
        System.out.println("--------Soru 16 -----------");
        ogrenciler.stream()
                .max(Comparator.comparingInt(ogrenci->ogrenci.getAd().length()))
                .ifPresent(ogrenci -> System.out.println("Adı en uzun öğrencinin adı:"+ogrenci.getAd()));





    }
}
