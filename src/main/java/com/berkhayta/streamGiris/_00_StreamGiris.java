package com.berkhayta.streamGiris;

import java.util.List;
import java.util.stream.Stream;

public class _00_StreamGiris {
    public static void main(String[] args) {
        //Stream oluşturma yöntemleri:
        Stream<String> tekKayit=Stream.of("Pazartesi");
        Stream<Double> cokKayit=Stream.of(5.0,7d,2.25,3.75);
        Stream<String> empty = Stream.empty(); // Boş bir stream.

        // List oluşturalım ve bunu streame dönüştürelim.
        List<String> gunlerListesi=List.of("Pazartesi","Salı","Çarşamba","Perşembe","Cuma","Cumartesi","Pazar");
        Stream<String> gunlerStream = gunlerListesi.stream();




    }
}
