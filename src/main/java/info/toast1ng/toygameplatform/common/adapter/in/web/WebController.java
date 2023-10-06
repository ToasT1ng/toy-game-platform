package info.toast1ng.toygameplatform.common.adapter.in.web;

import info.toast1ng.toygameplatform.account.application.port.in.GetAccountQuery;
import info.toast1ng.toygameplatform.charge.application.port.in.GetChargeOrderQuery;
import info.toast1ng.toygameplatform.charge.domain.FixedExchangeRates;
import info.toast1ng.toygameplatform.common.WebAdapter;
import info.toast1ng.toygameplatform.product.application.port.in.GetStoreProductQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@WebAdapter
@RequiredArgsConstructor
@Controller
public class WebController {
    private final GetStoreProductQuery getStoreProductQuery;
    private final GetAccountQuery getAccountQuery;
    private final GetChargeOrderQuery getChargeOrderQuery;

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        ModelAndView model = new ModelAndView();
        model.addObject("productList", getStoreProductQuery.listStoreProducts());
        model.setViewName("admin");
        return model;
    }

    @GetMapping("/store")
    public ModelAndView store() {
        ModelAndView model = new ModelAndView();
        model.addObject("productList", getStoreProductQuery.listStoreProducts());
        model.addObject("golds", getAccountQuery.getGolds(1));
        model.setViewName("store");
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
