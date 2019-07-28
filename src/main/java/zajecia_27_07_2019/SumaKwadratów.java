package zajecia_27_07_2019;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumaKwadratów {

    public static boolean isPrime(int liczba) {
        if (liczba < 2) {
            return false;
        } else {
            for (int i = 2; i <= liczba / 2; i++) {
                int reszta = liczba % i;
                if (reszta == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static List<Integer> liczby() {
        List<Integer> result;
        result = IntStream.range(201, 1200).boxed()
                .filter((n -> isPrime(n)))
                .map((n-> n*n))


                .collect(Collectors.toList());
        return result;
    }

    public static void main(String[] args) {
        System.out.println(liczby());
    }

}
