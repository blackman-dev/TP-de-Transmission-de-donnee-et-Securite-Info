/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp_trans_donnee_securite_info.chiffrement;

/**
 * Yengo Nzenge Jeff
 * @author Prince
 */
public class Main {
    
  public static void main(String[] args) {
    //Appelle de la classe Chiffrer Yengo Nzenge Jeff
    Chiffrer chiffrer = new Chiffrer();
    
    int[] N = {0, 1, 1, 0, 0, 1, 1, 1};
    int[] chiff = chiffrer.encrypt(N);
    System.out.print("message chiffré : ");
    for (int i = 0; i < chiff.length; i++) {
      System.out.print(chiff[i] + " ");
    }
     System.out.println("");
  }
}
    
    