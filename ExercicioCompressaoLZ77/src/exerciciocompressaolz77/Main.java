/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciocompressaolz77;

import java.io.IOException;

/**
 *
 * @author Felipe
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
       String caminhoTxt = "teste.txt";
       Compressao compressao =  new Compressao(caminhoTxt, 6, 4);
       compressao.leituraTxt();
       compressao.show();
    }
    
}
    
    

