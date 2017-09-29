/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge121;

/**
 *
 * @author p-user
 */
public class sampleB {
    public static void main(String[] args){
    Human hito=new Human();
    
    hito.age = 40;
    hito.setHuman("添田亮司", 34);
    hito.prHuman();
    
    }
    
}
class Human{
public String name="";
public int age=0;

public void setHuman(String n,int a){

    this.name=n;
    this.age=a;

}
public void prHuman(){

System.out.print(name);
System.out.print(age);
}



}
