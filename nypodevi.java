package com.mycompany.nypodev5;

import java.util.Scanner;

class nokta {

    private int x;
    private int y;

    public nokta(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setx(int x) {
        this.x = x;
    }

    public void sety(int y) {
        this.y = y;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

}

class dortgen {

    nokta n1, n2, n3, n4;

    public dortgen(nokta n1, nokta n2, nokta n3, nokta n4) {
        this.n1 = new nokta(n1.getx(), n1.gety());
        this.n2 = new nokta(n2.getx(), n2.gety());
        this.n3 = new nokta(n3.getx(), n3.gety());
        this.n4 = new nokta(n4.getx(), n4.gety());
    }
}

class kare extends dortgen {

    public kare(nokta n1, nokta n2, nokta n3, nokta n4) {
        super(n1, n2, n3, n4);
    }

    public int alanhesapla() {
        int a = Math.abs(n1.getx() - n2.getx());
        int b = Math.abs(n1.getx() - n3.getx());
        if (a > b) {
            return a * a;
        } else {
            return b * b;
        }
    }

}

class dikdortgen extends dortgen {

    int k;
    int y;
    int a;
    int b;

    public dikdortgen(nokta n1, nokta n2, nokta n3, nokta n4) {
        super(n1, n2, n3, n4);
    }

    public int alanhesapla() {
        int kenar1;
        k = (int) Math.abs(n2.getx() - n1.getx());
        y = (int) Math.abs(n2.gety() - n1.gety());
        if (k > y) {
            kenar1 = k;
        } else {
            kenar1 = y;
        }

        a = (int) Math.abs((n3.getx() - n1.getx()));
        b = (int) Math.abs((n3.gety() - n1.gety()));
        int kenar2;
        if (a > b) {
            kenar2 = a;
        } else {
            kenar2 = b;
        }
        return kenar1 * kenar2;
    }
}

class yamuk extends dortgen {

    public yamuk(nokta n1, nokta n2, nokta n3, nokta n4) {
        super(n1, n2, n3, n4);
    }

    public double alanhesapla() {
        double kenar1 = 0.0;
        double kenar2 = 0.0;
        double tutucu = 1.0;
        double yukseklik = 0.0;
        double alan;
        if (n2.gety() - n1.gety() == 0) {
            kenar1 = (double) Math.abs(n2.getx() - n1.getx());
            tutucu = n2.gety();
        } else if (n3.gety() - n1.gety() == 0) {
            kenar1 = (double) Math.abs(n3.getx() - n1.getx());
            tutucu = n3.gety();
        } else if (n4.gety() - n1.gety() == 0) {
            kenar1 = (double) Math.abs(n4.getx() - n1.getx());
            tutucu = n4.gety();
        }
        if (n4.gety() - n3.gety() == 0 && n4.gety() - n3.gety() != tutucu) {
            kenar2 = (double) Math.abs(n4.getx() - n3.getx());
        } else if (n2.gety() - n3.gety() == 0 && n2.gety() - n3.gety() != tutucu) {
            kenar2 = (double) Math.abs(n2.getx() - n3.getx());
        } else if (n1.gety() - n3.gety() == 0 && n1.gety() - n3.gety() != tutucu) {
            kenar2 = (double) Math.abs(n1.getx() - n3.getx());
        }
        if (n1.gety() - n2.gety() != 0) {
            yukseklik = Math.abs(n1.gety() - n2.gety());
        } else if (n1.gety() - n3.gety() != 0) {
            yukseklik = Math.abs(n1.gety() - n3.gety());
        }
        if (n1.gety() - n4.gety() != 0) {
            yukseklik = Math.abs(n1.gety() - n4.gety());
        }
        alan = ((kenar1 + kenar2) * yukseklik) / 2;
        return alan;
    }

}

class paralelkenar extends dortgen {

    public paralelkenar(nokta n1, nokta n2, nokta n3, nokta n4) {
        super(n1, n2, n3, n4);
    }

    public double alanhesapla() {
        double kenar1 = 0;
        double kenar2 = 0;
        double yukseklik = 0;
        if (n4.gety() - n1.gety() == 0) {
            kenar1 = Math.abs(n4.getx() - n1.getx());
            yukseklik = Math.abs(n3.gety() - n1.gety());
        } else if (n3.gety() - n1.gety() == 0) {
            kenar1 = Math.abs(n3.getx() - n1.getx());
            yukseklik = Math.abs(n2.gety() - n1.gety());
        } else if (n2.gety() - n1.gety() == 0) {
            kenar1 = Math.abs(n2.getx() - n1.getx());
            yukseklik = Math.abs(n3.gety() - n1.gety());
        }
        double alan = kenar1 * yukseklik;
        return alan;
    }
}

public class alanhesaplama {

    public static void main(String[] args) {
        String s1 = "kare";
        String s2 = "Kare";
        String s3 = "Dikdörtgen";
        String s4 = "dikdörtgen";
        String s5 = "Yamuk";
        String s6 = "yamuk";
        String s7 = "Paralelkenar";
        String s8 = "paralelkenar";
        String s9= "cikis";
        Scanner tara = new Scanner(System.in);
        String secim = "";
        System.out.println("Hangi şeklin alanını hesaplamak istiyorsunuz ? ");
        System.out.println("seçenekler : kare , yamuk , paralelkenar , dikdörtgen, cikis ");
        System.out.println("Lütfen seçiminizi seçeneklerde gösterildiği şekilde 'STRİNG' olarak giriniz ");
        System.out.println("------------------------====================---------------------");
        secim = tara.nextLine();;
        System.out.println(secim);
        while(secim.equals(s9)!= true){
        if (secim.equals(s1) || secim.equals(s2)) {
            nokta n1 = new nokta(1, 2);
            nokta n2 = new nokta(1, 2);
            nokta n3 = new nokta(1, 2);
            nokta n4 = new nokta(1, 2);
            System.out.println("1. Noktanın koordinatlarını SAYILAR ARASINDA BİR BOŞLUK BIRAKARAK giriniz (ornek: 1  5) : ");
            n1.setx(tara.nextInt());
            n1.sety(tara.nextInt());
            System.out.println("2. Noktanın koordinatlarını SAYILAR ARASINDA BİR BOŞLUK BIRAKARAK giriniz (ornek: 1  5) : ");
            n2.setx(tara.nextInt());
            n2.sety(tara.nextInt());
            System.out.println("3. Noktanın koordinatlarını SAYILAR ARASINDA BİR BOŞLUK BIRAKARAK giriniz (ornek: 1  5) : ");
            n3.setx(tara.nextInt());
            n3.sety(tara.nextInt());
            System.out.println("4. Noktanın koordinatlarını SAYILAR ARASINDA BİR BOŞLUK BIRAKARAK giriniz (ornek: 1  5) : ");
            n4.setx(tara.nextInt());
            n4.sety(tara.nextInt());
            kare k1 = new kare(n1, n2, n3, n4);
            System.out.println("Karenin alanı :  " + k1.alanhesapla() + " olarak hesaplandı");
        } else if (secim.equals(s5) || secim.equals(s6)) {
            nokta n1 = new nokta(1, 2);
            nokta n2 = new nokta(1, 2);
            nokta n3 = new nokta(1, 2);
            nokta n4 = new nokta(1, 2);
            System.out.println("1. Noktanın koordinatlarını SAYILAR ARASINDA BİR BOŞLUK BIRAKARAK giriniz (ornek: 1  5) : ");
            n1.setx(tara.nextInt());
            n1.sety(tara.nextInt());
            System.out.println("2. Noktanın koordinatlarını SAYILAR ARASINDA BİR BOŞLUK BIRAKARAK giriniz (ornek: 1  5) : ");
            n2.setx(tara.nextInt());
            n2.sety(tara.nextInt());
            System.out.println("3. Noktanın koordinatlarını SAYILAR ARASINDA BİR BOŞLUK BIRAKARAK giriniz (ornek: 1  5) : ");
            n3.setx(tara.nextInt());
            n3.sety(tara.nextInt());
            System.out.println("4. Noktanın koordinatlarını SAYILAR ARASINDA BİR BOŞLUK BIRAKARAK giriniz (ornek: 1  5) : ");
            n4.setx(tara.nextInt());
            n4.sety(tara.nextInt());
            yamuk k1 = new yamuk(n1, n2, n3, n4);
            System.out.println("Yamuğun alanı :  " + k1.alanhesapla() + " olarak hesaplandı");
        } 
        else if (secim.equals(s3) || secim.equals(s4)) {
            nokta n1 = new nokta(1, 2);
            nokta n2 = new nokta(1, 2);
            nokta n3 = new nokta(1, 2);
            nokta n4 = new nokta(1, 2);
            System.out.println("1. Noktanın koordinatlarını SAYILAR ARASINDA BİR BOŞLUK BIRAKARAK giriniz (ornek: 1  5) : ");
            n1.setx(tara.nextInt());
            n1.sety(tara.nextInt());
            System.out.println("2. Noktanın koordinatlarını SAYILAR ARASINDA BİR BOŞLUK BIRAKARAK giriniz (ornek: 1  5) : ");
            n2.setx(tara.nextInt());
            n2.sety(tara.nextInt());
            System.out.println("3. Noktanın koordinatlarını SAYILAR ARASINDA BİR BOŞLUK BIRAKARAK giriniz (ornek: 1  5) : ");
            n3.setx(tara.nextInt());
            n3.sety(tara.nextInt());
            System.out.println("4. Noktanın koordinatlarını SAYILAR ARASINDA BİR BOŞLUK BIRAKARAK giriniz (ornek: 1  5) : ");
            n4.setx(tara.nextInt());
            n4.sety(tara.nextInt());
            dikdortgen k1 = new dikdortgen(n1, n2, n3, n4);
            System.out.println("Dikdörtgenin alanı :  " + k1.alanhesapla() + " olarak hesaplandı");
        }
        
         else if (secim.equals(s7) || secim.equals(s8)) {
            nokta n1 = new nokta(1, 2);
            nokta n2 = new nokta(1, 2);
            nokta n3 = new nokta(1, 2);
            nokta n4 = new nokta(1, 2);
            System.out.println("1. Noktanın koordinatlarını SAYILAR ARASINDA BİR BOŞLUK BIRAKARAK giriniz (ornek: 1  5) : ");
            n1.setx(tara.nextInt());
            n1.sety(tara.nextInt());
            System.out.println("2. Noktanın koordinatlarını SAYILAR ARASINDA BİR BOŞLUK BIRAKARAK giriniz (ornek: 1  5) : ");
            n2.setx(tara.nextInt());
            n2.sety(tara.nextInt());
            System.out.println("3. Noktanın koordinatlarını SAYILAR ARASINDA BİR BOŞLUK BIRAKARAK giriniz (ornek: 1  5) : ");
            n3.setx(tara.nextInt());
            n3.sety(tara.nextInt());
            System.out.println("4. Noktanın koordinatlarını SAYILAR ARASINDA BİR BOŞLUK BIRAKARAK giriniz (ornek: 1  5) : ");
            n4.setx(tara.nextInt());
            n4.sety(tara.nextInt());
            paralelkenar k1 = new paralelkenar(n1, n2, n3, n4);
            System.out.println("Paralelkenarın alanı :  " + k1.alanhesapla() + " olarak hesaplandı");
        }
    }
    }
}
