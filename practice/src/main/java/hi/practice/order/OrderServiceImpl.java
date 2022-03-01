package hi.practice.order;

import hi.practice.discount.DiscountPolicy;
import hi.practice.discount.FixDiscountPolicy;
import hi.practice.discount.RateDiscountPolicy;
import hi.practice.menu.MemoryMenuRepository;
import hi.practice.menu.Menu;
import hi.practice.menu.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MenuRepository menuRepository;
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MenuRepository menuRepository, DiscountPolicy discountPolicy){
        this.menuRepository = menuRepository;
        this.discountPolicy  = discountPolicy;
    }

    @Override
    public Order createOrder(Long menuId, String menuName, int menuPrice) {
        Menu menu = menuRepository.findByName(menuName);
        int discountPrice = discountPolicy.discount(menu, menuPrice);
        return new Order(menuId,menuName,menuPrice,discountPrice);
    }

    // 테스트 용도
    public MenuRepository getMenuRepository(){
        return menuRepository;
    }
}
