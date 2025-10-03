// CORRECT HASH TABLE THROUGH LINER PROBING (OPEN ADDRESSING)
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
public class HashTable1 {
    private class Entry {
        private Object key, value;
        public Entry(Object key,Object value) {
            this.key = key; this.value = value;
        }
    }
    private Entry[] entries;
    private int size, used;
    private float loadFactor;
    private final Entry NIL = new Entry(null,null);
    public HashTable1(int capacity,float loadFactor) {
        entries = new Entry[capacity];
        this.loadFactor = loadFactor;
    }
    public HashTable1(int capacity) {
        this(capacity,0.75F);
    }
    public HashTable1() {
        this(101);
    }
    private int hash(Object key) {
        if (key==null) throw new IllegalArgumentException();
        return (key.hashCode() & 0x7FFFFFFF) % entries.length;
    }
    private int nextProbe(int h,int i) {
        return (h+i) % entries.length;
    }
    public Object put(Object key,Object value) {
        if (used > loadFactor*entries.length) {
            rehash();
        }
        int h = hash(key);
        for (int i = 0; i < entries.length; i++) {
            int j = nextProbe(h,i);
            Entry entry = entries[j];
            if (entry==null) {
                entries[j] = new Entry(key,value);
                size++;
                used++;
                return null;
            }
            if (entry==NIL) {
                continue;
            }
            if (entry.key.equals(key)) {
                Object oldValue = entry.value;
                entries[j].value = value;
                return oldValue;
            }
        }
        return null;
    }
    public Object get(Object key) {
        int h = hash(key);
        for (int i = 0; i < entries.length; i++) {
            int j = nextProbe(h,i);
            Entry entry = entries[j];
            if (entry==null) {
                break;
            }
            if (entry==NIL) {
                continue;
            }
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }
    public Object remove(Object key) {
        int h = hash(key);
        for (int i = 0; i < entries.length; i++) {
            int j = nextProbe(h,i);
            Entry entry = entries[j];
            if (entry==null) {
                break;
            }
            if (entry==NIL) {
                continue;
            }
            if (entry.key.equals(key)) {
                Object oldValue = entry.value;
                entries[j] = NIL;
                size--;
                return oldValue;
            }
        }
        return null;
    }
    public int size() {
        return size;
    }
    private void rehash() {
        Entry[] oldEntries = entries;
        entries = new Entry[oldEntries.length*2 + 1];
        for (int k = 0; k < oldEntries.length; k++) {
            Entry entry = oldEntries[k];
            if (entry==null || entry==NIL) {
                continue;
            }
            int h = hash(entry.key);
            for (int i = 0; i < entries.length; i++) {
                int j = nextProbe(h,i);
                if (entries[j]==null) {
                    entries[j] = entry;
                    break;
                }
            }
        }
        used = size;
    }
    public void display() {
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null && entries[i] != NIL) {
                System.out.println("INDEX : " + i +  " | KEY : "  + entries[i].key + " | VALUE : " + entries[i].value);
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

        HashTable1 hashTable = new HashTable1();
        hashTable.put("FR",c1); hashTable.put("PE",c2); hashTable.put("IT",c3);
        hashTable.put("PT",c4); hashTable.put("UK",c5); hashTable.put("PK",c6);
        System.out.println("SIZE OF HASH TABLE : " + hashTable.size());
        hashTable.display();

        System.out.println("REMOVED VALUE : " + hashTable.remove("IT"));
        System.out.println("SIZE OF HASH TABLE : " + hashTable.size());
        hashTable.display();
    }
}
