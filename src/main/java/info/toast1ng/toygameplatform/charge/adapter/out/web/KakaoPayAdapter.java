package info.toast1ng.toygameplatform.charge.adapter.out.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.toast1ng.toygameplatform.charge.application.port.out.KakaoPayPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RequiredArgsConstructor
@Component
public class KakaoPayAdapter implements KakaoPayPort {
    @Value("${kakao.pay.admin.key}")
    private String SERVICE_APP_ADMIN_KEY;

    private final TempDataComponent dataComponent;

    @Override
    public KakaoPayReadyApiResult ready(ReadyApiRequest request) throws JsonProcessingException {
        HttpHeaders header = new HttpHeaders();
        header.set(HttpHeaders.AUTHORIZATION, "KakaoAK " + SERVICE_APP_ADMIN_KEY);
        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("cid", "TC0ONETIME");
        body.add("partner_order_id", String.valueOf(request.getOrderId()));
        body.add("partner_user_id", "ToasT1ng");
        body.add("item_name", "다이아몬드 구입");
        body.add("quantity", request.getDiamond().getAmount());
        body.add("total_amount", request.getPrice().getAmount());
        body.add("tax_free_amount", "0");
        body.add("approval_url", "http://localhost:8080/kakao/pay/"+request.getOrderId()+"/completed");
        body.add("cancel_url", "http://localhost:8080/kakao/pay/cancel");
        body.add("fail_url", "http://localhost:8080/kakao/pay/fail");

        HashMap result = postCall("https://kapi.kakao.com/v1/payment/ready", header, body).getBody();
        dataComponent.addData(request.getOrderId() + "_tid" , result.get("tid").toString());
        return new KakaoPayReadyApiResult(request.getOrderId(), request.getUserId(), result);
    }

    @Override
    public void approve(KakaoPayApproveApiRequest request) throws JsonProcessingException {
        HttpHeaders header = new HttpHeaders();
        header.set(HttpHeaders.AUTHORIZATION, "KakaoAK " + SERVICE_APP_ADMIN_KEY);
        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("cid", "TC0ONETIME");
        body.add("tid", dataComponent.getDataMap().get(request.getOrderId() + "_tid"));
        body.add("partner_order_id", request.getOrderId());
        body.add("partner_user_id", "ToasT1ng");
        body.add("pg_token", request.getPgToken());

        postCall("https://kapi.kakao.com/v1/payment/approve", header, body);
    }

    public <T> ResponseEntity<HashMap> postCall(String url, HttpHeaders header, T body) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(body, header);
        ResponseEntity<HashMap> jsonObjectResponseEntity = restTemplate.postForEntity(url, entity, HashMap.class);
        System.out.println("POST Return ===> " + jsonObjectResponseEntity.toString());
        return jsonObjectResponseEntity;
    }
}
