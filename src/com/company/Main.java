package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;



public class Main {




    public static void main(String[] args) throws IOException {


        System.out.println("");
        FileReader fin = new FileReader("mass.txt");

        int c;
        int number=0;
        boolean ncheck = false;
        ArrayList<Integer> n = new ArrayList<Integer>();
        System.out.println("");
        while ((c = fin.read()) != -1){
            if (c>=48 && c<58){ //проверка соответствуют ли символы юникода цифрам
                number = number*10+Character.getNumericValue((char)c);
                ncheck=true;
            }
            else if(ncheck==true){
                n.add(number);
                number=0;
                ncheck=false;
            }

        }
        if(ncheck==true){
            n.add(number);
            number=0;
            ncheck=false;
        }


        System.out.println("");
        Collections.sort(n);



        FileWriter fw = new FileWriter(new File("mass.txt"));
        for(int i : n){
            fw.write(Integer.toString(i)+(char)13+(char)10);
            fw.flush();
        }
        System.out.println("НЕ ВРИ НЕ Готово!");
    }

}


