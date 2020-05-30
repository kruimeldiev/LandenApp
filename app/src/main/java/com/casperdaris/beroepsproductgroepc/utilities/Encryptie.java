package com.casperdaris.beroepsproductgroepc.utilities;

public abstract class Encryptie {

    private static int a = 7;  // Moet relatief priem zijn met m, oftewel ggd(a, m) = 1
    private static int k = 0; // Willekeurige verschuiving, heeft geen verdere invloed op de encryptie
    private static int m = 95; // Aantal tekens, 95 in het geval de hele ascii tabel minues de eerste 32 instructies en delete

    private Encryptie() {
    }

    private int ggd(int a, int m) {
        if (m == 0) {
            return a;
        } else {
            return ggd(m, a % m);
        }
    }

    public static String encrypt(String klareTekst) {
        StringBuffer sb = new StringBuffer();
        klareTekst.chars().forEach(t -> {
            t = ((a * (t - 32) + k) % m) + 32;
            char c = (char) t;
            sb.append(c);
        });
        return new String(sb);
    }

    public static String decrypt(String gecijferdeTekst) {
        StringBuffer sb = new StringBuffer();
        gecijferdeTekst.chars().forEach(t -> {
            t = ((68 * (t - 32) - k) % m) + 32;
            char c = (char) t;
            sb.append(c);
        });
        return new String(sb);
    }
}