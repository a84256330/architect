package event;

import lombok.Data;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
@Getter
public class DemoEvent extends ApplicationEvent {
    private Long id;
    private String msg;
    public DemoEvent(Object source, Long id, String msg) {
        super(source);
        this.id = id;
        this.msg = msg;
    }
}
