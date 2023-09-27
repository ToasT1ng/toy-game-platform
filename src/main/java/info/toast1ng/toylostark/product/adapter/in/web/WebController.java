package info.toast1ng.toylostark.product.adapter.in.web;

import info.toast1ng.toylostark.product.application.port.in.GetStoreProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class WebController {
    private final GetStoreProductUseCase getStoreProductUseCase;

    @GetMapping({"/", "/index"})
    public ModelAndView init() {
        ModelAndView model = new ModelAndView();
        model.addObject("productList", getStoreProductUseCase.getStoreProduct());
        model.setViewName("index");
        return model;
    }
}
