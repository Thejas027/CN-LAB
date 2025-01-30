import java.math.BigInteger;
import java.util.*;

public class RSA {
      BigInteger puk, prk, mod;

      void getKeys(int bitLen) {
            Random r = new Random();

            BigInteger p = BigInteger.probablePrime(bitLen, r);
            BigInteger q = BigInteger.probablePrime(bitLen, r);

            mod = p.multiply(q);

            BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

            // Choose public key (puk) such that gcd(puk, phi) == 1
            puk = BigInteger.probablePrime(bitLen / 2, r);

            while (!phi.gcd(puk).equals(BigInteger.ONE) || puk.compareTo(phi) >= 0) {
                  puk = BigInteger.probablePrime(bitLen / 2, r);
            }
            
            // Compute private key (prk)
            prk = puk.modInverse(phi);
      }

      BigInteger encrypt(BigInteger m) {
            return m.modPow(puk, mod);
      }

      BigInteger decrypt(BigInteger c) {
            return c.modPow(prk, mod);
      }

      public static void main(String[] args) {
            RSA r = new RSA();
            r.getKeys(512);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the message to be encrypted: ");

            String message = sc.nextLine();
            BigInteger m = new BigInteger(message.getBytes());

            BigInteger c = r.encrypt(m);
            System.out.println("Encrypted message: " + c.toString());

            BigInteger d = r.decrypt(c);
            System.out.println("Decrypted message: " + new String(d.toByteArray()));
            sc.close();
      }
}
