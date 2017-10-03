/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge10;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
/**
 *
 * @author p-user
 */
public class sampleHj {
    public static void main(String[] args){
        fiLe fl = new fiLe();
        Time tiMe = new Time();
        File file = new File("C:\\Users\\p-user\\Documents\\NetBeansProjects\\challenge15\\src\\java\\challenge10\\logfile.txt");
       
        System.out.print(fl.cReatefile(file));
        fl.AddedLog(file,tiMe.nowTime()+"ファイル作成終了\n");
        
        
        fl.AddedLog(file,tiMe.nowTime()+"LinkedList配列を2つ作成開始\n");
    LinkedList<String> lk1 = new LinkedList<String>();
    LinkedList<String> lk2 = new LinkedList<String>();
        fl.AddedLog(file,tiMe.nowTime()+"LinkedList配列を2つ作成終了\n");
        fl.AddedLog(file,tiMe.nowTime()+"配列lk1の中身を設定開始\n");
    lk1.add("まらかす");
    lk1.add("たらこ");
    lk1.addFirst("たまご");
        fl.AddedLog(file,tiMe.nowTime()+"配列lk1の中身の設定終了\n");
        fl.AddedLog(file,tiMe.nowTime()+"配列lk2の中身を設定開始\n");
    for(int j=0;j<3;j++){
        lk2.add("犬"+j);
    
    }
        fl.AddedLog(file,tiMe.nowTime()+"配列lk2の中身を設定終了\n");
        fl.AddedLog(file,tiMe.nowTime()+"配列lk1とlk2を連結開始\n");
    lk1.addAll(lk2);
        fl.AddedLog(file,tiMe.nowTime()+"配列lk1とlk2を連結終了\n");
        fl.AddedLog(file,tiMe.nowTime()+"配列の中身を出力して確認開始\n");
    for(int i=0;i<lk1.size();i++){
        fl.AddedLog(file,tiMe.nowTime()+"表示ログ："+lk1.get(i)+"\n");
        System.out.print(lk1.get(i)+"\n");
    
    }
    
    fl.AddedLog(file,tiMe.nowTime()+"配列の中身を出力終了\n");
    fl.AddedLog(file,tiMe.nowTime()+"配列の中身を表示後削除処理開始\n");
    while(lk1.size()!=0){
        fl.AddedLog(file,tiMe.nowTime()+"表示ログ："+lk1.getLast()+"←この要素を削除します\n");
        System.out.print(lk1.pollLast()+"←この要素を削除します\n");
    
    }
    fl.AddedLog(file,tiMe.nowTime()+"配列の中身を表示後削除処理終了\n");
    fl.AddedLog(file,tiMe.nowTime()+"配列の要素の数を表示処理開始\n");
    fl.AddedLog(file,tiMe.nowTime()+"表示ログ："+lk1.size()+"\n");
    System.out.print(lk1.size()+"\n");
    fl.AddedLog(file,tiMe.nowTime()+"配列の要素の数を表示処理終了\n");
    System.out.print("以降logfile内のlogです。以降記録されません。\n");
    fl.outPutallLog(file);
    }
   
    
    
}

class fiLe{
    //ファイルを作るよ！すでにあったら作らないよ！
    String cReatefile(File file){
     Time tiMe = new Time();
         try{
       if(file.createNewFile()){
           AddedLog(file,""+tiMe.nowTime()+"ファイル作成開始\n");
           return "ファイルの作成に成功しました。\n";
       }else{
           //ファイルを初期化するよ！
           newLog(file);
           return "すでにファイルは存在しています。初期化しました。\n";
       }
        }catch(IOException e){
    System.out.println(e);
}
    
      return "異常な返し値です";  
        
    }
    //ファイルにログを書き込むよ！
    void AddedLog(File file,String st){
        
        try{
        FileWriter fw = new FileWriter(file,true);
        fw.write(st);
        fw.close();
        //System.out.print("追記処理確認用（最後に消してね）");
        }catch(IOException e){
        System.out.print(e);
        }
    
    }
   //logfile内のlogを全部表示するよ！
    void outPutallLog(File file){
            try{
        FileReader fr = new FileReader(file);
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
    void newLog(File file){
        try{
        FileWriter fw = new FileWriter(file);
        fw.write("");
        fw.close();
        //System.out.print("追記処理確認用（最後に消してね）");
        }catch(IOException e){
        System.out.print(e);
        }
        
    
    }
}


class Time{
    //日時を文字列で返すよ！
    String nowTime(){
    Date now = new Date();
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年/MM月/dd日 HH時:mm分:ss秒");
    
    return sdf.format(now);
    
    
    }
}

