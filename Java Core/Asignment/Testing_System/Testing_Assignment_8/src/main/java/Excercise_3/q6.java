package Excercise_3;

import java.util.Map;

public class q6 {
    public static void main(String[] args) {

    }

    public class MyNumber<K,V>{
        private K key;
        private V value;
    }

    public class MyMap<K, V> {
        private K key;
        private V value;

        MyMap(K k, V v) {
            key = k;
            value = v;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
