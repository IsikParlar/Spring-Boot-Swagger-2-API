//http://localhost:8080/swagger-ui.html#
package tr.edu.medipol.ilerijavauyg.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/")

    public String ogrenciAdiSoyadiNumarasi(@RequestParam(value = "studentID", defaultValue = "H5200024") String studentId,
                                           @RequestParam(value = "ad", defaultValue = "Mustafa Işık") String ad,
                                           @RequestParam(value = "soyad", defaultValue = "Parlar") String soyad) {

        return String.format("Öğrenci Numarası: %s \nAdı: %s\nSoyadı: %s", studentId, ad, soyad);
    }

    @GetMapping("/soru1_silindir-alan-hacim")

    public String alan(@RequestParam(value = "yaricap", defaultValue = "1") Integer yaricap,
                       @RequestParam(value = "yukseklik", defaultValue = "1") Integer yukseklik) {

        return ("Pi 3 alınmıştır.\nSilindirin alanı: " + (yaricap + yukseklik) * 2 * 3 * yaricap + "\nHacmi: " + 3 * yaricap * yaricap * yukseklik);
    }

    @GetMapping("/soru2_kilometre-donusumu")

    public String kilometre(@RequestParam(value = "kilometre", defaultValue = "1") Integer kilometre) {

        return (kilometre + " kilometre " + kilometre * 1000 + " metredir, " + kilometre * 100000 + " santimetredir.");
    }

    @GetMapping("/soru3_girilenSayininTekVeCiftDegerleri")

    public String sayi(@RequestParam(value = "Sayı Giriniz", defaultValue = "1") Integer sayi) {
        int ciftToplam = 0;
        int tekKare = 0;
        int i;

        for (i = 0; i <= sayi; i++) {
            if (i % 2 == 0) {
                ciftToplam = ciftToplam + i;
            } else {
                tekKare = tekKare + (i * i);

            }
        }
        return ("Çift Sayıların toplamı :" + ciftToplam + "\nTek sayıların Kareleri Toplamı: " + tekKare);
    }

    @GetMapping("/soru4_derece-radyan-grad-cevirme")

    public String aci(@RequestParam(value = "Dereceyi Giriniz", defaultValue = "1") Double aci) {

        Double radyan = (aci * 3.14) / 180;
        Double grad = (aci * 200) / 180;
        return ("Pİ 3.14 Alınmıştır\n" + "Girilen Açı: " + aci + " Radyan Cinsinden :" + radyan + " Grad Cinsinden :" + grad);
    }

    @GetMapping("soru5_asal-sayi")

    public String primeNumber(@RequestParam(value = "Sayı Giriniz", defaultValue = "1") Integer inputN) {

        int sayac = 0;
        String asalSayi ="";

        for (int j = 2; j <= inputN; j++) {

            for (int i = 2; i < j; i++) {
                if (j % i != 0) {
                    sayac++;

                    if (sayac == j - 2) {
                        asalSayi+="\n"+j;
                        sayac = 0;
                    }
                } else {
                    break;
                }
            }
        }return inputN + " Değerine Kadar Olan Asal Sayılar: \n"+asalSayi;

    }

    @GetMapping("/soru6_txt-yildiz")

    public String yildizBasma(@RequestParam(value = "Kaç Satır Olacağını Giriniz: ", defaultValue = "1") Integer i_yildizSayisi) {

        File f = new File("basamak.txt");
        try {
            FileWriter fileWriter = new FileWriter(f,false);
            for (int i =0; i<i_yildizSayisi;i++){
                for (int j=0; j<=i; j++){
                    fileWriter.write("*");
                }
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.format("Dosya Oluşturulmuştur.\nDosyanın Konumu: " +f.getAbsolutePath());

    }

    @GetMapping("/soru7_obeb-okek-hesabı")

    public String hesap(@RequestParam(value = "Sayı 1'i giriniz", defaultValue = "1") Integer sayi1,
                        @RequestParam(value = "Sayı 2'yi giriniz", defaultValue = "1") Integer sayi2) {

        int ebob = 1;
        int okek;
        int min = (sayi1 < sayi2) ? sayi1 : sayi2;
        for (int i = min; i > 0; i++) {
            if ((sayi1 % i == 0) && (sayi2 % i == 0)) {
                ebob = i;
                break;
            }
        }
        okek = (sayi1 * sayi2) / ebob;

        return (sayi1 + " ve " + sayi2 + " Sayılarının Ebob'u " + ebob + "\nOkek'i " + okek);
    }

    @GetMapping("/soru8_anagram")

    public String areAnagram(@RequestParam(value = "birinci kelime(Türkçe Karakter Kullanmayınız)", defaultValue = "kelime 1") String a,
                           @RequestParam(value = "ikinci kelime(Türkçe Karakter Kullanmayınız)", defaultValue = "kelime 2") String b) {

        String dogruCevap = "Girilen kelimeler anagramdır";
        String yanlisCevap = "Girilen kelimeler anagram değildir";

        int a_length = a.length();
        int b_length = b.length();

        if (a_length != b_length){
            return yanlisCevap;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();

        int[] char_frequencies= new int[26];

        for (int i=0; i<a_length;i++){
            char current_char= a.charAt(i);
            Character.toLowerCase(current_char);
            int index = current_char-'a';
            char_frequencies[index]++;
        }
        for (int i=0; i<b_length;i++){
            char current_char= b.charAt(i);
            int index = current_char-'a';
            char_frequencies[index]--;
        }
        for (int i=0; i<26;i++){
            if (char_frequencies[i]!=0){
                return yanlisCevap;
            }
        }
        return dogruCevap;
    }


}
