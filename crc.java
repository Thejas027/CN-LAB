import java.util.Scanner;

public class crc {
    public static String divide(char[] dividend, char[] divisor) {
        int n = dividend.length, m = divisor.length;

        for (int i = 0; i <= n - m; i++) {
            if (dividend[i] == '1') {
                for (int j = 0; j < m; j++) {
                    dividend[i + j] = (dividend[i + j] == divisor[j]) ? '0' : '1'; // Correct XOR operation
                }
            }
        }

        return new String(dividend, n - (m - 1), m - 1);
    }

    public static String encode(String data, String key) {
        String appendedData = data + "0".repeat(key.length() - 1);
        String remainder = divide(appendedData.toCharArray(), key.toCharArray());
        return data + remainder;
    }

    public static boolean decode(String encodedData, String key) {
        return divide(encodedData.toCharArray(), key.toCharArray()).matches("0*");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary key: ");
        String key = sc.next();
        System.out.print("Enter binary data: ");
        String data = sc.next();

        // Encoding
        String encodedData = encode(data, key);
        System.out.println("Encoded data: " + encodedData);

        // Decoding
        System.out.print("Enter received binary encoded data: ");
        String receivedData = sc.next();
        System.out.println(decode(receivedData, key) ? "Data is error free" : "Error in the data");

        sc.close();
    }
}
