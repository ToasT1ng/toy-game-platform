package info.toast1ng.toylostark.common.adapter.in.web;

import info.toast1ng.toylostark.account.application.port.in.GetAccountQuery;
import info.toast1ng.toylostark.charge.application.port.in.GetChargeOrderQuery;
import info.toast1ng.toylostark.charge.domain.FixedExchangeRates;
import info.toast1ng.toylostark.product.application.port.in.GetStoreProductQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class WebController {
    private final GetStoreProductQuery getStoreProductQuery;
    private final GetAccountQuery getAccountQuery;
    private final GetChargeOrderQuery getChargeOrderQuery;

    @GetMapping({"/", "/index"})
    public ModelAndView init() {
        ModelAndView model = new ModelAndView();
        model.addObject("productList", getStoreProductQuery.listStoreProducts());
        model.addObject("golds", getAccountQuery.getGolds(1));
        model.setViewName("index");
        return model;
    }

    @GetMapping("/myPage")
    public ModelAndView myPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("account", getAccountQuery.getAccount(1));
        model.addObject("exchangeRates", new FixedExchangeRates().getList());
        model.addObject("chargeOrders", getChargeOrderQuery.getChargeOrders(1));
        model.setViewName("myPage");
        return model;
    }
}
