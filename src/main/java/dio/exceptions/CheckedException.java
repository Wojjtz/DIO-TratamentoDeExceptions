package dio.exceptions;

import javax.swing.*;
import java.io.*;
import java.nio.Buffer;

//Imprimir um arquivo no console.
public class CheckedException {
    public static void main(String[] args) {
        String nomeArquivo = "agentes-r6siege.txt";

        try{
            imprimirArquivoNoConsole(nomeArquivo);
        }catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null,
                    "Reviso o nome do arquivo.");
            e.printStackTrace();
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro inesperado!");
        }finally {
            System.out.println("chegou no finally");
        }
        System.out.println("código continua...");
    }

    public static void imprimirArquivoNoConsole(String nomeArquivo) throws IOException {
        File file = new File(nomeArquivo);

        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        }while (line != null);

        bw.flush();
        br.close();
    }
}
