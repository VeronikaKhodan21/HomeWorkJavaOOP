
package writer;
import java.io.Serializable;
import familyTree.*;
public class TreeFamilyInFile implements Serializable{
    private TreeFamilyInFile(){}
    public static  boolean serializableToTree(FamilyTree tr, String plaseFile){
        try {
            FileHandler fh = new FileHandler();
            fh.save(tr, plaseFile);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static FamilyTree deSerializableToTree(String plaseFile) {
        try {
            FileHandler fh = new FileHandler();
            FamilyTree tree = (FamilyTree)fh.read(plaseFile);
            return tree;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}