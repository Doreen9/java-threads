package io.turntabl.execution.barriers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class HorseRace {
    public static void main(String[] args){
        int horses = 5;

        CyclicBarrier b = new CyclicBarrier(horses,
                ()-> System.out.println("barrier reached"));

        List<String> horseNames = Arrays.asList("Rooky","Moose","Sammy","Jerry","Gina");

        horseNames.forEach(i->
                new Horses(i, b).start()
        );
    }
}
