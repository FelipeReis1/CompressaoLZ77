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
    int aux3;
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
            offset = aux.substring(offsetInicial, i);
            if (i + this.tamanhoBuffer < aux.length()) {
                buffer = aux.substring(i, i + this.tamanhoBuffer);
            } else {
                buffer = aux.substring(i, aux.length());
            }       
            String prox;
            int index;
            int tamanhoIndex = 0;
            int maiorIndex = 0;
            
         for (int j = buffer.length(); j > 0; j--) {      
                index = offset.lastIndexOf(buffer.substring(0, j));
                aux3 = offset.length()-index;
                if (index >= 0) {                   
                    tamanhoIndex += j;
                    if(j == buffer.length()){
                        break;
                    }else{
                        this.aux2 = j;
                        for(int k = j; k > 0; k--){
                            int index2 = buffer.substring(aux2, buffer.length()).lastIndexOf(offset.substring(index, index+k));
                            while(index2 == 0){
                                tamanhoIndex += k;
                                aux2 = offset.substring(index, index+k).length();
                                index2 = buffer.substring(aux2, buffer.length()).lastIndexOf(offset.substring(index, index+k));
                            }
                        }
                        break;
                    }                   
                }               
        }
        if(i+ tamanhoIndex < aux.length()){
            prox = aux.substring(i+ tamanhoIndex,i + tamanhoIndex +1);
        }else{
            prox = "null";
        }
        if(tamanhoIndex > 0){
            armazenaString.add("(" + aux3 + "," + tamanhoIndex + "," + prox + ")");
        }else{
            armazenaString.add("(0," + tamanhoIndex + "," + prox + ")");
        }
            i = i + tamanhoIndex +1;
            
        }
        resultado = armazenaString.stream().map(c -> c + ", ").reduce(resultado, String::concat);
        return resultado;
   }   

   public void show(){
         System.out.print(this.comprime() +"\n");
    }
    
}
