package tp_trans_donnee_securite_info;


import java.util.Scanner;

public class GenerateurCles {
    public static int[] generateKeys(int K, int H, int shiftLeft, int shiftRight) {
        int k1_ = K & 240;
        int k2_ = K & 15;
        int k1 = (k1_ ^ k2_) << shiftLeft;
        int k2 = (k2_ & k1_) >> shiftRight;
        return new int[] {k1, k2};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the key K (8 bits): ");
        int K = scanner.nextInt();
        System.out.print("Enter the permutation H: ");
        int H = scanner.nextInt();
        System.out.print("Enter the shift left: ");
        int shiftLeft = scanner.nextInt();
        System.out.print("Enter the shift right: ");
        int shiftRight = scanner.nextInt();
        int[] keys = generateKeys(K, H, shiftLeft, shiftRight);
        System.out.println("k1: " + Integer.toBinaryString(keys[0]));
        System.out.println("k2: " + Integer.toBinaryString(keys[1]));
        scanner.close();
    }
}


/*package keygenerator;

public class GenerateurCles {
    
    public static int[] generateKeys(int K, int permutation, int shiftLeft, int shiftRight) {
        int k1_ = K & 240;
        int k2_ = K & 15;
        int k1 = (k1_ ^ k2_) << shiftLeft;
        int k2 = (k2_ & k1_) >> shiftRight;
        return new int[] {k1, k2};
    }

    public static void main(String[] args) {
        int K = 109;
        int permutation = 65274130;
        int shiftLeft = 2;
        int shiftRight = 1;
        
        int[] keys = generateKeys(K, permutation, shiftLeft, shiftRight);
        
        
        System.out.println("k1 " +  Integer.toBinaryString(keys[0]));
        System.out.println("k2 " + Integer.toBinaryString(keys[1]));
    }
}
*/