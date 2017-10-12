package jums;



/**
 * ユーザー情報を持ちまわるJavaBeans
 * 
 * @version 1.00
 * @author hayashi-s
 */
public class UserDataBeans {
    private int userID;
    private String name;
    private String birthday;
    private String tell;
    private String type;
    private String comment;
    private String newDate;
    private String year;
    private String month;
    private String day;
   
    
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getBirthday(){
        return birthday;
    }
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    
    public String getTell(){
        return tell;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
    public String getNewDate() {
        return newDate;
    }
    public void setNewDate(String newDate) {
        this.newDate = newDate;
    }
    public String getYear(){
        return year;
    }
    public void setYear(String year){
        this.year = year;
    }
    public String getMonth(){
        return month;
    }
    public void setMonth(String month){
        this.month = month;
    }
    public String getDay(){
        return day;
    }
    public void setDay(String day){
        this.day = day;
    }

}
