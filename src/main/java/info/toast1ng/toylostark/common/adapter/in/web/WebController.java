package info.toast1ng.toylostark.common.adapter.in.web;

import info.toast1ng.toylostark.account.application.port.in.GetAccountQuery;
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

    @GetMapping({"/", "/index"})
    public ModelAndView init() {
        ModelAndView model = new ModelAndView();
        model.addObject("productList", getStoreProductQuery.listStoreProducts());
        model.addObject("golds", getAccountQuery.getGolds(0));
        model.setViewName("index");
        return model;
    }

    @GetMapping("/myPage")
    public ModelAndView myPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("account", getAccountQuery.getAccount(0));
        model.setViewName("myPage");
        return model;
    }
}
