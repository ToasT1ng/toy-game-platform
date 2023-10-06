package info.toast1ng.toygameplatform.product.adapter.in.web;

import info.toast1ng.toygameplatform.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@WebAdapter
@RequiredArgsConstructor
@RestController
public class OrderController {

    //TODO 빈 요청일 경우 Exception 처리
    @PostMapping("/orders")
    public String registerOrder(@RequestBody Map<String, Object> input) {
        System.out.println(input.toString());
        return "success";
    }
}
