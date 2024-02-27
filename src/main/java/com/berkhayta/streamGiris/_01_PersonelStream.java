package com.berkhayta.streamGiris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class _01_PersonelStream {
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

        //aynı kaynaktan 4 tane stream oluşturduk:
        Stream<Personel> stream1 = personelList.stream();
        Stream<Personel> stream2 = Stream.of(personelList.toArray(new Personel[personelList.size()]));
        Stream<Personel> stream3 = Arrays.stream(personelList.toArray(new Personel[personelList.size()]));
        personelList.stream();

        //1 metod: foreach: Bu metod bir terminal metoddur. Yani sonlandırıcı metoddur.

        //her seferinde personelList.stream() metodu ile yeni stream oluşturuyoruz.
        personelList.stream().forEach(personel -> System.out.println(personel)); // lambda fonx.
        personelList.stream().forEach(System.out::println); //metod referans
        // personellerin maaşına stream kullanarak %10 zam yap ve tekrar yazdır:
        personelList.stream().forEach(personel ->{
            personel.maasArtir(10);
            System.out.println(personel);
            //sonraki işlemler....
        });


        //2.yöntem:
        // Burada aynı stream 2 defa consume edilmeye çalışılmış. Ancak ilk çalışmada terminal metod olan forEach
        // kullanıldığı için consume edilecek bir öğe kalmamış ve 2. satır hata vermiştir.
        stream1.forEach(personel -> System.out.println(personel));
        stream1.forEach(personel -> System.out.println(personel)); //stream has already been operated upon or closed
    }
}
