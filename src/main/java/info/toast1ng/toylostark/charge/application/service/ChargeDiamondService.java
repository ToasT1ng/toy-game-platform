package info.toast1ng.toylostark.charge.application.service;

import info.toast1ng.toylostark.account.application.port.out.LoadAccountPort;
import info.toast1ng.toylostark.account.application.port.out.UpdateAccountPort;
import info.toast1ng.toylostark.account.domain.Account;
import info.toast1ng.toylostark.charge.application.port.in.ChargeDiamondCommand;
import info.toast1ng.toylostark.charge.application.port.in.ChargeDiamondUseCase;
import info.toast1ng.toylostark.charge.application.port.out.RegisterChargeOrderPort;
import info.toast1ng.toylostark.charge.domain.ChargeOrder;
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

    @Override
    public void chargeDiamond(ChargeDiamondCommand chargeDiamondCommand) {
        Account account = loadAccountPort.loadAccount(chargeDiamondCommand.getUserId());
        //TODO check payment method

        System.out.println("충전 전 다이아몬드 " + account.getGolds().getDiamond().getAmount());
        System.out.println("충전할 다이아몬드 " + chargeDiamondCommand.getDiamond().getAmount());
        System.out.println("충전할 가격 " + chargeDiamondCommand.getPrice().getAmount());

        //TODO billing (w. Payment Gateway)

        registerChargeOrderPort.registerChargeOrder(ChargeOrder.builder()
                .user(account)
                .diamond(chargeDiamondCommand.getDiamond())
                .price(chargeDiamondCommand.getPrice())
                .date(new Date())
                .build());

        account.addDiamond(chargeDiamondCommand.getDiamond());
        updateAccountPort.changeAccountGold(account);
    }
}
