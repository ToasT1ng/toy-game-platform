package info.toast1ng.toygameplatform.delivery.application.port.in;

public interface ReceiveDeliveryUseCase {
    void acceptDelivery(long id);
    void cancelDelivery(long id);
    void rejectDelivery(long id);
}
