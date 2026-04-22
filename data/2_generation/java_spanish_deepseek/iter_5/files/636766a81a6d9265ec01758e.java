import java.util.*;

public class PrimeUtil {

    /**
     * Devuelve un número primo que es >= desiredCapacity y muy cercano a desiredCapacity
     * (dentro del 11% si desiredCapacity >= 1000).
     * @param desiredCapacity la capacidad deseada por el usuario.
     * @return la capacidad que se debe utilizar para una tabla hash.
     */
    public static int nextPrime(int desiredCapacity) {
        if (desiredCapacity <= 1) {
            return 2;
        }
        
        int candidate = desiredCapacity;
        while (!isPrime(candidate)) {
            candidate++;
        }
        
        // Verificar si el candidato está dentro del 11% de desiredCapacity si desiredCapacity >= 1000
        if (desiredCapacity >= 1000) {
            int upperBound = (int) (desiredCapacity * 1.11);
            if (candidate > upperBound) {
                candidate = nextPrime(upperBound);
            }
        }
        
        return candidate;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(nextPrime(1000));  // Ejemplo de uso
    }
}