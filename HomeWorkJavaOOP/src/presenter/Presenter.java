package presenter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import model.familyTree.FamilyTree;
import model.humanClass.Gender;
import model.livingBegin.LivingBeingInterf;
import model.service.Service;
import view.View;

public class Presenter<E extends LivingBeingInterf> {
    private View view;
    private Service service;

    
    public Presenter(View view) {
        this.view = view;
        service = new Service<>();
    }
    public void addToFamilyTree(String name, LocalDate dob, LocalDate dod, Gender gender) {
        service.addToFamilyTree(name, gender,dob, dod );
    }
    public void getFamilyTree() {
        List<E> res = service.getFamilyTreeList();
        for (E e : res) {
            view.getAnswer("\n"+e.toString());
        }
        
    }
    private void printFamilyTree(List<E> familyTree){
        for (E e : familyTree) {
            view.getAnswer("\n"+e.toString());
        }
    }
    public void sortByName() {
        List<E> res = service.sortByName();
        this.printFamilyTree(res);
    }
    public void writeTreeFamily(String fileName) {
        //service.treeInFile(fileName);
        if (service.treeInFile(fileName) ) {
            view.getAnswer("Семья записана\n");
        } else {
            view.getAnswer("Семья не записана\n");
        }
    }
    public void readTreeFamily(String fileName) {
        
        FamilyTree tree = service.treeInputFile(fileName); 
        if (tree != null) {
            Service anotherService = new Service<>(tree);
            for (Object name : anotherService.getListOfName()) {
                view.getAnswer((String) name);
            }
        } else {
            view.getAnswer("Не удалось установить семью...");
        }
    }
    public void sortByDateBirth() {
        List<E> res =service.sortByBirthDate();
        this.printFamilyTree(res);
    }
    public void sortByGenger() {
        List<E> res =service.sortByGenger();
        this.printFamilyTree(res);
    }
    public void sortByAge() {
        List<E> res = service.sortByBirthDate();
        this.printFamilyTree(res);
    }
}
