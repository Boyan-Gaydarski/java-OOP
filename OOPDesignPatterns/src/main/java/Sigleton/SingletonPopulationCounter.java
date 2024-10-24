package Sigleton;

import java.util.HashMap;
import java.util.Map;

public class SingletonPopulationCounter implements SingletonContainer {
    private static SingletonPopulationCounter instance;

    public static SingletonPopulationCounter getInstance() {
        if (instance != null) {
            return instance;
        } else {
            return instance = new SingletonPopulationCounter();
        }
    }

    private Map<String, Integer> populationMap;

    private SingletonPopulationCounter() {
        this.populationMap = new HashMap<>();
    }

    public void increasePopulation(String city, int increment) {
        this.populationMap.putIfAbsent(city, 0);
        this.populationMap.put(city, this.populationMap.get(city) + increment);
    }

    public void decreasePopulation(String city, int decrement) {
        this.populationMap.put(city, this.populationMap.get(city) - decrement);
    }

    @Override
    public int getPopulation(String city) {
        return this.populationMap.get(city);
    }
}
