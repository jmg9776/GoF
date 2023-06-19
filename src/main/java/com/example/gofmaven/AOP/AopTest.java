package com.example.gofmaven.AOP;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

//참고자료
//https://www.youtube.com/watch?v=Hm0w_9ngDpM&t=790s&ab_channel=%EC%9A%B0%EC%95%84%ED%95%9C%ED%85%8C%ED%81%AC
@RequiredArgsConstructor
@Slf4j
@Service
public class AopTest {
    /*
    AOP 용어
    Target
    - 어떤 대상에 부가 기능을 부여할 것인가
    Advice
    - 어떤 부가기 기능을 적용할까 ? Before, AfterReturning, AfterThrowing, After, Around
    Join point
    - 어디에 적용할 것인가? 메서드, 필드, 객체, 생성자 등 Spring AOP에서는 메서드만 적용이 가능하다.
    Point cut
    - 실제 advice가 적용될 지점, Spring AOP에서는 advice가 적용될 메서드를 선정
     */
    private StudentRepository studentRepository = new StudentRepository();

    public void Test() throws InterruptedException {
        StudentData studentData = new StudentData();
        studentData.setName("JO");
        joinLegacy(studentData);
        join(studentData);
    }
    private void joinLegacy(StudentData studentData) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            studentRepository.save(studentData);
        } finally {
            stopWatch.stop();
            log.info("AAAAAAA spent {} ms", stopWatch.getLastTaskTimeMillis());
        }
    }

    @TestAop
    public void join(StudentData studentData) throws InterruptedException {
        studentRepository.save(studentData);
        Thread.sleep(1000);
    }
    /*
    Todo 중요! 메서드를 실행하는 시점에 AOP가 적용되기 때문에 메서드를 직접 실행해야 AOP를 적용이 된다.
    프록시로 감싼 객체가 실제로 타깃오브젝트의 test이라는 메서드를 실행할 때, join메서드가 AOP를 이용한 프록시 객체가 아니게 되기 때문에 자기 자신을 호출할 때에는, AOP가 아닌 메서드가 호출이 된다.
    private 메서드에 @Transaction 어노테이션을 적용했을때, 적용이 되지 않을때와 같은 원리이다.
    Interceptor, SpringSecurity또한 AOP의 기술중 한가지라고 볼 수 있다.

    Aspectj는 컴파일과 클래스 로드시 바이트 코드를 조작하여 적용하는 방식을 채택하고 있다
    SpringAOP는 프록시 패턴을 적용하고 있다.
     */
}
