package info.toast1ng.toylostark.charge.application.service;

import info.toast1ng.toylostark.account.application.port.out.LoadAccountPort;
import info.toast1ng.toylostark.account.domain.Account;
import info.toast1ng.toylostark.charge.application.port.in.ChargeDiamondCommand;
import info.toast1ng.toylostark.charge.application.port.in.ChargeDiamondUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChargeDiamondService implements ChargeDiamondUseCase {
    private final LoadAccountPort loadAccountPort;


    @Override
    public void chargeDiamond(ChargeDiamondCommand chargeDiamondCommand) {
        Account account = loadAccountPort.loadAccount(chargeDiamondCommand.getUserId());
        //TODO check payment method

        System.out.println("충전 전 다이아몬드 " + account.getGolds().getDiamond().getAmount());
        System.out.println("충전할 다이아몬드 " + chargeDiamondCommand.getDiamond().getAmount());
        System.out.println("충전할 가격 " + chargeDiamondCommand.getPrice().getAmount());

        //TODO billing (w. Payment Gateway)

        account.addDiamond(chargeDiamondCommand.getDiamond());

        //TODO save it to Database
        System.out.println("충전 결과 다이아몬드 " + account.getGolds().getDiamond().getAmount());
    }
}
