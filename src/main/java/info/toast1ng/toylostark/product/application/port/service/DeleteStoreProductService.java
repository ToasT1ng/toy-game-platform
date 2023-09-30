package info.toast1ng.toylostark.product.application.port.service;

import info.toast1ng.toylostark.product.application.port.in.DeleteStoreProductUseCase;
import info.toast1ng.toylostark.product.application.port.out.DeleteStoreProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class DeleteStoreProductService implements DeleteStoreProductUseCase {
    private final DeleteStoreProductPort port;

    @Override
    public void deleteStoreProduct(long id) {
        port.deleteStoreProduct(id);
    }
}
