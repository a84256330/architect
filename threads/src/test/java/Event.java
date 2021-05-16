import event.DemoPublisher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class Event {
    @Autowired
    DemoPublisher demoPublisher;
    @Test
    public void publisherTest() {
        demoPublisher.publish(1L, "成功了！");
    }
}
