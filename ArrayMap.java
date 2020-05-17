
class Tuple<X,Y>{
    public final X x;
    public final Y y;
    public Tuple (X x, Y y){
        this.x=x;
        this.y=y;
    }
}

public class ArrayMap implements Map<String,Integer> {
    private Tuple<String,Integer>[] schleussl = new Tuple[1];

    //Das Array enthält als ein Element als init
    @Override
    public Integer get(String key) {
        Integer wert = null;
        for (Tuple<String,Integer> element : schleussl) {
            if (element.x.equals(key)) {
                wert = element.y;
                break;
            }
        }
        return wert;
    }
    @Override
    public void put(String key, Integer value) {
        if (key == null) return;
        int count = 0;
        while (schleussl[count] != null && !schleussl[count].x.equals(key)){ //في حال اذاكان ال index غير ممتلئ
            count++;
        }
        schleussl[count] = new Tuple<>(key,value);
        if (count == schleussl.length - 1){ //اذا كان ال array ممتلئ
            extendArray();
        }
    }
    @Override
    public void remove(String key) {
        for (int i = 0; i < schleussl.length; i++) {
            if (schleussl[i].x.equals(key)){
                schleussl[i] = null;
                break;
            }
        }

    }
    @Override
    public int size() {
        int valuelength = 0;
        while (schleussl.length != 0 && schleussl[valuelength] != null) {
            valuelength = valuelength + 1;
        }
        return valuelength;
    }
    @Override
    public void keys(String[] array) {
        try {
            for (int i = 0; i < schleussl.length; i++) {
                array[i] = schleussl[i].x;
            }
        }catch (Exception ex){
            throw new IllegalArgumentException();
        }
    }

    private void rearrangeArray(int removedElement){
        int i = removedElement;
        while (schleussl[i+1] != null){
            schleussl[i] = schleussl[i];
            i++;
        }
    }

    private void extendArray(){
        Tuple<String,Integer>[] temp = new Tuple[schleussl.length * 2];
        System.arraycopy(schleussl, 0, temp, 0, schleussl.length);
        schleussl = temp;
    }
    /**
     * Die Größe der Array durch zwei verkleinern
     * */
    private void reduceArray(){
        Tuple<String,Integer>[] temp = new Tuple[schleussl.length / 2];
        System.arraycopy(schleussl, 0, temp, 0, schleussl.length / 2);
        schleussl = temp;
    }
}
