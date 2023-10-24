package info.toast1ng.toygameplatform.common.adapter.in.web;

import info.toast1ng.toygameplatform.account.application.port.in.GetAccountItemQuery;
import info.toast1ng.toygameplatform.account.application.port.in.GetAccountQuery;
import info.toast1ng.toygameplatform.charge.application.port.in.GetChargeOrderQuery;
import info.toast1ng.toygameplatform.charge.domain.FixedExchangeRates;
import info.toast1ng.toygameplatform.common.GoldType;
import info.toast1ng.toygameplatform.common.WebAdapter;
import info.toast1ng.toygameplatform.delivery.application.port.in.GetDeliveryQuery;
import info.toast1ng.toygameplatform.order.application.port.in.GetOrderQuery;
import info.toast1ng.toygameplatform.product.application.port.in.GetStoreProductQuery;
import info.toast1ng.toygameplatform.product.application.port.in.ListStoreProductsCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView index() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ModelAndView model = new ModelAndView();
        model.addObject("account", getAccountQuery.getAccount(username));
        model.setViewName("index");
        return model;
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
    public ModelAndView admin(@RequestParam(required = false, defaultValue="1") int page,
                              @RequestParam(required = false, defaultValue="5") int limit,
                              @RequestParam(required = false, defaultValue="") String keyword,
                              @RequestParam(required = false, defaultValue="none") GoldType goldType) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ModelAndView model = new ModelAndView();
        model.addObject("productList", getStoreProductQuery.listStoreProducts(new ListStoreProductsCommand(keyword, goldType, PageRequest.of(page-1, limit))));
        model.addObject("searchNameKeyword", keyword);
        model.addObject("searchGoldType", goldType);
        model.addObject("account", getAccountQuery.getAccount(username));
        model.setViewName("admin");
        return model;
    }

    @GetMapping("/store")
    public ModelAndView store(@RequestParam(required = false, defaultValue="1") int page,
                              @RequestParam(required = false, defaultValue="5") int limit,
                              @RequestParam(required = false, defaultValue="") String keyword,
                              @RequestParam(required = false, defaultValue="none") GoldType goldType) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ModelAndView model = new ModelAndView();
        model.addObject("productList", getStoreProductQuery.listStoreProducts(new ListStoreProductsCommand(keyword, goldType, PageRequest.of(page-1, limit))));
        model.addObject("searchNameKeyword", keyword);
        model.addObject("searchGoldType", goldType);
        model.addObject("account", getAccountQuery.getAccount(username));
        model.setViewName("store");
        return model;
    }

    @GetMapping("/game")
    public ModelAndView game() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ModelAndView model = new ModelAndView();
        model.addObject("account", getAccountQuery.getAccount(username));
        model.setViewName("game");
        return model;
    }

    @GetMapping("/my-page")
    public ModelAndView myPage() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ModelAndView model = new ModelAndView();
        model.addObject("account", getAccountQuery.getAccount(username));
        model.setViewName("my-page");
        return model;
    }

    @GetMapping("/edit-info")
    public ModelAndView editInfo() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ModelAndView model = new ModelAndView();
        model.addObject("account", getAccountQuery.getAccount(username));
        model.setViewName("edit-info");
        return model;
    }

    @GetMapping("/edit-password")
    public ModelAndView editPassword() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ModelAndView model = new ModelAndView();
        model.addObject("account", getAccountQuery.getAccount(username));
        model.setViewName("edit-password");
        return model;
    }

    @GetMapping("/my-items")
    public ModelAndView myItems() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ModelAndView model = new ModelAndView();
        model.addObject("account", getAccountQuery.getAccount(username));
        model.addObject("items", getAccountItemQuery.getAccountItems(username, 1));
        model.addObject("itemOrders", getOrderQuery.getOrders(username));
        model.setViewName("my-items");
        return model;
    }

    @GetMapping("/my-charges")
    public ModelAndView myCharges() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ModelAndView model = new ModelAndView();
        model.addObject("account", getAccountQuery.getAccount(username));
        model.addObject("exchangeRates", new FixedExchangeRates().getList());
        model.addObject("chargeOrders", getChargeOrderQuery.getChargeOrders(username));
        model.setViewName("my-charges");
        return model;
    }

    @GetMapping("/delivery-box")
    public ModelAndView deliveryBox() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        String username = "admin_user";
        ModelAndView model = new ModelAndView();
        model.addObject("account", getAccountQuery.getAccount(username));
        model.addObject("items", getAccountItemQuery.getAccountItems(username, 1));
        model.addObject("sendDeliveries", getDeliveryQuery.getSendDeliveries(username));
        model.addObject("receivedDeliveries", getDeliveryQuery.getReceivedDeliveries(username));
        model.setViewName("delivery-box");
        return model;
    }
}
