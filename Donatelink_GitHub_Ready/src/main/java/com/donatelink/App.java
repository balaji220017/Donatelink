package com.donatelink;

import com.donatelink.dao.DonationDAO;
import com.donatelink.model.Donation;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        DonationDAO dao = new DonationDAO();
        System.out.println("=== Existing donations ===");
        List<Donation> list = dao.listAll();
        for (Donation d : list) {
            System.out.println(d);
        }

        System.out.println("\nInserting new donation (demo)...\n");
        Donation newD = new Donation();
        newD.setUserId(1);
        newD.setAmount(250.00);
        newD.setNote("Donation from demo");
        dao.insert(newD);

        System.out.println("\n=== After insert ===");
        dao.listAll().forEach(System.out::println);
    }
}
