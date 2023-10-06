package info.toast1ng.toygameplatform.account.application.port.out;

import info.toast1ng.toygameplatform.account.domain.AccountProduct;

public interface LoadAccountProductPort {
    AccountProduct loadAccountProduct(long userId, long productId);
}
