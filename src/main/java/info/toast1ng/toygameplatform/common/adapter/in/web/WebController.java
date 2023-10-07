package info.toast1ng.toygameplatform.common.adapter.in.web;

import info.toast1ng.toygameplatform.account.application.port.in.GetAccountItemQuery;
import info.toast1ng.toygameplatform.account.application.port.in.GetAccountQuery;
import info.toast1ng.toygameplatform.charge.application.port.in.GetChargeOrderQuery;
import info.toast1ng.toygameplatform.charge.domain.FixedExchangeRates;
import info.toast1ng.toygameplatform.common.WebAdapter;
import info.toast1ng.toygameplatform.delivery.application.port.in.GetDeliveryQuery;
import info.toast1ng.toygameplatform.order.application.port.in.GetOrderQuery;
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
    private final GetAccountItemQuery getAccountItemQuery;
    private final GetOrderQuery getOrderQuery;
    private final GetDeliveryQuery getDeliveryQuery;

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
        long userId = 1;
        ModelAndView model = new ModelAndView();
        model.addObject("productList", getStoreProductQuery.listStoreProducts());
        model.addObject("account", getAccountQuery.getAccount(userId));
        model.setViewName("store");
        return model;
    }

    @GetMapping("/myPage")
    public ModelAndView myPage() {
        long userId = 1;
        ModelAndView model = new ModelAndView();
        model.addObject("account", getAccountQuery.getAccount(userId));
        model.addObject("items", getAccountItemQuery.getAccountItems(userId));
        model.addObject("itemOrders", getOrderQuery.getOrders(userId));
        model.addObject("exchangeRates", new FixedExchangeRates().getList());
        model.addObject("chargeOrders", getChargeOrderQuery.getChargeOrders(userId));
        model.setViewName("myPage");
        return model;
    }

    @GetMapping("/deliveryBox")
    public ModelAndView deliveryBox() {
        long userId = 1;
        ModelAndView model = new ModelAndView();
        model.addObject("account", getAccountQuery.getAccount(userId));
        model.addObject("items", getAccountItemQuery.getAccountItems(userId));
        model.addObject("sendDeliveries", getDeliveryQuery.getSendDeliveries(userId));
        model.addObject("receivedDeliveries", getDeliveryQuery.getReceivedDeliveries(userId));
        model.setViewName("deliveryBox");
        return model;
    }
}
