package info.toast1ng.toygameplatform.product.application.port.in;

import info.toast1ng.toygameplatform.common.GoldType;
import info.toast1ng.toygameplatform.product.adapter.in.web.RegisterStoreProductVO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class RegisterProductCommand {
    private String name;
    private String category;
    private GoldType type;
    private int price;
    private String imageUrl;

    public static RegisterProductCommand of(RegisterStoreProductVO vo) {
        return new RegisterProductCommand(vo.getName(), vo.getCategory(), GoldType.valueOf(vo.getType()), vo.getPrice(), vo.getImageUrl());
    }
}
