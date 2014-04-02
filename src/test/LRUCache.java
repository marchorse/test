package test;

//System.out.println("get("+String.valueOf(key)+")->\n"+this);
//System.out.println("set("+String.valueOf(key)+","+String.valueOf(value)+")->\n"+this);

public class LRUCache {
    
    public class Item {
        int key;
        int value;
        int time;
        public Item() {
            time = 0;
        }
        public Item(int key, int value) {
            this.key = key;
            this.value = value;
            time = 1;
        }
    }
    
    public Item [] cache;
    
    public boolean full;
    
    public LRUCache(int capacity) {
        full = false;
        cache = new Item [capacity];
        for (int i=0;i<cache.length;i++) {
            cache[i] = null;
        }
    }
    
    public int get(int key) {
        int hk = hash(key);
        for (int i=0;i<cache.length;i++) {
            if (cache[(hk+i)%cache.length]==null) return -1;
            else {
                if(cache[(hk+i)%cache.length].key==key) {
                    cache[(hk+i)%cache.length].time = 0;
                    System.out.println("get("+String.valueOf(key)+")->\n"+this);
                    return cache[(hk+i)%cache.length].value;
                }
            }
        }
        return -1;
    }
    
    public void set(int key, int value) {
        int hk = hash(key);
        boolean isSet = false;
        int index = -1;
        if (full==false) {
            for (int i=0;i<cache.length;i++) {
                if (cache[(hk+i)%cache.length]==null) {
                    index = i;
                    isSet = true;
                    break;
                }
                if (cache[(hk+i)%cache.length].key==key) {
                    index = i;
                    isSet = true;
                    break;
                }
            }
            if (isSet==false) full = true;
        }
        if (isSet==false) {
            for (int i=0;i<cache.length;i++) {
                if (cache[(hk+i)%cache.length].key==key) {
                    index = i;
                    isSet = true;
                    break;
                }
//                if (cache[(hk+i)%cache.length].time>0) {
//                    index = i;
//                    isSet = true;
//                    break;
//                }
            }
        }
        if (isSet) cache[(hk+index)%cache.length] = new Item(key, value);
        else  cache[hk] = new Item(key,value);
        System.out.println("set("+String.valueOf(key)+","+String.valueOf(value)+")->\n"+this);
    }
    
    public int hash(int key) {
        return key>0?(key%cache.length):(-key%cache.length);
    }

