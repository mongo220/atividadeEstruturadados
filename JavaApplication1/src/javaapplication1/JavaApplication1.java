/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;
import java.io.*;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author 11914184
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\11914184\\Documents\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\JogosDesordenados.csv"));
            String[] arquivo2;
            ArrayList<item> teste = new ArrayList<item>();
            arquivo2 = arquivo.lines().collect(Collectors.joining(";")).split(";");
            for(int i = 0; i < arquivo2.length; i++){
                teste.add(new item(arquivo2[i].split(",")[0], arquivo2[i].split(",")[1], parseDouble(arquivo2[i].split(",")[2])));
                System.out.println(teste.get(i).getJogos());
            }
        }catch(Exception teste){
            System.out.println(teste);
        }
    }
}
