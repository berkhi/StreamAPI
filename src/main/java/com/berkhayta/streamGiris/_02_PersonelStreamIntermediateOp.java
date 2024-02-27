package com.berkhayta.streamGiris;

import java.util.*;
import java.util.stream.Collectors;

public class _02_PersonelStreamIntermediateOp {
    public static void main(String[] args) {
        List<Personel> personelList=new ArrayList<>();
        personelList.add(new Personel(1,"Cem","Yılmaz","Sinema",15_000d));
        personelList.add(new Personel(2,"Tarkan","Tevetoğlu","Müzik",25_000d));
        personelList.add(new Personel(3,"Elon","Musk","Space",150_000_000d));
        personelList.add(new Personel(4,"Morgan","Freeman","Sinema",150_000d));
        personelList.add(new Personel(5,"Tarık","Mengüç","Müzik",15_000d));
        personelList.add(new Personel(6,"Davut","Güloğlu","Müzik",15_000d));
        personelList.add(new Personel(7 , "Cem" , "Karaca" , "Müzik" , 20_000d));
        personelList.add(new Personel(8 , "Barış" , "Manço" , "Müzik" , 10_000d));
        personelList.add(new Personel(9,"Emre","Ozturk","Spor",10_000d));
        personelList.add(new Personel(10,"Mauro","Icardi","Futbol",10_000_000d));
        personelList.add(new Personel(11,"Demet","Akalın","Şarkıcı",1_500_000d));
        personelList.add(new Personel(12,"Ayse","Kulin","Yazar",17_000d));
        personelList.add(new Personel(13,"Al","Pachino","Sinema",20_000d));
        personelList.add(new Personel(14,"Albert","Einstein","Fizik",35_000_000d));
        personelList.add(new Personel(15,"Arda", "Turan","Futbol",4_000_000d));

        // 2. Filter() -> streamde belirli bir koşula uyanları filtreler. Kalan elemanlardan yeni bir akış oluşturur.
        //Predicate : Bir koşul gibi düşünebiliriz. True false dönecek bir yapı
        System.out.println("Filter(): ile adında e geçen personelleri yazdır.");
        personelList.stream()
                .filter(personel -> personel.getAd().contains("e"))
                .forEach(System.out::println);

        // adında e geçenlere %20 zam yap:
        personelList.stream()
                .filter(personel -> personel.getAd().toLowerCase().contains("e"))
                .forEach(personel -> personel.maasArtir(20));

        // Döngü ile içindeki elemanları görüntüle:
        // Terminal Operasyonlar kaynağı direkt etkiler:
        for (Personel personel : personelList) {
            System.out.println(personel);
        }

        // adı A ile başlayan personellerin maaşına %10 zam yapalım:
        personelList.stream()
                .filter(personel -> personel.getAd().startsWith("A"))
                .forEach(personel -> {
                    personel.maasArtir(10);
                    System.out.println(personel);
                });

        // Maaşı 1_000_000 altında olanlara %100 zam yap:
        personelList.stream()
                .filter(personel -> personel.getMaas()<1_000_000)
                .forEach(personel -> {
                    personel.maasArtir(100);
                    System.out.println(personel);
                });

        //3. Map(): Belirli bir alanı alıp göstermek için
        System.out.println("-----------Map-----------");
        personelList.stream()
                .map(personel -> personel.getMaas())
                .forEach(System.out::println);




        //map içinde bir değere ekleme yapıp gösterme:
        personelList.stream()
                .map(personel -> personel.getMaas()+5)
                .forEach(System.out::println);
        //map içinde set işlemi yapılabilir mi?

        personelList.stream()
                .map(personel -> personel.getMaas()+5)
                .forEach(System.out::println);


        for (Personel personel : personelList) {
            System.out.println(personel);
        }

        //4. Distinct: Her bir elemanı bir kere yazdırmak için:
        System.out.println("---------DISTINCT--------");
        personelList.stream()
                .map(personel -> personel.getDepartman())
                .forEach(System.out::println);
        System.out.println("---------");
        personelList.stream()
                .map(personel -> personel.getDepartman())
                .distinct()
                .forEach(System.out::println);


        //5. Sorted: Sıralama
        System.out.println("--------SORTED-----------");
        personelList.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("-----------TERSTEN SIRALI -reverseOrder-------");
        personelList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        //6. limit: streamden kaç kayıt alınacak
        System.out.println("-----------limit(5)-------");
        personelList.stream().limit(5).forEach(System.out::println);



        //en yüksek maaşı alan personelin adını yazdırın:

        personelList.stream()
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .map(personel -> personel.getAd())
                .forEach(System.out::println);

        //7. skip : kaç eleman atlanacağını belirtebiliriz.
        System.out.println("-----------skip(2)-------");
        personelList.stream().skip(5).limit(3).forEach(System.out::println);

        // 8. count(): Terminal Operation.
        //kaç farklı departman var
        System.out.println("-----------count departman-------");
        long count = personelList.stream()
                .map(personel -> personel.getDepartman())
                .distinct()
                .count();
        System.out.println(count);

        System.out.println("toplam kayıt sayısı: "+personelList.stream().count());

        //TerminaL:
        //9. anyMatch: koşulu sağlayan en az 1 kişi varsa true döner.
        boolean anyMatch= personelList.stream().anyMatch(personel -> personel.getMaas()>10_000_000d);
        System.out.println(anyMatch);
        //10.allMatch: koşulu tüm elemanlar sağlıyorsa true döner.
        boolean allMatch= personelList.stream().allMatch(personel -> personel.getMaas()>1_000d);
        System.out.println("AllMatch:"+allMatch);
        //11.noneMatch: koşula hiç bir eleman uymuyorsa true döner.
        boolean noneMatch= personelList.stream().noneMatch(personel -> personel.getMaas()>1_000_000_000d);
        System.out.println("NoneMatch:"+noneMatch);

        //12.reduce: azaltmak
        List<Integer> sayilar= Arrays.asList(5,15,10,2);
        //toplam:
        Integer sonuc = sayilar.stream().reduce(0, (toplam, sayi) -> toplam + sayi);
        System.out.println(sonuc);
        //carpim:
        sonuc = sayilar.stream().reduce(1, (carpim, sayi) -> carpim * sayi);
        System.out.println(sonuc);

        //MAX bulabilir misin?
        Optional<Integer> max = sayilar.stream().reduce((sayi1, sayi2) -> sayi1 > sayi2 ? sayi1 : sayi2);

        if(max.isPresent())
            System.out.println(max.get());

        // Maaşı 100_000 altında olanların ve adında e geçenlerin maaşlarına 5000Tl ekle ve maaşını sonunda TL ifaedesi ile yazdırınız.
        System.out.println("------------MAP-------------");
        //20000TL
        personelList.stream()
                .filter(p->p.getMaas()<100_000)
                .filter(p->p.getAd().toLowerCase().contains("e"))
                .map(p->(p.getMaas()+5000)+" TL")
                .forEach(System.out::println);
        System.out.println(personelList);


        //13. Collect :Streamden bir collection oluşturmaya yarar.
        System.out.println("------------Collect toList-------------");
        //ArrayList -> stream -> ArrayList
        List<String> zamliListe = personelList.stream()
                .filter(p -> p.getMaas() < 100_000)
                .filter(p -> p.getAd().toLowerCase().contains("e"))
                .map(p -> (p.getMaas() + 5000) + " TL")
                .collect(Collectors.toList());
        System.out.println(zamliListe);
        zamliListe.forEach(System.out::println);

        //personelList ArrayListindeki personellerin departmanlarını bir sette toplayınız.(stream kullanarak)
        //ArrayList -> stream -> Set
        Set<String> departmanSeti = personelList.stream()
                .map(p -> p.getDepartman())
                .collect(Collectors.toSet());
        departmanSeti.forEach(System.out::println);

        //Map(K,V) ->stream-> Set?
        Map<String,String> futbolcular=new HashMap<>();
        futbolcular.put("Messi","Sol Ayak");
        futbolcular.put("Ronaldo","Sol Ayak");
        futbolcular.put("Arda","Sol Ayak");
        futbolcular.put("Selim","Sağ Ayak");
        futbolcular.put("Junior","Sağ Ayak");

        // bu mapteki valueları bir sette tutalım.
        Set<String> keys= futbolcular.keySet();
        Set<String> values= futbolcular.values().stream().collect(Collectors.toSet());

        values.forEach(System.out::println);
        keys.forEach(System.out::println);

        // Listten -Map
        //personellerin adları, personellerin adlarının uzunlukları
        //Cem,3

        Map<String, Integer> isimlerVeUzunluklar = personelList.stream()
                .map(p -> p.getAd())
                .distinct()
                .collect(Collectors.toMap(ad -> ad, ad -> ad.length()));

        isimlerVeUzunluklar.forEach((k,v)-> System.out.println(k+" "+v));

        //14. Peek()
        List<Double> collect = personelList.stream()
                .peek(p -> System.out.println("Zamdan önce:" + p.getMaas()))
                .map(p -> p.getMaas() * 2)
                .peek(zamliMaas -> System.out.println("Zamdan sonra:" + zamliMaas))
                .collect(Collectors.toList());

        //15. Joining():
        String personelAdlar = personelList.stream()
                .map(personel -> personel.getAd())
                .collect(Collectors.joining("-"));
        System.out.println(personelAdlar);


    }
}
