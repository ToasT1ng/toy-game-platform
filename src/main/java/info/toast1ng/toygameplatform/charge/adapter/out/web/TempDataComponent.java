package info.toast1ng.toygameplatform.charge.adapter.out.web;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Component
public class TempDataComponent {
    private Map<String, Object> dataMap = new HashMap<>();

    public void addData(String key, Object data) {
        dataMap.put(key, data);
    }
}
