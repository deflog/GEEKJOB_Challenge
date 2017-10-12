package jums;

import java.io.Serializable;



/**
 * ユーザー情報を持ちまわるJavaBeans
 * 
 * @version 1.00
 * @author hayashi-s
 */
public class UserDataBeans implements Serializable{
    //private int userID;
    private String name;
   // private String birthday;
    private String tell;
    private int type;
    private String comment;
    //private String newDate;
    private int year;
    private int month;
    private int day;
   
     public UserDataBeans(){
        this.name = "";
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.tell = "";
        this.type = 0;
        this.comment= "";
    }
    
    /* public int getUserID() {
    return userID;
    }
    public void setUserID(int userID) {
    this.userID = userID;
    }*/
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    /*public String getBirthday(){
    return birthday;
    }
    public void setBirthday(String birthday){
    this.birthday = birthday;
    }*/
    
    public String getTell(){
        return tell;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    
    public int getType(){
        
        return type;
    }
    public void setType(String type){
        this.type = Integer.parseInt(type);
    }
    
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
    /* public String getNewDate() {
    return newDate;
    }
    public void setNewDate(String newDate) {
    this.newDate = newDate;
    }*/
    public int getYear(){
        return year;
    }
    public void setYear(String year){
        
        this.year = Integer.parseInt(year);
    }
    public int getMonth(){
        return month;
    }
    public void setMonth(String month){
        
        this.month = Integer.parseInt(month);
    }
    public int getDay(){
        
        return day;
    }
    public void setDay(String day){
      
        this.day = Integer.parseInt(day);
    }

}
