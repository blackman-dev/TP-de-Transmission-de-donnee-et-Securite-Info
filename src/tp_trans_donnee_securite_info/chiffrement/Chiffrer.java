package tp_trans_donnee_securite_info.chiffrement;

public class Chiffrer {
   
  private int[] pi = {4, 6, 0, 2, 7, 3, 1, 5};
  private int[] pi_inv = {3, 0, 2, 4, 6, 1, 7, 5};
  private int[] P = {2, 0, 1, 3};
  private int[] keys = {1, 2};
  
  public int[] encrypt(int[] N) {
    int[] C = new int[8];
    
    // Step 2: permutation de pi
    int[] N_permutation = applicationPermutation(N, pi);
    
    // Step 3: Divide N par 2 et en 4bit 
    int[] G0 = new int[4];
    int[] D0 = new int[4];
    System.arraycopy(N_permutation, 0, G0, 0, 4);
    System.arraycopy(N_permutation, 4, D0, 0, 4);
    
  
    int[] G1 = xor(applicationPermutation(G0, P), intToBinary(keys[0], 4));
    int[] D1 = xor(G0, or(G0, intToBinary(keys[0], 4)));
    
    
    int[] G2 = xor(applicationPermutation(G1, P), intToBinary(keys[1], 4));
    int[] D2 = xor(G1, or(G1, intToBinary(keys[1], 4)));
    
    // Concatenation de G2 et D2
    System.arraycopy(G2, 0, C, 0, 4);
    System.arraycopy(D2, 0, C, 4, 4);
    
    // Step 7: inverse permutation de pi_inv
    C = applicationPermutation(C, pi_inv);
    
    return C;
  }
  
  private int[] applicationPermutation(int[] N, int[] permutation) {
    int[] permutiont = new int[N.length];
    for (int i = 0; i < permutation.length; i++) {
      permutiont[i] = N[permutation[i]];
    }
    return permutiont;
  }
  
  private int[] xor(int[] a, int[] b) {
    int[] resultat = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      resultat[i] = a[i] ^ b[i];
    }
    return resultat;
  }
  
  private int[] or(int[] a, int[] b) {
    int[] resultat = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      resultat[i] = a[i] | b[i];
    }
    return resultat;
  }
  
  private int[] intToBinary(int n, int numBits) {
    int[] binaire = new int[numBits];
    for (int i = 0; i < numBits; i++) {
      binaire[numBits - 1 - i] = n & 1;
      n = n ;
      n = n >> 1;
    }
    return binaire;
  }
}

 

 

