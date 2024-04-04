import java.time.LocalDate;

import Human.Gender;
import Human.Human;
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
        FamilyTree tree = TestTreeGo();
        System.out.println(tree);
    }
}
