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
import info.toast1ng.toygameplatform.charge.application.port.out.KakaoPayPort;
import info.toast1ng.toygameplatform.charge.application.port.out.PaycoPort;
import info.toast1ng.toygameplatform.charge.application.port.out.RegisterChargeOrderPort;
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

    @Override
    public ReadyApiResult ready(ReadyCommand readyCommand) throws JsonProcessingException {
        //TODO check payment method

        //TODO ready with PAYMENT TYPE
        if (readyCommand.getPaymentType().equals(PaymentType.KAKAO_PAY)) {
            return kakaoPayPort.ready(new ReadyApiRequest(readyCommand.getUserId(), readyCommand.getPrice(), readyCommand.getDiamond()));
        } else if (readyCommand.getPaymentType().equals(PaymentType.PAYCO)) {
            return paycoPort.ready(new ReadyApiRequest(readyCommand.getUserId(), readyCommand.getPrice(), readyCommand.getDiamond()));
        }
        //TODO 예외 처리 : ready 실패의 경우
        return null;
    }

    @Override
    public void approve(ApproveCommand approveCommand) throws Exception {
        if (approveCommand.getPaymentType().equals(PaymentType.KAKAO_PAY)) {
            kakaoPayPort.approve(new KakaoPayApproveApiRequest(approveCommand.getTid(), approveCommand.getOrderId(), approveCommand.getPgToken()));
        } else {
            throw new Exception("잘못된 승인 요청");
        }

        //TODO 예외 처리 : approve 실패의 경우

        Account account = loadAccountPort.loadAccount(approveCommand.getUserId());
        account.addDiamond(approveCommand.getDiamond());
        updateAccountPort.changeAccountGold(account);

        registerChargeOrderPort.registerChargeOrder(ChargeOrder.builder()
                .user(account)
                .diamond(approveCommand.getDiamond())
                .price(approveCommand.getPrice())
                .date(new Date())
                .build());
    }
}
