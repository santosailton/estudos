// Inicio do Programa

import java.io.*;   // Importa pacote java.io

public class Estatisticas {

    public void Estatisticas(){  };

    public static void main (String[] args) throws IOException { // desconsidera

        String nome_arq_ent="nemo500-270nc.raw";
        String nome_arq_res="Estatisticas.txt";

        FileInputStream arq_ent;  // objetos para arquivo binario
        FileWriter arq_res;  // objeto para arquivo texto

        int nlin=270, ncol =500;

        arq_ent = new FileInputStream(nome_arq_ent);
        arq_res = new FileWriter(nome_arq_res);

//        Calculo da Média
        double media = (double)0;

        for(int l=0; l<nlin; l++)
            for(int c=0; c<ncol; c++)
                media+= (double)arq_ent.read();

        media/=(double)(nlin*ncol);

//        Calculo da Variancia
        arq_ent.close();  // fecha o arquivo
        arq_ent = new FileInputStream(nome_arq_ent); // abre o arquivo para ler dados a partir do inicio

        double variancia = (double)0, valor;

        for(int l=0; l<nlin; l++)
            for(int c=0; c<ncol; c++){
                valor = arq_ent.read();
                variancia+= ((valor-media)*(valor-media));
            }

        variancia/=(double)(nlin*ncol);

//        Calculo da Histograma e Moda

        arq_ent.close();
        arq_ent = new FileInputStream(nome_arq_ent);

        int histo[]= new int[256];

        for(int i=0;i<256;i++) histo[i]=0;

        for(int l=0; l<nlin; l++)
            for(int c=0; c<ncol; c++)
                histo[arq_ent.read()]++;

//        Saida dos dados no Arquivo de Saida

        arq_res.write("Estatisticas do arquivo: "+nome_arq_ent);
        arq_res.write("\n\nNumero de Colunas = "+ncol);
        arq_res.write("\nNumero de Linhas = "+nlin);
        arq_res.write("\nTotal de Pixels = "+nlin*ncol);
        arq_res.write("\nValor Médio = "+media+" ~ "+Math.round(media));
        arq_res.write("\nVariancia = "+variancia);
        arq_res.write("\nDesvio Padrao = "+Math.sqrt(variancia));

        arq_res.write("\nHistograma ");
        int max = 0;
        for(int i=0;i<256;i++){
            arq_res.write("\nFreq["+i+"] = "+histo[i]);
            if(histo[i]>histo[max])max = i;
        }

        arq_res.write("\n\nValor da Moda = "+max);

        arq_res.write("\n\nFim das estatisticas");

        arq_ent.close();
        arq_res.close();

        System.out.println("\nTermino Normal");


    } // end main


}// end class
