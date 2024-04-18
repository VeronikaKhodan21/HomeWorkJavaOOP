import java.time.LocalDate;

import familyTree.FamilyTree;
import humanClass.Gender;
import humanClass.Human;
import writer.TreeFamilyInFile;

public class Test {
    public static FamilyTree<Human> TestTreeGo(){
        FamilyTree<Human> tree = new FamilyTree();
        Human vana = new Human("Ваня", Gender.Male, LocalDate.of(1991, 3, 22));
        Human vika = new Human("Вика", Gender.Female, LocalDate.of(2001, 5, 22));
        tree.add(vana);
        tree.add(vika);
        tree.setWedding(vana, vika);
        
        Human kiril = new Human("Кирил", Gender.Male, LocalDate.of(2011, 5, 17), vika, vana);
        Human anna = new Human("Анна", Gender.Female, LocalDate.of(2010, 12, 12), vika, vana);
        tree.add(anna);
        tree.add(kiril);

        Human vlad = new Human("Влад", Gender.Male, LocalDate.of(1987, 4, 1));
        vlad.addChild(vana);
        tree.add(vlad);
        return tree;
    }
    public static void main(String[] args) {
        String pl = "C:\\Users\\roman.khodan\\Desktop\\GeekBrains2023_2024Huka\\JAVA\\HmWroop\\HomeWorkJavaOOP\\TreeBook.txt";
        FamilyTree<Human> tree = TestTreeGo();
        System.out.println(tree);
        tree.sortByGenger();
        System.out.println(tree);
        //TreeFamilyInFile.serializableToTree(tree, pl); //Семью в файл
        //FamilyTree tree1 = TreeFamilyInFile.deSerializableToTree(pl); //Семью из файло
        //System.out.println(tree1);
    }
}
