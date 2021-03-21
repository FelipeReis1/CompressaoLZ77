/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciocompressaolz77;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Felipe
 */
public class Compressao {
    
    String str;
    StringBuffer sb = new StringBuffer();
    String aux;
    int aux2;
    int tamanhoOffset;
    int tamanhoBuffer;

    public Compressao(String str, int tamanhoOffset, int tamanhoBuffer) {
       this.str = str;
       this.tamanhoOffset = tamanhoOffset;
       this.tamanhoBuffer = tamanhoBuffer;
    }
    

 
    public void leituraTxt() throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(this.str))) {
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            this.aux = sb.substring(0);
        }    
    }   
    
    
   public String comprime(){
        String resultado = new String();
        int i = 0;
        int offsetInicial;
        String offset;
        String buffer;
        ArrayList<String> armazenaString = new ArrayList<>();       
        while(i<this.aux.length()){
            offsetInicial = i - this.tamanhoOffset;
            if(offsetInicial < 0){
                offsetInicial = 0;
            }
            offset= aux.substring(offsetInicial, i);
            buffer = aux.substring(i, i+ this.tamanhoBuffer);          
            armazenaString.add("(0,0," + aux.substring(i, i + 1) + ")");
         for (int j = this.tamanhoBuffer; j > 0; j--) {
                String prox;
                int index;
                index = offset.lastIndexOf(buffer.substring(0, j));
                //System.out.print(index);
                if (index >= 0) {
                    prox = "";
                    if (i + this.tamanhoBuffer < aux.length()) {
                        prox = aux.substring(i+j, i+j+1);
                    }            
                    armazenaString.add("(" + (offset.length() - index - 1) + "," + j + "," + prox + ")"); 
                    this.aux2 = j;        
                    break;              
                }               
            }         
            i = i + this.aux2 +1;
            resultado = armazenaString.stream().map(c -> c + ", ").reduce(resultado, String::concat);
        }
        return resultado;
   }   

   public void show(){
         System.out.print(this.comprime() +"\n");
    }
    
}
