/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import java.io.*;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author 11914184
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int contador = 0, contador3 = 0, contador2, posicao_menor = 0;
            String nome_menor = "", nome_atual = "", categoria_menor = "", categoria_atual = "", valor1, valor2;
            Double valor3, valor4, avaliacao_atual = 0.0, avaliacao_menor = 0.0;
            BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\Mauricio\\Desktop\\atividadeEstruturadados-main\\JavaApplication1\\src\\javaapplication1\\JogosDesordenados.csv"));
            String[] arquivo2;
            ArrayList<item> teste = new ArrayList<item>();
            arquivo2 = arquivo.lines().collect(Collectors.joining(";")).split(";");

            for (int i = 0; i < arquivo2.length; i++) {
                teste.add(new item(arquivo2[i].split(",")[0], arquivo2[i].split(",")[1], parseDouble(arquivo2[i].split(",")[2])));
            }

            while (contador != teste.size()) {
                contador2 = contador + 1;
                posicao_menor = contador;
                while (contador2 != teste.size()) {
                    valor1 = teste.get(contador2).getCategoria();
                    valor2 = teste.get(posicao_menor).getCategoria();
                    if (valor1.compareToIgnoreCase(valor2) < 0) {
                        posicao_menor = contador2;

                        categoria_menor = teste.get(posicao_menor).getCategoria();
                        nome_menor = teste.get(posicao_menor).getJogos();
                        avaliacao_menor = teste.get(posicao_menor).getAvaliacao();
                    }
                    contador2++;
                }
                nome_atual = teste.get(contador).getJogos();
                categoria_atual = teste.get(contador).getCategoria();
                avaliacao_atual = teste.get(contador).getAvaliacao();

                teste.get(contador).setJogos(nome_menor);
                teste.get(contador).setCategoria(categoria_menor);
                teste.get(contador).setAvaliacao(avaliacao_menor);

                teste.get(posicao_menor).setJogos(nome_atual);
                teste.get(posicao_menor).setCategoria(categoria_atual);
                teste.get(posicao_menor).setAvaliacao(avaliacao_atual);
                contador++;
            }

            contador = 0;
            while (contador != teste.size()) {
                contador2 = contador + 1;
                posicao_menor = contador;
                while (contador2 != teste.size()) {
                    if (teste.get(contador2).getCategoria().equals(teste.get(contador).getCategoria())) {
                        valor1 = teste.get(contador2).getJogos();
                        valor2 = teste.get(posicao_menor).getJogos();

                        valor3 = teste.get(contador2).getAvaliacao();
                        valor4 = teste.get(posicao_menor).getAvaliacao();
                        if (valor1.substring(0, 1).compareToIgnoreCase(valor2.substring(0, 1)) < 0) {
                            posicao_menor = contador2;

                            nome_menor = teste.get(posicao_menor).getJogos();
                            avaliacao_menor = teste.get(posicao_menor).getAvaliacao();
                        } else if (valor1.substring(0, 1).equals(valor2.substring(0, 1))) {
                            if (valor3 > valor4) {
                                posicao_menor = contador2;

                                nome_menor = teste.get(posicao_menor).getJogos();
                                avaliacao_menor = teste.get(posicao_menor).getAvaliacao();
                            }
                        }
                    }

                    contador2++;
                }
                nome_atual = teste.get(contador).getJogos();
                avaliacao_atual = teste.get(contador).getAvaliacao();

                teste.get(contador).setJogos(nome_menor);
                teste.get(contador).setAvaliacao(avaliacao_menor);

                teste.get(posicao_menor).setJogos(nome_atual);
                teste.get(posicao_menor).setAvaliacao(avaliacao_atual);

                contador++;
            }

            try (PrintWriter writer = new PrintWriter("C:\\Users\\Mauricio\\Desktop\\atividadeEstruturadados-main\\JavaApplication1\\src\\javaapplication1\\JogosOrdenados.csv")) {
                StringBuilder sb = new StringBuilder();
                while (contador3 != teste.size()) {

                    sb.append(teste.get(contador3).getJogos());
                    sb.append("\t");
                    sb.append(teste.get(contador3).getCategoria());
                    sb.append("\t");
                    sb.append(teste.get(contador3).getAvaliacao());
                    sb.append('\n');

                    contador3++;
                }
                writer.write(sb.toString());
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception teste) {
            System.out.println(teste);
        }
    }
}
