/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package challenge2;

/**
 *
 * @author p-user
 */
import java.util.ArrayList;
import java.util.Random;



public class blackjack {
    public static void main(String[] args) {
       
        checkCard Checkcard= new checkCard();
        System.out.print("ブラックジャックを開始します。");
        System.out.print("\n");
        int y=0;
        
        Dealer dealer =new Dealer();
        User user= new User();
        
        
        Game:while (!(dealer.deck.size()<=2)){
            //手札を初期化
       
        dealer.myCard=new ArrayList<String>();
        user.myCard=new ArrayList<String>();
        
        
        System.out.print("カードを配ります");
        System.out.print("\n");
        //停止
         if(dealer.deck.size()<=1){
        
        System.out.print("カードがなくなりました。");
        System.out.print("ブラックジャックを終了します");
        break;
        }
        dealer.setCard(dealer.Deal());
        
        
        y=y+2;
        System.out.print("カードは"+y+"枚消費されています\n");
        //dealer側カードの表示
        for(int i=0;i<dealer.myCard.size();i++){
        System.out.print("dealer:"+dealer.myCard.get(i));
        }
        System.out.print("dealer合計値は"+dealer.open(dealer.myCard)+"です。");
        //停止
         if(dealer.deck.size()<=1){
        
        System.out.print("カードがなくなりました。");
        System.out.print("ブラックジャックを終了します");
        break;
        }
        //player側カード表示
        user.setCard(dealer.Deal());
        y=y+2;
        System.out.print("カードは"+y+"枚消費されています\n");
        for(int i=0;i<user.myCard.size();i++){
        System.out.print("player:"+user.myCard.get(i));
        }
       System.out.print("合計値は"+user.open(user.myCard)+"です。");
       if((dealer.open(dealer.myCard)==21)&&(Checkcard.Checker(dealer.myCard))&&(user.open(user.myCard)==21)&&(Checkcard.Checker(user.myCard))){
       System.out.print("両者ナチュラルブラックジャックです。\n引き分けです。");
        continue;
       }else if((dealer.open(dealer.myCard)==21)&&Checkcard.Checker(dealer.myCard)&&user.open(user.myCard)!=21){
           System.out.print("dealer側のナチュラルブラックジャックです。\ndealerの勝利です\n");
            continue;
       } else if((dealer.open(dealer.myCard)!=21)&&Checkcard.Checker(user.myCard)&&user.open(user.myCard)==21){
           System.out.print("player側のナチュラルブラックジャックです。\nplayerの勝利です。\n");
            continue; 
       }
       
       while(true){ 
        if(dealer.deck.size()<=1){
        
        System.out.print("カードがなくなりました。");
        System.out.print("ブラックジャックを終了します");
        break Game;
        }
       
       
        if(user.checkSum(dealer.open(dealer.myCard))){
               System.out.print("player:Hit");
               user.setCard(dealer.Hit());
               System.out.print("player合計値"+user.open(user.myCard)+"。\n");
               y=y+1;
               System.out.print("カードは"+y+"枚消費されています\n");
            if(user.open(user.myCard)>21){
                System.out.print("player合計値"+user.open(user.myCard)+"。\n");
                System.out.print("dealerの勝利です\n");
                 //System.out.print("パターン2");
                continue Game;
          
            
        }
    }    
        //停止
        if(dealer.deck.size()<=1){
        
        System.out.print("カードがなくなりました。");
        System.out.print("ブラックジャックを終了します");
        break Game;
        }
        
        
        if(dealer.checkSum(user.open(user.myCard))){
            
            System.out.print("dealer:Hit");
            dealer.setCard(dealer.Hit());
             System.out.print("dealer合計値は"+dealer.open(dealer.myCard)+"です。");
            y=y+1;
            System.out.print("カードは"+y+"枚消費されています\n");
            if(dealer.open(dealer.myCard)>21){
                 System.out.print("dealer合計値"+dealer.open(dealer.myCard)+"。\n");
                System.out.print("playerの勝利です。\n");
                // System.out.print("パターン1");
                continue Game;
            }
            if(dealer.open(dealer.myCard)<=user.open(user.myCard)&&(dealer.open(dealer.myCard)!=21)){
                System.out.print("dealerはもう一度hitしてください。\n");
            continue;
            }else if(user.open(user.myCard)<dealer.open(dealer.myCard)&&user.open(user.myCard)!=21){
                System.out.print("playerはもう一度hitしてください。\n");
            continue;
            }else if(dealer.open(dealer.myCard)==21&&user.open(user.myCard)==21){
                      System.out.print("両者ブラックジャックです。\n引き分けです。");
                continue Game;
            }else if(dealer.open(dealer.myCard)==21&&user.open(user.myCard)<21){
                    System.out.print("ブラックジャックです\ndealerの勝利です。");
                    continue Game;
            }else if(dealer.open(dealer.myCard)>21&&user.open(user.myCard)==21){
                    System.out.print("ブラックジャックです\nplayerの勝利です。");
                    continue Game; 
            
            
            }else{
                System.out.print("勝利条件nullです。");
                continue Game;
                    }   
                }
            
            
                System.out.print("hitフェイズに戻ります。\n");
        
        
        
        
        
                    
        
                }
            }
        }
        
    }

    
        
    

    
    

