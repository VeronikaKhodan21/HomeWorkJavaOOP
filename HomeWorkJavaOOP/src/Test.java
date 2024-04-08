import java.time.LocalDate;

import familyTree.FamilyTree;
import humanClass.Gender;
import humanClass.Human;
import writer.TreeFamilyInFile;

public class Test {
    public static FamilyTree TestTreeGo(){
        FamilyTree tree = new FamilyTree();
        Human vana = new Human("Ваня", Gender.Male, LocalDate.of(2000, 3, 22));
        Human vika = new Human("Вика", Gender.Female, LocalDate.of(2000, 5, 22));
        tree.add(vika);
        tree.add(vana);
        tree.setWedding(vana, vika);
        return tree;
    }
    public static void main(String[] args) {
        String pl = "C:\\Users\\roman.khodan\\Desktop\\GeekBrains2023_2024Huka\\JAVA\\HmWroop\\HomeWorkJavaOOP\\TreeBook.txt";
       // FamilyTree tree = TestTreeGo();
        //System.out.println(tree);
        
        //TreeFamilyInFile.serializableToTree(tree, pl); //Семью в файл
        FamilyTree tree1 = TreeFamilyInFile.deSerializableToTree(pl); //Семью из файло
        System.out.println(tree1);
    }
}