    public static void main(String [] args) {
    	//10,[set(10,13),set(3,17),set(6,11),set(10,5),
    	//set(9,10),get(13),set(2,19),get(2),get(3),set(5,25),
    	//get(8),set(9,22),set(5,5),set(1,30),get(11),set(9,12),
    	//get(7),get(5),get(8),get(9),set(4,30),set(9,3),get(9),
    	//get(10),get(10),set(6,14),set(3,1),get(3),set(10,11),
    	//get(8),set(2,14),get(1),get(5),get(4),set(11,4),set(12,24),
    	//set(5,18),get(13),set(7,23),get(8),get(12),set(3,27),set(2,12),
    	//get(5),set(2,9),set(13,4),set(8,18),set(1,7),get(6),set(9,29),
    	//set(8,21),get(5),set(6,30),set(1,12),get(10),set(4,15),set(7,22),
    	//set(11,26),set(8,17),set(9,29),get(5),set(3,4),set(11,30),get(12),
    	//set(4,29),get(3),get(9),get(6),set(3,4),get(1),get(10),set(3,29),
    	//set(10,28),set(1,20),set(11,13),get(3),set(3,12),set(3,8),set(10,9),
    	//set(3,26),get(8),get(7),get(5),set(13,17),set(2,27),set(11,15),
    	//get(12),set(9,19),set(2,15),set(3,16),get(1),set(12,17),set(9,1),
    	//set(6,19),get(4),get(5),get(5),set(8,1),set(11,7),set(5,2),set(9,28),
    	//get(1),set(2,2),set(7,4),set(4,22),set(7,24),set(9,26),set(13,28),set(11,26)]
//    	LRUCache c = new LRUCache(10);
//    	c.set(10,13);
//    	c.set(3,17);
//    	c.set(6,11);
//    	c.set(10,5);
//    	c.set(9,10);
//    	c.get(13);
//    	c.set(2,19);
//    	c.get(2);
//    	c.get(3);
//    	c.set(5,25);
//    	c.get(8);
//    	c.set(9,22);
//    	c.set(5,5);
//    	c.set(1,30);
//    	c.get(11);
//    	c.set(9,12);
//    	c.get(7);
//    	c.get(5);
//    	c.get(8);
//    	c.get(9);
//    	c.set(4,30);
//    	c.set(9,3);
//    	c.get(9);
//    	c.get(10);
//    	c.get(10);
//    	c.set(6,14);
//    	c.set(3,1);
//    	c.get(3);
//    	c.set(10,11);
//    	c.get(8);
//    	c.set(2,14);
//    	c.get(1);
//    	c.get(5);
//    	c.get(4);
//    	c.set(11,4);
//    	c.set(12,24);
//    	c.set(5,18);
//    	c.get(13);
//    	c.set(7,23);
//    	c.get(8);
//    	c.get(12);
//    	c.set(3,27);
//    	c.set(2,12);
//    	c.get(5);
//    	c.set(2,9);
//    	c.set(13,4);
//    	c.set(8,18);
//    	c.set(1,7);
//    	c.get(6);
//    	c.set(9,29);
//    	c.set(8,21);
//    	c.get(5);
//    	c.set(6,30);
//    	c.set(1,12);
//    	c.get(10);
//    	c.set(4,15);
//    	c.set(7,22);
//    	c.set(11,26);
//    	c.set(8,17);
//    	c.set(9,29);
//    	c.get(5);
//    	c.set(3,4);
//    	c.set(11,30);
//    	c.get(12);
//    	c.set(4,29);
//    	c.get(3);
//    	c.get(9);
//    	c.get(6);
//    	c.set(3,4);
//    	c.get(1);
//    	c.get(10);
//    	c.set(3,29);
//    	c.set(10,28);
//    	c.set(1,20);
//    	c.set(11,13);
//    	c.get(3);
//    	c.set(3,12);
//    	c.set(3,8);
//    	c.set(10,9);
//    	c.set(3,26);
//    	c.get(8);
//    	c.get(7);
//    	c.get(5);
//    	c.set(13,17);
//    	c.set(2,27);
//    	c.set(11,15);
//    	c.get(12);
//    	c.set(9,19);
//    	c.set(2,15);
//    	c.set(3,16);
//    	c.get(1);
//    	c.set(12,17);
//    	c.set(9,1);
//    	c.set(6,19);
//    	c.get(4);
//    	c.get(5);
//    	c.get(5);
//    	c.set(8,1);
//    	c.set(11,7);
//    	c.set(5,2);
//    	c.set(9,28);
//    	c.get(1);
//    	c.set(2,2);
//    	c.set(7,4);
//    	c.set(4,22);
//    	c.set(7,24);
//    	c.set(9,26);
//    	c.set(13,28);
//    	c.set(11,26);
//    	System.out.println(c);
    	
    	//2,[set(2,1),set(2,2),get(2),set(1,1),set(4,1),get(2)]
    	LRUCache c = new LRUCache(2);
    	c.set(2, 1);
    	c.set(2, 2);
    	System.out.println(c.get(2));
    	c.set(1, 1);
    	c.set(4, 1);
    	System.out.println(c.get(2));
    	
    	//2,[set(2,1),set(3,2),get(3),get(2),set(4,3),get(2),get(3),get(4)]
//    	LRUCache c = new LRUCache(2);
//    	c.set(2,1);
//    	c.set(3,2);
//    	c.get(3);
//    	c.get(2);
//    	c.set(4,3);
//    	c.get(2);
//    	c.get(3);
//    	c.get(4);
    	
//    	LRUCache c = new LRUCache(6);
//    	c.set(1, 10);
//    	System.out.println(c);
//    	c.set(1, 11);
//    	c.set(2, 10);
//    	c.set(5, 20);
//    	c.set(6, 20);
//    	c.set(7, 20);
//    	c.set(8, 20);
//    	c.set(9, 20);
//    	System.out.println("get: "+c.get(2));
//    	System.out.println("get: "+c.get(1));
//    	System.out.println(c);
//    	c.set(1, 12);
//    	System.out.println(c);
    }
    
    public String toString() {
    	String str = "";
    	for (int i=0;i<cache.length;i++) {
    		if (cache[i]!=null)
    			str += String.valueOf(i)+": "+String.valueOf(cache[i].key)+" "
    					+String.valueOf(cache[i].value)+" "
    					+String.valueOf(cache[i].time)
    					+"\n";
    		else
    			str += String.valueOf(i)+": null\n";
    	}
		return str;
    }
}