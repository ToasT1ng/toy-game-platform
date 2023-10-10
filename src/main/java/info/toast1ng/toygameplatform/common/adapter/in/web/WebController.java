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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @GetMapping("signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
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
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ModelAndView model = new ModelAndView();
        model.addObject("productList", getStoreProductQuery.listStoreProducts());
        model.addObject("account", getAccountQuery.getAccount(username));
        model.setViewName("store");
        return model;
    }

    @GetMapping("/myPage")
    public ModelAndView myPage() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ModelAndView model = new ModelAndView();
        model.addObject("account", getAccountQuery.getAccount(username));
        model.addObject("items", getAccountItemQuery.getAccountItems(username));
        model.addObject("itemOrders", getOrderQuery.getOrders(username));
        model.addObject("exchangeRates", new FixedExchangeRates().getList());
        model.addObject("chargeOrders", getChargeOrderQuery.getChargeOrders(username));
        model.setViewName("myPage");
        return model;
    }

    @GetMapping("/deliveryBox")
    public ModelAndView deliveryBox() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        String username = "admin_user";
        ModelAndView model = new ModelAndView();
        model.addObject("account", getAccountQuery.getAccount(username));
        model.addObject("items", getAccountItemQuery.getAccountItems(username));
        model.addObject("sendDeliveries", getDeliveryQuery.getSendDeliveries(username));
        model.addObject("receivedDeliveries", getDeliveryQuery.getReceivedDeliveries(username));
        model.setViewName("deliveryBox");
        return model;
    }
}
