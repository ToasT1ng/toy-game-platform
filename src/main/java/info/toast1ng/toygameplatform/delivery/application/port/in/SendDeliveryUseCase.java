package info.toast1ng.toygameplatform.delivery.application.port.in;

public interface SendDeliveryUseCase {
    void sendDelivery(SendDeliveryCommand command) throws Exception;
}
