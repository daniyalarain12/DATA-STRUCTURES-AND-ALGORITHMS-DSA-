// CORRECT HASH TABLE THROUGH SEPARATE CHAINING (CHAINING)
class Country {
    public String name, language;
    public int area, population;
    public Country(String name,String language,int area,int population) {
        this.name = name; this.language = language; this.area = area; this.population = population;
    }
    public String toString() {
        return "COUNTRY : " + name + " , LANGUAGE : " + language + " , AREA : " + area + " AND POPULATION : " + population;
    }
}
public class HashTable2 {
    private class Entry {
        private Object key, value;
        private Entry next;
        public Entry(Object key,Object value,Entry next) {
            this.key = key; this.value = value; this.next = next;
        }
        @Override
        public String toString() {
            return key + " = " + value;
        }
    }
    private Entry[] entries;
    private int size;
    private float loadFactor;
    public HashTable2(int capacity,float loadFactor) {
        entries = new Entry[capacity];
        this.loadFactor = loadFactor;
    }
    public HashTable2(int capacity) {
        this(capacity,0.75F);
    }
    public HashTable2() {
        this(101);
    }
    private int hash(Object key) {
        if (key==null) throw new IllegalArgumentException();
        return (key.hashCode() & 0x7FFFFFFF) % entries.length;
    }
    public Object put(Object key,Object value) {
        int h = hash(key);
        for (Entry e = entries[h]; e != null; e = e.next) {
            if (e.key.equals(key)) {
                Object olValue = e.value;
                e.value = value;
                return olValue;
            }
        }
        entries[h] = new Entry(key,value,entries[h]);
        size++;
        if (size > loadFactor*entries.length) {
            rehash();
        }
        return null;
    }
    public Object get(Object key) {
        int h = hash(key);
        for (Entry e = entries[h]; e != null; e = e.next) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }
    public Object remove(Object key) {
        int h = hash(key);
        for (Entry e = entries[h], prev = null; e != null; prev = e, e = e.next) {
            if (e.key.equals(key)) {
                Object oldValue = e.value;
                if (prev==null) {
                    entries[h] = e.next;
                } else {
                    prev.next = e.next;
                }
                size--;
                return oldValue;
            }
        }
        return null;
    }
    public int size() {
        return size;
    }
    public void rehash() {
        Entry[] oldEntries = entries;
        entries = new Entry[oldEntries.length*2 + 1];
        for (int k = 0; k < oldEntries.length; k++) {
            for (Entry old = oldEntries[k]; old != null;) {
                Entry e = old;
                old = old.next;
                int h = hash(e.key);
                e.next = entries[h];
                entries[h] = e;
            }
        }
    }
//    public void display() {
//        for (int i = 0; i < entries.length; i++) {
//            for (Entry e = entries[i]; e != null; e = e.next) {
//                System.out.println("INDEX : " + i + " | KEY : " + e.key + " | VALUE : " + e.value);
//            }
//        }
//    }
    public void display() {
        for (int i = 0; i < entries.length; i++) {
            for (Entry e = entries[i]; e != null; e = e.next) {
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        Country c1 = new Country("FRANCE","FRENCH",211200,58978172);
        Country c2 = new Country("GERMANY","GERMAN",137800,82087361);
        Country c3 = new Country("ITALY","ITALIAN",116300,56735130);
        Country c4 = new Country("PORTUGAL","PORTUGUESE",35672,9918040);
        Country c5 = new Country("ENGLAND","ENGLISH",213456,61834234);
        Country c6 = new Country("PAKISTAN","URDU",123456,255232321);

        HashTable2 hashTable = new HashTable2();
        hashTable.put("FR",c1); hashTable.put("PE",c2); hashTable.put("IT",c3);
        hashTable.put("PT",c4); hashTable.put("UK",c5); hashTable.put("PK",c6);
        System.out.println("SIZE OF HASH TABLE : " + hashTable.size());
        hashTable.display();

        System.out.println("REMOVED VALUE : " + hashTable.remove("IT"));
        System.out.println("SIZE OF HASH TABLE : " + hashTable.size());
        hashTable.display();
    }
}
