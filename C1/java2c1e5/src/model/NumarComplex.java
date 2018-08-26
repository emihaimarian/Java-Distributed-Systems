package model;

import annotations.Aleator;

public class NumarComplex {

    @Aleator(max = 500)
    private int i;
    
    @Aleator(max = 1000)
    private int j;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public String toString() {
        return "NumarComplex{" + "i = " + i + ", j = " + j + '}';
    }
    
}