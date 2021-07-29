package entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.*;

@EqualsAndHashCode(callSuper = false)
@Data
public class BangSo extends Config implements Serializable {
    private List<Integer> dacBiet = new ArrayList<>();
    private List<Integer> nhat = new ArrayList<>();
    private List<Integer> hai = new ArrayList<>();
    private List<Integer> ba = new ArrayList<>();
    private List<Integer> bon = new ArrayList<>();
    private List<Integer> nam = new ArrayList<>();
    private List<Integer> sau = new ArrayList<>();
    private List<Integer> bay = new ArrayList<>();

    public void quaySo() {
        Random rd = new Random();

        for (int i = 0; i < NUM_OF_DAC_BIET; i++) {
            dacBiet.add(rd.nextInt(MAX_VALUE_DAC_BIET + 1));
        }
        for (int i = 0; i < NUM_OF_NHAT; i++) {
            nhat.add(rd.nextInt(MAX_VALUE_NHAT + 1));
        }
        for (int i = 0; i < NUM_OF_HAI; i++) {
            hai.add(rd.nextInt(MAX_VALUE_HAI + 1));
        }

        for (int i = 0; i < NUM_OF_BA; i++) {
            ba.add(rd.nextInt(MAX_VALUE_BA + 1));
        }
        for (int i = 0; i < NUM_OF_BON; i++) {
            bon.add(rd.nextInt(MAX_VALUE_BON + 1));
        }
        for (int i = 0; i < NUM_OF_NAM; i++) {
            nam.add(rd.nextInt(MAX_VALUE_NAM + 1));
        }
        for (int i = 0; i < NUM_OF_SAU; i++) {
            sau.add(rd.nextInt(MAX_VALUE_SAU + 1));
        }
        for (int i = 0; i < NUM_OF_BAY; i++) {
            bay.add(rd.nextInt(MAX_VALUE_BAY + 1));
        }
    }

    public Map<Integer, Integer> getMapNum() {
        Map<Integer, Integer> map = new HashMap<>();
        dacBiet.stream().mapToInt(i -> i).map(i -> i % 100).forEach(num -> {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        });
        nhat.stream().mapToInt(i -> i).map(i -> i % 100).forEach(num -> {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        });
        hai.stream().mapToInt(i -> i).map(i -> i % 100).forEach(num -> {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        });
        ba.stream().mapToInt(i -> i).map(i -> i % 100).forEach(num -> {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        });
        bon.stream().mapToInt(i -> i).map(i -> i % 100).forEach(num -> {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        });
        nam.stream().mapToInt(i -> i).map(i -> i % 100).forEach(num -> {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        });
        sau.stream().mapToInt(i -> i).map(i -> i % 100).forEach(num -> {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        });
        bay.stream().mapToInt(i -> i).map(i -> i % 100).forEach(num -> {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        });
        return map;
    }
}
