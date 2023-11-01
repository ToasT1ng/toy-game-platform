package info.toast1ng.toygameplatform.order.adapter.in.web;

import info.toast1ng.toygameplatform.common.WebAdapter;
import info.toast1ng.toygameplatform.order.application.port.in.RegisterOrderUseCase;
import info.toast1ng.toygameplatform.order.application.service.RegisterOrderCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@WebAdapter
@RequiredArgsConstructor
@RestController
public class OrderController {
    private final RegisterOrderUseCase registerOrderUseCase;

    @PostMapping("/orders")
    public String registerOrder(@Valid @RequestBody RegisterOrderVO registerOrderVO) throws Exception {
        registerOrderUseCase.registerOrder(RegisterOrderCommand.builder()
                .userId(registerOrderVO.getUserId())
                .productId(registerOrderVO.getProductId())
                .amount(registerOrderVO.getAmount())
                .build());
        return "success";
    }

}
