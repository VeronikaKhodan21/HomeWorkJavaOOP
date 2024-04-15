package sortFamily;

import java.util.Comparator;

import humanClass.Human;
//import livingBeing.LivingBeingInterf;
public class ByNameSort implements Comparator<Human>{
    @Override 
    public int compare(Human o1,Human o2){return o1.getName().compareTo(o2.getName());}
}

