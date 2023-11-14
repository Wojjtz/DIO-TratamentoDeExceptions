package dio.exceptions;

import javax.swing.*;

public class UncheckedException {
    public static void main(String[] args) {
        String a = JOptionPane.showInputDialog("Numerador: ");
        String b = JOptionPane.showInputDialog("Denominadro: ");

        boolean continueLoop = true;

        do {
            try{
                int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
                System.out.println("Resultador: " + resultado );
                continueLoop = false;
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. " +
                        "\nInforme apenas números inteiros.");
                e.printStackTrace();
            }catch (ArithmeticException e){
                JOptionPane.showMessageDialog(null, "Impossível dividir por zero.");
                e.printStackTrace();

            }finally {
                System.out.println("chegou no finally");
            }
        }while(continueLoop);


        System.out.println("código continua");
    }

    public static int dividir(int a, int b) { return a / b; }
}
