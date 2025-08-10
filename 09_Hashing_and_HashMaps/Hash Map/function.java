import java.util.*;
public class function{
    static class HashMap<K, V> //genirics
    {
        private class Node{
            K key;
            V value;
            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; //nodes
        private final int N; //buckets=size=buckets.length
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[N];
            for(int i = 0; i < buckets.length; i++){
               this.buckets[i] = new LinkedList<>();
            }
        }
        
        private int hashfunction(K key){
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            for(int i=0;i<ll.size();i++){
                if(ll.get(i).key == key){
                    return i;
                }
            }
            return -1;
        }
        
        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];
            for(int i=0;i<buckets.length;i++){
                buckets[i] = new LinkedList<>();
            }
            for(LinkedList<Node> ll : oldBucket){
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }  

        public void put(K key, V value){
            int bi = hashfunction(key);
            int di = searchInLL(key, bi);
            if(di == -1){//doesnt exist
                buckets[bi].add(new Node(key, value));
                n++;
            }
            else{//exists
                Node node = buckets[bi].get(di);
                node.value = value;
            }
            double lambda = (double)n/N;
            if(lambda > 2.0){
                rehash();
            }
        }

        public V get(K key){
            int bi = hashfunction(key);
            int di = searchInLL(key, bi);
            if(di == -1){//key not found
                return null;
            }
            else{//exists
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        public boolean containsKey(K key){
            int bi = hashfunction(key);
            int di = searchInLL(key, bi);
            return di != -1;
        }

        public V remove(K key){
            int bi = hashfunction(key);
            int di = searchInLL(key, bi);
            if(di == -1){//key not found
                return null;
            }
            else{//exists
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        public boolean isEmpty(){
            return n == 0;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(LinkedList<Node> ll : buckets){
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

    }

    public static void main(String args[]){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 135);
        map.put("China", 140);
        map.put("USA", 40);
        map.put("UK", 20);

        ArrayList<String> keys = map.keySet();
        for(String key : keys){
            System.out.println(key + " -> " + map.get(key));
        }

        map.remove("China");
        System.out.println(map.get("China"));
    }
}