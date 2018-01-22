/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author hassa
 */
@Entity
public class Quiz implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="id")
    int id;
    @Column(name="title")
    String title;
    @Column(name="description")
    String description;
    @Column(name="questionnumber")
    int questionnumber;
    @Column(name="totalmarks")
    int totalmarks;
    
    @OneToMany(cascade=CascadeType.ALL)
    List<Question> questions=new ArrayList();
    
    public Quiz(String title, String description){
        this.title=title;
        this.description=description;
        questionnumber=0;
    }

    public Quiz(String title, String description, int totalmarks){
        this.title=title;
        this.description=description;
        this.totalmarks=totalmarks;
        questionnumber=0;
    }

    public Quiz(String title, String description, List<Question> qlist, int totalmarks)
    {
    this.title=title;
    this.description=description;
    questions=qlist;
    questionnumber=0;
    }
    
    public Quiz(){}
    
    public List<Question> getQuestions(){
        return questions;
    }
    
    public String getTitle(){
        return title;
    }
    
    public int getMarks(){
        return totalmarks;
    }
    
    public String getDescription(){
        return description;
    }
    
    public int getNumOfQuestions(){
        return questionnumber;
    }
    
    public void setTitle(String title){
        this.title=title;
    }
    
    public void setDescription(String desc){
        this.description=desc;
    }
    
    public void setNumOfQuestions(int noofques){
        this.questionnumber=noofques;
    }
    
    public void setTotalMarks(int totalmarks){
        this.totalmarks=totalmarks;
    }
    
    public void addQuestionMCQ(String type, String text, String expectedans, String option1, String option2, String option3, String option4){
    questions.add(new Question(type, text, expectedans, option1, option2, option3, option4));
    questionnumber++;
    }
    public void addQuestionTrueFalse(String type, String text, String expectedans){
    questions.add(new Question(type, text, expectedans));
    questionnumber++;
    }
    public void addQuestionNumeric(String type, String text, String expectedans){
    questions.add(new Question(type, text, expectedans));
    questionnumber++;
    }
}
