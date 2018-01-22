package com.example.hassa.testapp2;

import Model.User;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author hassa
 */
public class UserTest extends TestCase {
@Test    
public void testUsersEquality(){
    User student=new User("Hassan","Rasheed","Student");
    User instructor=new User("Hassan","Rasheed","Instructor");
    User student1=new User("Hassan","Rasheed","Instructor");
    User instructor1=new User("Hassan","Rasheed","Student");
    User student2=new User("Hassan","Rasheed","Student");
    User student3=new User("Hassan","Rasheed","Student",0);
    assertFalse(student.equals(instructor));
    assertFalse(student1.equals(instructor1));
    assertFalse(student2.equals(student3));
}
    
}
