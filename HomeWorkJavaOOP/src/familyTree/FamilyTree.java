package familyTree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import iteratorFamilyTree.FamilyLivingIterator;
import livingBegin.LivingBeingInterf;
import sortFamily.*;

public class FamilyTree<E extends LivingBeingInterf<E>> implements Serializable, Iterable<E>{
    private long count;
    private  List<E> livingList;
    public FamilyTree(List<E> livingList){
        this.livingList = livingList;
    }
    public FamilyTree(){
        this(new ArrayList<>());
    }
    public boolean add(E e){
        if(e == null){
            return false;
        }if (!livingList.contains(e)) {
            livingList.add(e);
            e.setId(count++);
            addToParense(e);
            addToChilgren(e);
            return true;
        } 
        return false;
        
    }
    public void addToParense(E e){
        for (E parent : e.getParents()) {
            parent.addChild(e);
        }
    }
    public void addToChilgren(E e){
        for (E children : e.getChildren()) {
            e.addParent(children);
        }
    }
    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E e : livingList) {
            if(e.getName().equals(name)){
                res.add(e);
            }
        }
        return res;
    }
    public boolean setWedding(long humanId1,long humanId2 ){
        if(checkId(humanId1) && checkId(humanId2)){
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }
    public boolean setWedding(E human1,E human2){
        if(human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }else{
            return false;
        }
    }
    private boolean checkId(long id){
        return id < count && id >= 0;
    }
    public E getById(long id){
        if (checkId(id)) {
            for (E e: livingList) {
                if(e.getId() == id){
                    return e;
                }
            }
        }
        return null;
    }@Override
    public String toString() { return getInfo();}
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(livingList.size());
        sb.append(" объектов: \n");
        for (E e : livingList) {
            sb.append(e);
            sb.append("\n");
        }
        return sb.toString();
    }  
    @Override
    public Iterator<E> iterator() {
        return new FamilyLivingIterator<E>(livingList);
    }
    public void sortByBirthDate(){
        livingList.sort( new ByBirshDateSort<E>());
    }
    public void sortByGenger(){
        livingList.sort(new ByGengerSort<E>());
    }
    public void sortByName(){
        livingList.sort(new ByNameSort<E>());
    }
}
