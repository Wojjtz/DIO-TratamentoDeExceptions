package dio.exceptions;

import javax.swing.*;

public class CustomException_2 {
    public static void main(String[] args) {
        int[] numerador = {4, 5, 8, 10};
        int[] denominador = {2, 4, 0, 2, 8};

        for (int i = 0; i < denominador.length; i++){
            try{
                if(numerador[i] % 2 != 0){
                    throw new DivisaoNaoExatadaException("Divisão não exata!", numerador[i], denominador[i]);
                }
                int resultado = numerador[i] / denominador[i];
                System.out.println(resultado);
            }catch (DivisaoNaoExatadaException | ArithmeticException | ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}

class DivisaoNaoExatadaException extends Exception{
    private int numerador;
    private int denominador;

    public DivisaoNaoExatadaException(String message, int numerador, int denominador) {
        super(message);
        this.numerador = numerador;
        this.denominador = denominador;
    }
}
