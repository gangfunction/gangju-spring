package hello.itemservice.web.basic;

import hello.itemservice.domain.item.DeliveryCode;
import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class FormItemController {
    public String addForm(Model model){
        model.addAttribute("item",new Item());

        LinkedHashMap<String, String> regions = new LinkedHashMap<>();
        regions.put("SEOUL", "서울");
        regions.put("BUSAN", "부산");
        regions.put("JEJU", "제주");
        model.addAttribute(regions);
        return regions.toString();
    }
    @ModelAttribute("itemTypes")
    public ItemType[] itemTypes(){
        return ItemType.values();
    }
    @ModelAttribute("deliveryCodes")
    public List<DeliveryCode> deliveryCodes(){
        List<DeliveryCode> deliveryCodes = new ArrayList<>();
        deliveryCodes.add(new DeliveryCode("FAST","빠른 배송"));
        deliveryCodes.add(new DeliveryCode("NORMAL","일반 배송"));
        deliveryCodes.add(new DeliveryCode("SLOW","느린 배송"));
        return deliveryCodes;

    }

}
