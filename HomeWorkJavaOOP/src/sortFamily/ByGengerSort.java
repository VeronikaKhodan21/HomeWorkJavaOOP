package sortFamily;

import java.util.Comparator;

import humanClass.Human;
import livingBegin.LivingBeingInterf;

public class ByGengerSort<E extends LivingBeingInterf> implements Comparator<E>{
    @Override 
    public int compare(E o1,E o2){return o1.getGender().compareTo(o2.getGender());}
}
