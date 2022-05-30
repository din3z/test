package ru.comp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.comp.logic.Compas;

import java.util.Map;

@RestController
public class Controller {

    private static final Compas compas = Compas.getInstance();
//    пример запроса:
//    {
//        "North": "316-45",
//            "East": "46-135",
//            "South": "136-225",
//            "West": "226-315"
//    } я долго искала градусы по 8, но не нашла... но прога должна работать и с ними
    @PostMapping(value = "/setDirection", consumes = "application/json", produces = "application/json")
    public Map<String, String> setDirection(@RequestBody Map<String, String> comp){
        for (Map.Entry<String, String> pair: comp.entrySet()){
            compas.add(pair.getKey(), pair.getValue());
        }
        return compas.getAll();
    }

//    пример запроса:
//    {degree: 0}

    @GetMapping(value = "/getSide", consumes = "application/json", produces = "application/json")
    public String getSide(@RequestBody Map<String,Integer> degree){
        return "side "+compas.isSide(degree.get("degree"));
    }


}
