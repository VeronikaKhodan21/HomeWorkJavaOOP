package familyTree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import humanClass.Human;
import iteratorFamilyTree.FamilyTreeIterator;
import sortFamily.ByBirshDateSort;
import sortFamily.ByGengerSort;
import sortFamily.ByNameSort;

public class FamilyTree implements Serializable, Iterable<Human>{
    private long countPeople;
    private  List<Human> humanList;
    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }
    public FamilyTree(){
        this(new ArrayList<>());
    }
    public boolean add(Human human){
        if(human == null){
            return false;
        }if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(countPeople++);
            addToParense(human);
            addToChilgren(human);
            return true;
        } 
        return false;
        
    }
    public void addToParense(Human human){
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }
    public void addToChilgren(Human human){
        for (Human children : human.getChildren()) {
            children.addParent(human);
        }
    }
    public List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if(human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }
    public boolean setWedding(long humanId1,long humanId2 ){
        if(checkId(humanId1) && checkId(humanId2)){
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }
    public boolean setWedding(Human human1, Human human2){
        if(human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }else{
            return false;
        }
    }
    private boolean checkId(long id){
        return id < countPeople && id >= 0;
    }
    public Human getById(long id){
        if (checkId(id)) {
            for (Human human : humanList) {
                if(human.getId() == id){return human;}
            }
        }
        return null;
    }@Override
    public String toString() { return getInfo();}
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }  
    // protected void sortByName(){
    //     Collection.sort(humanList);
    // }
    
    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(humanList);
    }
    public void sortByBirthDate(){
        humanList.sort(new ByBirshDateSort());
    }
    public void sortByGenger(){
        humanList.sort(new ByGengerSort());
    }
    public void sortByName(){
        humanList.sort(new ByNameSort());
    }
}