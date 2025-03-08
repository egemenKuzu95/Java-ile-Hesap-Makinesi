import java.util.Scanner;

public class HesapMakinesi {
    // Temel Aritmetik İşlemler (2 sayı ile)
    public static double topla(double a, double b) {
        return a + b;
    }
    public static double cikar(double a, double b) {
        return a - b;
    }
    public static double carp(double a, double b) {
        return a * b;
    }
    public static double bol(double a, double b) {
        if(b == 0) {
            throw new ArithmeticException("Sıfıra bölme hatası!");
        }
        return a / b;
    }
    public static int modAl(int a, int b) {
        if(b == 0) {
            throw new ArithmeticException("Sıfıra bölme hatası!");
        }
        return a % b;
    }
    public static double usAl(double taban, double us) {
        return Math.pow(taban, us);
    }

    // İleri Matematik İşlemleri
    public static double karekok(double a) {
        if(a < 0) {
            throw new ArithmeticException("Negatif sayıların karekökü alınamaz!");
        }
        return Math.sqrt(a);
    }
    public static double mutlak(double a) {
        return Math.abs(a);
    }
    public static double dogalLog(double a) {
        if(a <= 0) {
            throw new ArithmeticException("Pozitif olmayan sayıların logaritması alınamaz!");
        }
        return Math.log(a);
    }
    public static double log10(double a) {
        if(a <= 0) {
            throw new ArithmeticException("Pozitif olmayan sayıların logaritması alınamaz!");
        }
        return Math.log10(a);
    }
    public static double usFonk(double a) {
        return Math.exp(a);
    }

    // Trigonometrik ve Hiperbolik Fonksiyonlar
    public static double sin(double aciDerece) {
        return Math.sin(Math.toRadians(aciDerece));
    }
    public static double cos(double aciDerece) {
        return Math.cos(Math.toRadians(aciDerece));
    }
    public static double tan(double aciDerece) {
        return Math.tan(Math.toRadians(aciDerece));
    }
    public static double asin(double deger) {
        if(deger < -1 || deger > 1) {
            throw new ArithmeticException("Arcsin için değer [-1, 1] aralığında olmalıdır!");
        }
        return Math.toDegrees(Math.asin(deger));
    }
    public static double acos(double deger) {
        if(deger < -1 || deger > 1) {
            throw new ArithmeticException("Arccos için değer [-1, 1] aralığında olmalıdır!");
        }
        return Math.toDegrees(Math.acos(deger));
    }
    public static double atan(double deger) {
        return Math.toDegrees(Math.atan(deger));
    }
    public static double sinh(double deger) {
        return Math.sinh(deger);
    }
    public static double cosh(double deger) {
        return Math.cosh(deger);
    }
    public static double tanh(double deger) {
        return Math.tanh(deger);
    }

    // Kombinatorik İşlemler
    public static long faktoriyel(int n) {
        if(n < 0) {
            throw new ArithmeticException("Negatif sayıların faktöriyeli alınamaz!");
        }
        long sonuc = 1;
        for(int i = 2; i <= n; i++) {
            sonuc *= i;
        }
        return sonuc;
    }
    public static long permutasyon(int n, int r) {
        if(n < 0 || r < 0 || r > n) {
            throw new ArithmeticException("Geçersiz değerler! n ve r pozitif olmalı ve r <= n olmalıdır.");
        }
        long sonuc = 1;
        for(int i = 0; i < r; i++) {
            sonuc *= (n - i);
        }
        return sonuc;
    }
    public static long kombinasyon(int n, int r) {
        if(n < 0 || r < 0 || r > n) {
            throw new ArithmeticException("Geçersiz değerler! n ve r pozitif olmalı ve r <= n olmalıdır.");
        }
        return faktoriyel(n) / (faktoriyel(r) * faktoriyel(n - r));
    }

