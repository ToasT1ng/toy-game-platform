package info.toast1ng.toygameplatform.delivery.application.service;

import info.toast1ng.toygameplatform.delivery.application.port.in.ReceiveDeliveryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ReceiveDeliveryService implements ReceiveDeliveryUseCase {
    @Override
    public void acceptDelivery(long id) {
        //TODO delivery 상태가 wait 일 경우만 다음 스텝 진행
        //TODO receiver 쪽에 아이템 주기
        //TODO delivery 수락한 것으로 변경하기
    }

    @Override
    public void cancelDelivery(long id) {
        //TODO sender 쪽에 아이템 반환하기
        //TODO delivery 취소한 것으로 변경하기
    }

    @Override
    public void rejectDelivery(long id) {
        //TODO sender 쪽에 아이템 반환하기
        //TODO delivery 거절한 것으로 변경하기
    }
}
