package com.donatelink.model;

public class Donation {
    private int id;
    private Integer userId;
    private double amount;
    private String note;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    @Override
    public String toString() {
        return "Donation{id="+id+", userId="+userId+", amount="+amount+", note='"+note+"'}";
    }
}
