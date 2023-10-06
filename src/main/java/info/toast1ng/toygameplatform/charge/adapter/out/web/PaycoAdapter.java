package info.toast1ng.toygameplatform.charge.adapter.out.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.toast1ng.toygameplatform.charge.application.port.out.PaycoPort;
import info.toast1ng.toygameplatform.common.WebAdapter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@WebAdapter
public class PaycoAdapter implements PaycoPort {
    private String sellerKey = "S0FSJE";
    private String cpId = "PARTNERTEST";
    private String productId = "PROD_EASY";

    @Override
    public ReadyApiResult ready(ReadyApiRequest request) throws JsonProcessingException {
        String randomOrderId = UUID.randomUUID().toString();

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        List<Map<String, Object>> orderProducts = new ArrayList<>();
        Map<String, Object> orderProduct = new HashMap<>();
        orderProduct.put("cpId", cpId);
        orderProduct.put("productId", productId);
        orderProduct.put("productAmt", request.getPrice().getAmount());
        orderProduct.put("productPaymentAmt", request.getPrice().getAmount());
        orderProduct.put("orderQuantity", request.getDiamond().getAmount());
        orderProduct.put("sortOrdering", 1);
        orderProduct.put("productName", "다이아몬드 구입");
        orderProduct.put("sellerOrderProductReferenceKey", "productID");
        orderProducts.add(orderProduct);

        Map<String, Object> body = new HashMap<>();
        body.put("sellerKey", sellerKey);
        body.put("payMode", "PAY2");
        body.put("orderChannel", "PC");
        body.put("orderMethod", "CHECKOUT");
        body.put("totalPaymentAmt", request.getPrice().getAmount());
        body.put("sellerOrderReferenceKey", randomOrderId);
        body.put("inAppYn", "Y");
        body.put("orderTitle", "다이아몬드 구입");
        body.put("returnUrl", "http://localhost:8080/payco/pay/completed");
        body.put("orderProducts", orderProducts);

        HashMap result = postCall( "https://alpha-api-bill.payco.com/outseller/order/reserve", header, body).getBody();
        return new KakaoPayReadyApiResult(randomOrderId, request.getUserId(), result);
    }


    @Override
    public void approve(KakaoPayApproveApiRequest request) throws JsonProcessingException {

    }

    public <T> ResponseEntity<HashMap> postCall(String url, HttpHeaders header, T body) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(body, header);
        System.out.println(entity.toString());
        ResponseEntity<HashMap> jsonObjectResponseEntity = restTemplate.postForEntity(url, entity, HashMap.class);
        System.out.println("PAYCO POST Return ===> " + jsonObjectResponseEntity.toString());
        return jsonObjectResponseEntity;
    }
}
