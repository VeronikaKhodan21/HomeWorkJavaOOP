package sortFamily;

import java.util.Comparator;

import humanClass.Human;

public class ByBirshDateSort implements Comparator<Human> {
    @Override 
    public int compare(Human o1, Human o2){return o1.getBirtDate().compareTo(o2.getBirtDate());}
}
