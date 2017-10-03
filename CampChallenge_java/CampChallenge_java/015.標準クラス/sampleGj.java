/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author p-user
 */
public class sampleGj {
     public static void main(String[] args) {
            //String profile=("私の名前は宮田です");
             // FileWriter fw = null;
            try{ 
             // ファイルオープン
             File fp = new File("C:\\Users\\p-user\\Documents\\NetBeansProjects\\challenge15\\src\\java\\challenge8\\test.txt");
             // FileWriter作成
            //FileReader作成
            FileReader fr = new FileReader(fp);
            // BufferedReader作成
            BufferedReader br = new BufferedReader(fr);
            //元はnullだよ！
            String readtext = null;
            //全部の行出すよ！
            while((readtext=br.readLine())!=null){
            System.out.print(readtext+"\n");
            }
             // クローズ
             fr.close();
            }catch(IOException e){
            System.out.println(e);
            
            }
         
         }
    
    
}
