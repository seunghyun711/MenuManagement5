package hi.practice.discount;

import hi.practice.menu.EventMenu;
import hi.practice.menu.Menu;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 20; //20% 할인

    @Override
    public int discount(Menu menu, int price) {
        if(menu.getEventMenu() == EventMenu.ShrimpBurger){
            return price * discountPercent /100;
        }else{
            return 0;
        }
    }
}
