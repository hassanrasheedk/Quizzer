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
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="id")
    int id;
    @Column(name="type")
    public String type;
    @Column(name="text")
    public String text;
    @Column(name="expectedans")
    public String expectedans;
    @Column(name="options")
    public String[] mcqarray=new String[4];
    
    public Question(){}
    
    public String gettype(){
        return type;
    }
    public String gettext(){
        return text;
    }
    public String getexpectedans(){
        return expectedans;
    }
    public String[] getmcqarray(){
        return mcqarray;
    }
    public void settype(String type){
        this.type=type;
    }
    public void settext(String text){
        this.text=text;
    }
    public void setexpectedans(String expectedans){
        this.expectedans=expectedans;
    }
    public void setmcqarray(String[] mcqs){
        this.mcqarray=mcqs;
    }
    
    
    public Question(String type, String text, String expectedans, String option1, String option2, String option3, String option4){
        this.type=type;
        this.text=text;
        this.expectedans=expectedans;
        mcqarray[0]=option1;
        mcqarray[1]=option2;
        mcqarray[2]=option3;
        mcqarray[3]=option4;
    }
    public Question(String type, String text, String expectedans){
        this.type=type;
        this.text=text;
        this.expectedans=expectedans;
        mcqarray=null;
    }
}
