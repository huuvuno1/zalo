package javacore;

public class CompareImpl implements MyComparator{
    @Override
    public int compare(Integer i1, Integer i2) {
        return i1 - i2;
    }
}
