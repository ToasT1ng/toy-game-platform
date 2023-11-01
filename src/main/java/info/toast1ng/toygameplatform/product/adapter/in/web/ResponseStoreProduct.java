package info.toast1ng.toygameplatform.product.adapter.in.web;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ResponseStoreProduct {
    private long id;

    public static ResponseStoreProduct of(long id) {
        return new ResponseStoreProduct(id);
    }
}
