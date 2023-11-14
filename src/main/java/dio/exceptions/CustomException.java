package dio.exceptions;

import jdk.jshell.spi.ExecutionControlProvider;

import javax.swing.*;
import java.io.*;
import java.nio.Buffer;

//Imprimir um arquivo no console.
public class CustomException {
    public static void main(String[] args) {
        String nomeArquivo = JOptionPane.showInputDialog("Nome do arquivo a ser exibido: ");
        imprimirArquivoNoConsole(nomeArquivo);

        System.out.println("código continua...");
    }

    public static void imprimirArquivoNoConsole(String nomeArquivo) {

        try{
            BufferedReader br = lerArquivo(nomeArquivo);
            String line = br.readLine();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            do {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            }while (line != null);

            bw.flush();
            br.close();
        }catch (ImpossivelAbrirArquivoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro inesperado.");
            e.printStackTrace();
        }
    }

    public static BufferedReader lerArquivo(String nomeArquivo) throws ImpossivelAbrirArquivoException {
        File file = new File(nomeArquivo);

        try {
            return new BufferedReader(new FileReader(file.getName()));
        } catch (FileNotFoundException e) {
            throw new ImpossivelAbrirArquivoException(file.getName(), file.getPath());
        }
    }
}

class ImpossivelAbrirArquivoException extends Exception {
    private String nomeArquivo;
    private String diretorio;

    public ImpossivelAbrirArquivoException(String nomeArquivo, String diretorio) {
        super("O arquivo " + nomeArquivo + " não foi encontrado no diretório " + diretorio);
        this.nomeArquivo = nomeArquivo;
        this.diretorio = diretorio;
    }

    @Override
    public String toString() {
        return "ImpossivelAbrirArquivoException{" +
                "nomeArquivo='" + nomeArquivo + '\'' +
                ", diretorio='" + diretorio + '\'' +
                '}';
    }
}
