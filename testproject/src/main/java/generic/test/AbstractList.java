package generic.test;

import java.util.ArrayList;
import java.util.List;


public class AbstractList<K> {
    private List<K> objectList ;

    public AbstractList(){
        objectList = new ArrayList<>();
    }



    public void add(K k){
        objectList.add(k);
    }

    public List<K> getList(){
        return objectList;
    }

    public List<K> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<K> objectList) {
        this.objectList = objectList;
    }
}
