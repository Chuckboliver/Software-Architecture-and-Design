package com.solid.lsp;

public class Square extends Shape {

    public int sides;
    Square(int side) {
        this.setSide(side);
    }
    
    public void setSide(int sides) {
        this.sides = sides;
    }

    public int getArea() {
        return this.sides * this.sides;
    }
    
}