abstract class Human{
    
public ArrayList<String> myCard=new ArrayList<String>();

abstract public int open(ArrayList card);

abstract public void setCard(ArrayList card);

abstract public boolean checkSum(int c);

}

class Dealer extends Human{
    public ArrayList<String> deck=new ArrayList<String>();

    
    public Dealer(){
        
    for(int i=0;i<4;i++){
        for(int j=0;j<13;j++){
            switch(i){
                case 0:
                    deck.add("♠"+(j+1));
                    continue;
                case 1:
                    deck.add("💛"+(j+1));
                    continue;
                case 2:
                    deck.add("♣"+(j+1));
                    continue;
                case 3:
                    deck.add("♦"+(j+1));
                
                   
            
            }
        
        }
    
    }
    System.out.print("デッキを作成しました");

}

    

   
  @Override
  public int open(ArrayList card){
  String[] num =new String[card.size()];
card.toArray(num);
int[] result=new int[card.size()];

int h=0;
for(int i=0;i<num.length;i++){

result[i] = Integer.parseInt(num[i].replaceAll("[^0-9]",""));

switch(result[i]){
    case 13:
    case 12:
    case 11:
        h=h+10;
        continue;
    case 1:
        if(h+11<22){
        h=h+11;
        continue;
        }else{
        h=h+1;
        continue;
        }
    default:
        h=h+result[i];

    }

}
return h;
  }
  
  
  
  @Override
 public void setCard(ArrayList card){
 
myCard.addAll(card);
 }
 
 
 

  @Override
 public boolean checkSum(int c){
     
     
 if(open(myCard)>c){
     return false;
 
 }
 return true;

 }
    


public ArrayList<String> Deal(){
ArrayList<String> deal=new ArrayList();
String number;
Integer index;
//ランダムな値を得る
Random rand=new Random();
//2枚ドロー
for(int i=0;i<2;i++){
//nからランダム
index = rand.nextInt(deck.size());

number=deck.get(index);

deal.add(number);

deck.remove(deck.get(index));
}

return deal;
}

public ArrayList<String> Hit(){
ArrayList<String> hit=new ArrayList();
String number;
Integer index;
//ランダムな値を得る
Random rand=new Random();

//nからランダム
index = rand.nextInt(deck.size());

number=deck.get(index);

hit.add(number);

deck.remove(deck.get(index));
System.out.print(number+"ヒット！");



return hit;
}

}

class User extends Human{
//ArrayList<String> deck = new ArrayList<String>();

/*public ArrayList<String> Deal(){
ArrayList<String> deal=new ArrayList();
String number;
Integer index;
//ランダムな値を得る
Random rand=new Random();
//2枚ドロー
for(int i=0;i<2;i++){
//nからランダム
index = rand.nextInt(deck.size());

number=deck.get(index);

deal.add(number);
}

return deal;
}*/

@Override
public boolean checkSum(int c){
if(open(myCard)==21||open(myCard)>c){
     return false;
 
 }
 return true;

 }


 @Override
 public void setCard(ArrayList card){
 
 myCard.addAll(card);
 
 
 
 }

  @Override
  public int open(ArrayList card){
  String[] num =new String[card.size()];
card.toArray(num);
int[] result=new int[card.size()];

int h=0;
for(int i=0;i<num.length;i++){

result[i] = Integer.parseInt(num[i].replaceAll("[^0-9]",""));

switch(result[i]){
    case 13:
    case 12:
    case 11:
        h=h+10;
        continue;
    case 1:
        if(h+11<22){
        h=h+11;
        continue;
        }else{
        h=h+1;
        continue;
        }
    default:
        h=h+result[i];

    }

}
return h;
  }


}
class checkCard{
//10入ってないか確認
    boolean Checker(ArrayList n){
        if(!(n.get(0)=="10"||n.get(1)=="10")){
        return true;
        
        }
        
    return false;
    }
}