    // Sonsuz Sayı İşlemleri: Kullanıcı belirttiği kadar sayı ile işlem yapar.
    private static void sonsuzSayiIslemleri(Scanner scanner) {
        System.out.println("\n--- Sonsuz Sayı İşlemleri ---");
        System.out.println("1. Toplama");
        System.out.println("2. Çıkarma (ilk sayıdan sonrakileri çıkarır)");
        System.out.println("3. Çarpma");
        System.out.println("4. Bölme (ilk sayıyı sonrakilere böler)");
        System.out.print("Seçiminiz: ");
        int secim = scanner.nextInt();

        System.out.print("Kaç adet sayı gireceksiniz? ");
        int adet = scanner.nextInt();
        if (adet < 1) {
            System.out.println("En az bir sayı girmelisiniz.");
            return;
        }
        double result;
        switch(secim) {
            case 1: // Toplama
                result = 0;
                for (int i = 1; i <= adet; i++) {
                    System.out.print(i + ". sayı: ");
                    double num = scanner.nextDouble();
                    result += num;
                }
                System.out.println("Sonuç: " + result);
                break;
            case 2: // Çıkarma: İlk sayıdan başlayıp diğerlerini çıkartır
                System.out.print("1. sayı: ");
                result = scanner.nextDouble();
                for (int i = 2; i <= adet; i++) {
                    System.out.print(i + ". sayı: ");
                    double num = scanner.nextDouble();
                    result -= num;
                }
                System.out.println("Sonuç: " + result);
                break;
            case 3: // Çarpma
                result = 1;
                for (int i = 1; i <= adet; i++) {
                    System.out.print(i + ". sayı: ");
                    double num = scanner.nextDouble();
                    result *= num;
                }
                System.out.println("Sonuç: " + result);
                break;
            case 4: // Bölme: İlk sayıyı alıp diğerleriyle bölme işlemi yapar
                System.out.print("1. sayı: ");
                result = scanner.nextDouble();
                for (int i = 2; i <= adet; i++) {
                    System.out.print(i + ". sayı: ");
                    double num = scanner.nextDouble();
                    if(num == 0) {
                        System.out.println("Sıfıra bölme hatası!");
                        return;
                    }
                    result /= num;
                }
                System.out.println("Sonuç: " + result);
                break;
            default:
                System.out.println("Geçersiz seçim.");
        }
    }

    // Temel Aritmetik İşlemler menüsü (2 sayı ile)
    private static void temelAritmetik(Scanner scanner) {
        System.out.println("\n--- Temel Aritmetik İşlemler ---");
        System.out.println("1. Toplama");
        System.out.println("2. Çıkarma");
        System.out.println("3. Çarpma");
        System.out.println("4. Bölme");
        System.out.println("5. Mod Alma");
        System.out.println("6. Üs Alma");
        System.out.print("Seçiminiz: ");

        int secim = scanner.nextInt();
        System.out.print("Birinci sayı: ");
        double sayi1 = scanner.nextDouble();
        System.out.print("İkinci sayı: ");
        double sayi2 = scanner.nextDouble();

        switch(secim) {
            case 1:
                System.out.println("Sonuç: " + topla(sayi1, sayi2));
                break;
            case 2:
                System.out.println("Sonuç: " + cikar(sayi1, sayi2));
                break;
            case 3:
                System.out.println("Sonuç: " + carp(sayi1, sayi2));
                break;
            case 4:
                System.out.println("Sonuç: " + bol(sayi1, sayi2));
                break;
            case 5:
                System.out.println("Sonuç: " + modAl((int)sayi1, (int)sayi2));
                break;
            case 6:
                System.out.println("Sonuç: " + usAl(sayi1, sayi2));
                break;
            default:
                System.out.println("Geçersiz seçim.");
        }
    }

    // İleri Matematik İşlemleri menüsü
    private static void ileriMatematik(Scanner scanner) {
        System.out.println("\n--- İleri Matematik İşlemleri ---");
        System.out.println("1. Karekök");
        System.out.println("2. Mutlak Değer");
        System.out.println("3. Doğal Logaritma");
        System.out.println("4. Logaritma (Taban 10)");
        System.out.println("5. Üstel Fonksiyon");
        System.out.println("6. Trigonometrik ve Hiperbolik Fonksiyonlar");
        System.out.print("Seçiminiz: ");

        int secim = scanner.nextInt();
        if(secim >= 1 && secim <= 5) {
            System.out.print("Sayı: ");
            double deger = scanner.nextDouble();
            switch(secim) {
                case 1:
                    System.out.println("Sonuç: " + karekok(deger));
                    break;
                case 2:
                    System.out.println("Sonuç: " + mutlak(deger));
                    break;
                case 3:
                    System.out.println("Sonuç: " + dogalLog(deger));
                    break;
                case 4:
                    System.out.println("Sonuç: " + log10(deger));
                    break;
                case 5:
                    System.out.println("Sonuç: " + usFonk(deger));
                    break;
            }
        } else if(secim == 6) {
            System.out.println("\n--- Trigonometrik ve Hiperbolik Fonksiyonlar ---");
            System.out.println("1. Sin");
            System.out.println("2. Cos");
            System.out.println("3. Tan");
            System.out.println("4. Arcsin");
            System.out.println("5. Arccos");
            System.out.println("6. Arctan");
            System.out.println("7. Sinh");
            System.out.println("8. Cosh");
            System.out.println("9. Tanh");
            System.out.print("Seçiminiz: ");

            int trigSecim = scanner.nextInt();
            System.out.print("Değer (derece ya da sayı): ");
            double deger = scanner.nextDouble();

            switch(trigSecim) {
                case 1:
                    System.out.println("Sonuç: " + sin(deger));
                    break;
                case 2:
                    System.out.println("Sonuç: " + cos(deger));
                    break;
                case 3:
                    System.out.println("Sonuç: " + tan(deger));
                    break;
                case 4:
                    System.out.println("Sonuç: " + asin(deger));
                    break;
                case 5:
                    System.out.println("Sonuç: " + acos(deger));
                    break;
                case 6:
                    System.out.println("Sonuç: " + atan(deger));
                    break;
                case 7:
                    System.out.println("Sonuç: " + sinh(deger));
                    break;
                case 8:
                    System.out.println("Sonuç: " + cosh(deger));
                    break;
                case 9:
                    System.out.println("Sonuç: " + tanh(deger));
                    break;
                default:
                    System.out.println("Geçersiz seçim.");
            }
        } else {
            System.out.println("Geçersiz seçim.");
        }
    }

