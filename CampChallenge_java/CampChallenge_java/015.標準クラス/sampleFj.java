/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge8;

/**
 *
 * @author p-user
 */
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class sampleFj {
     public static void main(String[] args) {
            String profile=("私の名前は宮田です");
             // FileWriter fw = null;
            try{ 
             // ファイルオープン
             File fp = new File("C:\\Users\\p-user\\Documents\\NetBeansProjects\\challenge15\\src\\java\\challenge8\\test.txt");
             // FileWriter作成
             FileWriter fw;
             
             fw = new FileWriter(fp);
        
             // 書き込み
             fw.write(profile);
             fw.write("\n犬が好きです");
             // クローズ
             fw.close();
            }catch(IOException e){
            System.out.println(e);
            
            }
         
         }
    }
    
    

