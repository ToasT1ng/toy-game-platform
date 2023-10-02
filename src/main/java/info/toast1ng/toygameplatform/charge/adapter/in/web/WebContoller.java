package info.toast1ng.toygameplatform.charge.adapter.in.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.toast1ng.toygameplatform.charge.application.port.out.KakaoPayPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class WebContoller {
    private final KakaoPayPort kakaoPayPort;
    private final TempApiResultComponent apiResultComponent;

    @GetMapping("/kakao/pay/completed")
    public String myPage(@RequestParam("pg_token") String pgToken) throws JsonProcessingException {
        kakaoPayPort.approve(apiResultComponent.getReadyApiResult().getTid(), apiResultComponent.getReadyApiResult().getOrderId(), pgToken);

        return "redirect:/myPage";
    }
}