    // Kombinatorik İşlemler menüsü
    private static void kombinatorikIslemler(Scanner scanner) {
        System.out.println("\n--- Kombinatorik İşlemler ---");
        System.out.println("1. Faktöriyel");
        System.out.println("2. Permütasyon");
        System.out.println("3. Kombinasyon");
        System.out.print("Seçiminiz: ");

        int secim = scanner.nextInt();
        switch(secim) {
            case 1:
                System.out.print("Sayı (n): ");
                int n = scanner.nextInt();
                System.out.println("Sonuç: " + faktoriyel(n));
                break;
            case 2:
                System.out.print("n değeri: ");
                int nP = scanner.nextInt();
                System.out.print("r değeri: ");
                int rP = scanner.nextInt();
                System.out.println("Sonuç: " + permutasyon(nP, rP));
                break;
            case 3:
                System.out.print("n değeri: ");
                int nC = scanner.nextInt();
                System.out.print("r değeri: ");
                int rC = scanner.nextInt();
                System.out.println("Sonuç: " + kombinasyon(nC, rC));
                break;
            default:
                System.out.println("Geçersiz seçim.");
        }
    }

    // Ana menü
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8"); // Türkçe karakter desteği
        while(true) {
            System.out.println("\n=== Hesap Makinesi ===");
            System.out.println("1. Temel Aritmetik İşlemler (2 sayı)");
            System.out.println("2. İleri Matematik İşlemleri");
            System.out.println("3. Kombinatorik İşlemler");
            System.out.println("4. Sonsuz Sayı İşlemleri");
            System.out.println("5. Çıkış");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();

            try {
                switch(secim) {
                    case 1:
                        temelAritmetik(scanner);
                        break;
                    case 2:
                        ileriMatematik(scanner);
                        break;
                    case 3:
                        kombinatorikIslemler(scanner);
                        break;
                    case 4:
                        sonsuzSayiIslemleri(scanner);
                        break;
                    case 5:
                        System.out.println("Programdan çıkılıyor...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Geçersiz seçim, lütfen tekrar deneyiniz.");
                }
            } catch(ArithmeticException ex) {
                System.out.println("Hata: " + ex.getMessage());
            } catch(Exception ex) {
                System.out.println("Beklenmeyen bir hata oluştu: " + ex.getMessage());
                scanner.nextLine();
            }
        }
    }
}

/*
AÇIKLAMALAR:
Bu program, kullanıcı tarafından girilen verilerle çeşitli matematiksel işlemleri gerçekleştiren kapsamlı bir hesap makinesidir.
1. Temel Aritmetik, İleri Matematik ve Kombinatorik işlemler; ayrıca kullanıcı belirttiği kadar sayı ile (sonsuz sayı işlemleri) işlem yapabilme özelliği tek bir sınıf içinde tanımlanmıştır.
2. Sonsuz Sayı İşlemleri bölümünde, kullanıcı toplama, çıkarma, çarpma veya bölme işlemleri için önce kaç sayı gireceğini belirler, ardından her sayı sırasıyla girilerek işlem gerçekleştirilir.
3. Hata yönetimi, sıfıra bölme ve geçersiz giriş durumlarında uygun istisnalarla sağlanmıştır.
4. Kod, modüler yapıda olup ileride ek matematiksel işlemler eklenebilir.
*/
