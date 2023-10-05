package info.toast1ng.toygameplatform.charge.adapter.out.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.toast1ng.toygameplatform.charge.application.port.out.KakaoPayPort;
import info.toast1ng.toygameplatform.common.PersistenceAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.UUID;

@PersistenceAdapter
public class KakaoPayAdapter implements KakaoPayPort {
    @Value("${kakao.pay.admin.key}")
    private String SERVICE_APP_ADMIN_KEY;

    @Override
    public KakaoPayReadyApiResult ready(KakaoPayReadyApiRequest request) throws JsonProcessingException {
        String randomOrderId = UUID.randomUUID().toString();

        HttpHeaders header = new HttpHeaders();
        header.set(HttpHeaders.AUTHORIZATION, "KakaoAK " + SERVICE_APP_ADMIN_KEY);
        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("cid", "TC0ONETIME");
        body.add("partner_order_id", randomOrderId);
        body.add("partner_user_id", "ToasT1ng");
        body.add("item_name", "다이아몬드 구입");
        body.add("quantity", request.getDiamond().getAmount());
        body.add("total_amount", request.getPrice().getAmount());
        body.add("tax_free_amount", "0");
        body.add("approval_url", "http://localhost:8080/kakao/pay/completed");
        body.add("cancel_url", "http://localhost:8080/kakao/pay/cancel");
        body.add("fail_url", "http://localhost:8080/kakao/pay/fail");

        HashMap result = postCall("https://kapi.kakao.com/v1/payment/ready", header, body).getBody();
        return new KakaoPayReadyApiResult(randomOrderId, request.getUserId(), result);
    }

    @Override
    public void approve(String tid, String orderId, String pgToken) throws JsonProcessingException {
        HttpHeaders header = new HttpHeaders();
        header.set(HttpHeaders.AUTHORIZATION, "KakaoAK " + SERVICE_APP_ADMIN_KEY);
        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("cid", "TC0ONETIME");
        body.add("tid", tid);
        body.add("partner_order_id", orderId);
        body.add("partner_user_id", "ToasT1ng");
        body.add("pg_token", pgToken);

        HashMap result = postCall("https://kapi.kakao.com/v1/payment/approve", header, body).getBody();

    }

    public <T> ResponseEntity<HashMap> postCall(String url, HttpHeaders header, T body) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(body, header);
        ResponseEntity<HashMap> jsonObjectResponseEntity = restTemplate.postForEntity(url, entity, HashMap.class);
        System.out.println("POST Return ===> " + jsonObjectResponseEntity.toString());
        return jsonObjectResponseEntity;
    }

}
