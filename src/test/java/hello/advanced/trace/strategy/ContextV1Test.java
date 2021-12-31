package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.Logic1;
import hello.advanced.trace.template.code.Logic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


// 템플릿 패턴을 이용해 공통부분과 다른 부분을 구분한다.

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV0(){
        logic1();
        logic2();

    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직 실행");

        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("수행 시간 : {}", endTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직 실행2");

        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("수행 시간 : {}", endTime);
    }

    @Test
    void templateMethodV1(){
        AbstractTemplate tempalte1 = new Logic1();
        AbstractTemplate tempalte2 = new Logic2();

        tempalte1.execute();
        tempalte2.execute();
    }

    @Test
    void templateMethodV2(){
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직11 ");
            }
        };

        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직22 ");
            }
        };

        template2.execute();
    }


    /**
     * 전략 패턴 사용
     *
     */

    @Test
    void strategyV1(){
        Strategy strategy = new StrategyLogic1();
        ContextV1 context = new ContextV1(strategy);
        context.execute();

        Strategy strategy2 = new StrategyLogic2();
        ContextV1 context2 = new ContextV1(strategy2);
        context2.execute();

    }

    /**
     * 전략 패턴 익명 클래스
     */

    @Test
    void strategyV2(){
        Strategy strategy1 = new Strategy() {

            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");

            }
        };
        ContextV1 context = new ContextV1(strategy1);
        context.execute();


        Strategy strategy2 = new Strategy() {

            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");

            }
        };
        ContextV1 context2 = new ContextV1(strategy2);
        context2.execute();
    }

    /**
     * 전략 패턴 익명 클래스
     */
    @Test
    void strategyV3(){

        ContextV1 context = new ContextV1(new Strategy() {

            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");

            }
        });
        context.execute();


        ContextV1 context2 = new ContextV1(new Strategy() {

            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");

            }
        });
        context2.execute();
    }

    /**
     * 람다 사용
     */
    @Test
    void strategyV4(){

        ContextV1 context = new ContextV1(() -> log.info("비즈니스 로직 1 실행"));
        context.execute();


        ContextV1 context2 = new ContextV1(() -> log.info("비즈니스 로직 1 실행"));
        context2.execute();
    }
}
