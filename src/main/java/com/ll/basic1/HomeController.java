package com.ll.basic1;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Controller
public class HomeController {
    private int count = -1;

    @GetMapping("/home/main")
    @ResponseBody
    public String showMain(){
        return "안녕하세요";
    }
    @GetMapping("/home/increase")
    @ResponseBody
    public int showIncrease(){
        count++;
        return count;
    }
    @GetMapping("/home/plus")
    @ResponseBody
    public int showPlus(@RequestParam(defaultValue = "0") int a , @RequestParam int b){
        return a + b;
    }
    @GetMapping("/home/returnIntArray")
    @ResponseBody
    public int[] showReturnIntArray(){
        int[] arr = new int[]{10, 20, 30};
        return arr;
    }
    @GetMapping("/home/returnMap")
    @ResponseBody
    public Map<String, Object> showReturnMap(){
        Map<String, Object> map = new LinkedHashMap<>(){{
            put("id",1);
            put("speed", 100);
            put("name", "카니발");
            put("relatedIds", new ArrayList<>() {{
                add(2);
                add(3);
                add(4);
            }});
        }};
        return map;
    }

    @GetMapping("/home/returnCar")
    @ResponseBody
    public Car showReturnCar(){
        Car car = new Car(1,100, "카니발",new ArrayList<>() {{
            add(2);
            add(3);
            add(4);
        }});
        return car;
    }
}

class Car {
    @Getter
    private final int id;
    @Getter
    private final int speed;
    @Getter
    private final String name;
    @Getter
    private final List<Integer> relatedIds;

    public Car(int id, int speed, String name, List<Integer> relatedIds){
        this.id = id;
        this.speed = speed;
        this.name= name;
        this.relatedIds = relatedIds;
    }


}
