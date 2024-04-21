package model.service;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.logging.FileHandler;
import java.util.List;

import model.familyTree.FamilyTree;
import model.humanClass.Gender;
import model.humanClass.Human;
import model.livingBegin.LivingBeingInterf;
import model.writer.TreeFamilyInFile;

public class Service<E extends LivingBeingInterf<E>> {
    private long genId;
    private FamilyTree<E> livingList;
    Class clazz;
    //private FileHandler fh;
    public Service(FamilyTree<E> livingList) {
        this.livingList = livingList;
    }
    public Service(Class clazz) {
        this.livingList = new FamilyTree<>();
        this.clazz = clazz;
    }
    public Service() {
        this.livingList = new FamilyTree<>();
    }
    public boolean addToFamilyTree(String name, LocalDate birtDate, Gender gender) {
        Human human = new Human(name ,gender, birtDate);
        human.setId(genId++);
        livingList.add((E) human);
        return true;
    }


    public boolean addToFamilyTree(String name,LocalDate birtDate, Gender gender, E father, E mother) {
        Human human = new Human(name,gender,  birtDate,  (Human) father, (Human) mother);
        human.setId(genId++);
        livingList.add((E) human);
        return true;
    }

    public boolean addToFamilyTree(String name,Gender gender, LocalDate birtDate , LocalDate deatDate ) {
        Human human = new Human(name,  gender,birtDate , deatDate );
        human.setId(genId++);
        livingList.add((E) human);
        return true;
    }
    public void setParentsForSubject(String nameForSearching, E parent) {
        if (findByName(nameForSearching) != null) {
            findByName(nameForSearching).addParent(parent);
        }
    }
    public E findByName(String name) {
        E  livingBeing = livingList.getByName(name);
        if (livingBeing != null) return livingBeing;
        //System.out.println("Subject with name: " + name + " is not found");
        return null;
    }
    public List<E> sortByGenger() {
        return livingList.sortByGenger();
    }
    public List<E> sortAge() {
        return livingList.sortByAge();
    }
    public List<E> sortByBirthDate() {
        return livingList.sortByBirthDate();
    }

    public List<E> sortByName() {
        List<E> a =  livingList.sortByName();
        return a;
    }
    public boolean treeInFile(String nameFile){
        if(nameFile != null){
            TreeFamilyInFile.serializableToTree(livingList, nameFile);
        return true;
        }else{
            return false;
        }
        
    }
    public List<E> getFamilyTreeList() {
        return livingList.getFamilyTreeList();
    }
    public FamilyTree<E> getFamilyTree() {
        return livingList;
    }
    public FamilyTree<E> treeInputFile(String filrName){
        return TreeFamilyInFile.deSerializableToTree(filrName); 
        
    }
    public List<String> getListOfName(List<E> inputList) {
        return livingList.getListOfName(inputList);
    }
    public List<String> getListOfName() {
        return this.getFamilyTree().getListOfNames();
    }
}
