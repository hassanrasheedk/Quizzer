/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author hassa
 */
@Entity
public class User implements Serializable{
    @Id
    @Column(name="userName")
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="role")
    private String role;
    @Column(name="score")
    private int score;
    
    public int getScore(){
    return score;
    }
    
    public void setScore(int score){
    this.score=score;
    }
    
    public String getUserName(){
    return userName;
    }
    
    public void setUserName(String userName){
    this.userName=userName;
    }
    
    public String getPassword(){
    return password;
    }
    
    public void setPassword(String password){
    this.password=password;
    }
    
    public String getRole(){
    return role;
    }
    
    public void setRole(String role){
    this.role=role;
    }
    
    public void printUser(){
    System.out.printf("%s\t%s\t%s\t%d",getUserName(),getPassword(),getRole(),getScore());
    }
    
    public User(String userName, String password, String role, int score){//to create a student user
        setUserName(userName);
        setPassword(password);
        setRole(role);
        setScore(score);
    }
    public User(String userName, String password, String role){//to create an instructor user
        setUserName(userName);
        setPassword(password);
        setRole(role);
    }
    
    public User(String userName, String password){
        setUserName(userName);
        setPassword(password);
    }
    
    public User(){}
}
