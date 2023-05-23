package logBook;


import logBook.Borrower;

import java.util.ArrayList;
import java.util.List;

public class Borrowers {
    private ArrayList<Borrower> borrowers = new ArrayList<>();


    public void addBorrower(Borrower borrower) {
        borrowers.add(borrower);
    }

    public void viewAllBorrowers() {
        for (Borrower borrower: borrowers) {
            System.out.println(borrower);
        }
    }

    public List<Borrower> searchByName(String name) {
        ArrayList<Borrower> foundBorrowers = new ArrayList<>();
        for (Borrower borrower : borrowers) {
            if (borrower.getName().equals(name)) {
                foundBorrowers.add(borrower);
            }
        }
        return foundBorrowers;
    }

    public boolean deleteBorrowerByName(String name) {
        List<Borrower> targetBorrowers = searchByName(name);
        for (Borrower targetBorrower: targetBorrowers) {
            borrowers.remove(targetBorrower);
        }
        return !targetBorrowers.isEmpty();
    }

    public boolean isEmpty() {
        return borrowers.isEmpty();
    }


}
