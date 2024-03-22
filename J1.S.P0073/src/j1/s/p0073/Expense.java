/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0073;

/**
 *
 * @author dangl
 */
public class Expense {
    private int ID;
    private String date;
    private double Quantity;
    private String content;

    public Expense() {
    }

    public Expense(int ID, String date, double Quantity, String content) {
        this.ID = ID;
        this.date = date;
        this.Quantity = Quantity;
        this.content = content;
    }
    

    public int getID() {
        return ID;
    }

    public void setID(int includesID) {
        this.ID = ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double Quantity) {
        this.Quantity = Quantity;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    
    
    
}
