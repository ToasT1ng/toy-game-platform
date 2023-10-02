package info.toast1ng.toygameplatform.charge.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountPort;
import info.toast1ng.toygameplatform.account.application.port.out.UpdateAccountPort;
import info.toast1ng.toygameplatform.account.domain.Account;
import info.toast1ng.toygameplatform.charge.adapter.out.web.ReadyApiResult;
import info.toast1ng.toygameplatform.charge.application.port.in.ChargeDiamondCommand;
import info.toast1ng.toygameplatform.charge.application.port.in.ChargeDiamondUseCase;
import info.toast1ng.toygameplatform.charge.application.port.out.KakaoPayPort;
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

    @Override
    public ReadyApiResult chargeDiamond(ChargeDiamondCommand chargeDiamondCommand) throws JsonProcessingException {
        Account account = loadAccountPort.loadAccount(chargeDiamondCommand.getUserId());
        //TODO check payment method

        //TODO billing (w. Payment Gateway)

        long orderId = registerChargeOrderPort.registerChargeOrder(ChargeOrder.builder()
                .user(account)
                .diamond(chargeDiamondCommand.getDiamond())
                .price(chargeDiamondCommand.getPrice())
                .date(new Date())
                .build());

        ReadyApiResult billingResult = kakaoPayPort.billing(orderId, chargeDiamondCommand);

        account.addDiamond(chargeDiamondCommand.getDiamond());
        updateAccountPort.changeAccountGold(account);

        return billingResult;
    }
}
