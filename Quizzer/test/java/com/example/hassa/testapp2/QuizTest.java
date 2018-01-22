package com.example.hassa.testapp2;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.Question;
import Model.Quiz;
import java.util.ArrayList;
import java.util.List;
import junit.framework.*;
import org.junit.Test;
/**
 *
 * @author hassa
 */
public class QuizTest extends TestCase{

    /**
     *
     */
    @Test
    public void testQuizEquality(){
        List<Question> qlist=new ArrayList();
        Quiz qz1=new Quiz("Quiz1","This is Quiz 1");
        Quiz qz2=new Quiz("Quiz1","This is Quiz 1",qlist,10);
        assertFalse(qz1.equals(qz2));
    }
}
