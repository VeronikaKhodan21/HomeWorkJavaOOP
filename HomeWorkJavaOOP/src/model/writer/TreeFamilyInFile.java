
package model.writer;
import java.io.Serializable;

import model.familyTree.*;
public class TreeFamilyInFile<E> implements Serializable{
    private TreeFamilyInFile(){}

    
    public static  boolean serializableToTree(FamilyTree tr, String fileName){
        try {
            FileHandler fh = new FileHandler();
            fh.save(tr, fileName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static FamilyTree deSerializableToTree(String fileName) {
        try {
            FileHandler fh = new FileHandler();
            FamilyTree tree = (FamilyTree)fh.read(fileName);
            return tree;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}