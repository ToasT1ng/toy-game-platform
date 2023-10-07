package info.toast1ng.toygameplatform.charge.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountPort;
import info.toast1ng.toygameplatform.account.application.port.out.UpdateAccountPort;
import info.toast1ng.toygameplatform.account.domain.Account;
import info.toast1ng.toygameplatform.charge.adapter.out.web.KakaoPayApproveApiRequest;
import info.toast1ng.toygameplatform.charge.adapter.out.web.ReadyApiRequest;
import info.toast1ng.toygameplatform.charge.adapter.out.web.ReadyApiResult;
import info.toast1ng.toygameplatform.charge.application.port.in.ApproveCommand;
import info.toast1ng.toygameplatform.charge.application.port.in.ChargeDiamondUseCase;
import info.toast1ng.toygameplatform.charge.application.port.in.PaymentType;
import info.toast1ng.toygameplatform.charge.application.port.in.ReadyCommand;
import info.toast1ng.toygameplatform.charge.application.port.out.*;
import info.toast1ng.toygameplatform.charge.domain.ChargeOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Transactional
@RequiredArgsConstructor
@Service
public class ChargeDiamondService implements ChargeDiamondUseCase {
    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountPort updateAccountPort;
    private final RegisterChargeOrderPort registerChargeOrderPort;
    private final KakaoPayPort kakaoPayPort;
    private final PaycoPort paycoPort;
    private final LoadChargeOrderPort loadChargeOrderPort;
    private final UpdateChargeOrderStatePort updateChargeOrderStatePort;

    @Override
    public ReadyApiResult ready(ReadyCommand readyCommand) throws JsonProcessingException {
        Account account = loadAccountPort.loadAccount(readyCommand.getUserId());
        long orderId = registerChargeOrderPort.registerChargeOrder(ChargeOrder.builder()
                .user(account)
                .diamond(readyCommand.getDiamond())
                .price(readyCommand.getPrice())
                .date(new Date())
                .paymentType(readyCommand.getPaymentType())
                .build());

        //TODO ready with PAYMENT TYPE
        ReadyApiRequest request = new ReadyApiRequest(orderId, readyCommand);
        if (readyCommand.getPaymentType().equals(PaymentType.KAKAO_PAY)) {
            return kakaoPayPort.ready(request);
        } else if (readyCommand.getPaymentType().equals(PaymentType.PAYCO)) {
            return paycoPort.ready(request);
        }
        //TODO 예외 처리 : ready 실패의 경우
        return null;
    }

    @Override
    public void approve(ApproveCommand approveCommand) throws Exception {
        ChargeOrder chargeOrder = loadChargeOrderPort.loadChargeOrder(approveCommand.getOrderId());

        if (chargeOrder.getPaymentType().equals(PaymentType.KAKAO_PAY)) {
            kakaoPayPort.approve(new KakaoPayApproveApiRequest(approveCommand.getOrderId(), approveCommand.getPgToken()));
        } else {
            throw new Exception("잘못된 승인 요청");
        }
        //TODO 예외 처리 : approve 실패의 경우

        updateChargeOrderStatePort.updateChargeOrderStatePort(approveCommand.getOrderId());

        Account account = loadAccountPort.loadAccount(chargeOrder.getUser().getId());
        account.addDiamond(chargeOrder.getDiamond());
        updateAccountPort.updateAccount(account);
    }
}
