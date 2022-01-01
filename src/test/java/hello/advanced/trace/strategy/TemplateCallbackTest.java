package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.tempalte.Callback;
import hello.advanced.trace.strategy.code.tempalte.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {
    /**
     * 쳄플릿 콜백 패턴 - 익명 내부 클래스
     */
    @Test
    void callbackV1(){

        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.execute(new Callback() {
            @Override
            public void call() {
                log.info("비즈니스 로직");
            }
        });

    }

    /**
     * 쳄플릿 콜백 패턴 - 익명 내부 클래스
     */
    @Test
    void callbackV2(){

        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.execute(() -> log.info("비즈니스 로직"));

    }
}
