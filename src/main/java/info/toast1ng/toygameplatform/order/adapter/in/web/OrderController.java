package info.toast1ng.toygameplatform.order.adapter.in.web;

import info.toast1ng.toygameplatform.common.WebAdapter;
import info.toast1ng.toygameplatform.order.application.port.in.RegisterOrderUseCase;
import info.toast1ng.toygameplatform.order.application.service.RegisterOrderCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RequiredArgsConstructor
@RestController
public class OrderController {
    private final RegisterOrderUseCase registerOrderUseCase;

    //TODO 빈 요청일 경우 Exception 처리
    @PostMapping("/orders")
    public String registerOrder(@RequestBody RegisterOrderVO registerOrderVO) throws Exception {
        registerOrderUseCase.registerOrder(RegisterOrderCommand.builder()
                .userId(registerOrderVO.getUserId())
                .productId(registerOrderVO.getProductId())
                .amount(registerOrderVO.getAmount())
                .build());
        return "success";
    }

}
