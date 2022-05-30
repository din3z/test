package ru.comp.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Compas implements Serializable {
    private static final Compas instance= new Compas();
    private final Map<String, String> model;

    public Compas(){
        model = new HashMap<String, String>();
    }


    public void add(String side, String degree){
        model.put(side, degree);
    }
    public static Compas getInstance(){
        return instance;
    }
    public Map<String, String> getAll() {
        return model;
    }

    public String  isSide(int d){
        //boolean res=false;

        for (Map.Entry<String, String> pair: model.entrySet()){

            String [] sub;
            String del ="-";
            sub = pair.getValue().split(del);
            int a = Integer.parseInt(sub[0]);
            int b = Integer.parseInt(sub[1]);

            if(a>b){
                if ((d>a)||(d<b))
                    return pair.getKey();
            }
            else
                if ((d>a)&&(d<b))
                    return pair.getKey();

        }
        return "not found";
    }

}
