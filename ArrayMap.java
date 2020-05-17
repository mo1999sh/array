@Override
public Integer get(String key) {
        for (int i = 0; i < schluessel.length; i++)
        if (schluessel[i].equals(key)) {
        return werte[i]; }
        return null; }
@Override
public void put(String key, Integer value) {
        remove(key);
        for (int i = 0; i < schluessel.length; i++) {
        if (schluessel[i].equals(key)){  // falls gibt es ein schlussel der schon vor handen dann mach nichts
        return;
        }else if (schluessel[i].equals(null) || schluessel[i] != key) { // falls der schlussel
        schluessel[i] = key;
        werte[i] = value;
        return;
        } else {
        schluessel[i] = key;
        werte[i] = null;
        return;}
        }

        String[] schluessel2 = new String[2 * schluessel.length];
        int[] werte2 = new int[2 * werte.length];
        for (int i = 0; i < schluessel.length; i++) {

        schluessel2[i] = schluessel[i];
        werte2[i] = werte[i];}
        schluessel2[schluessel.length] = key;
        werte2[werte.length] = value;}
@Override
public void remove(String key) {
        for (int i = 0; i < schluessel.length; i++) {
        if (schluessel[i] != null && schluessel[i].equals(key)) {
        schluessel[i] = null;
        werte[i]= 0;
        }}}
@Override

public int size() {
        int lengthvalue = 0;
        for (int i = 0; i < schluessel.length; i = i + 1)
        if (schluessel[i] != null) {
        lengthvalue = lengthvalue + 1;
        }
        return lengthvalue;}
@Override
public void keys(String[] array) {
        if (array == null) {
        throw new IllegalArgumentException(); }

        for (int i= 0; i <= this.size() - 1; i++) {
        if (array.length > schluessel.length) {
        throw new IllegalArgumentException(); }
        array[i]=schluessel[i];
        }}}


        int valuelength = 0;
        while (schleussl.length != 0 && schleussl[valuelength] != null){
        valuelength=valuelength+1;
        }
        return valuelength;


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
                //rearrangeArray(i); //Alle Elemente, die nach dem gelöschten Element liegen, werden um eine Stelle nach links verschoben
                break;
            }
        }
// if (elements[(elements.length / 2) - 1] == null){ //Überprüfe ob wir das array verkleinern sollen? Also
// reduceArray();
// }
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
    /**
     * Verschiebt die Elemente, die nach dem gelöschten Element liegen, um eine Stelle nach links
     * */
    private void rearrangeArray(int removedElement){
        int i = removedElement;
        while (schleussl[i+1] != null){
            schleussl[i] = schleussl[i];
            i++;
        }
    }
    /**
     * Die Größe der Array mal zwei vergrößern
     * */
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