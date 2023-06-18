package com.example.gofmaven;

import com.example.gofmaven.AOP.AopTest;
import com.example.gofmaven.AOP.StudentData;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
@RequiredArgsConstructor
@EnableAspectJAutoProxy
class GoFMavenApplicationTests {
    @Autowired
    AopTest aopTest;

    @Test
    void test() throws InterruptedException {
        StudentData studentData = new StudentData();
        studentData.setName("JO");
        //joinLegacy(studentData);
        aopTest.join(studentData);
    }
}
