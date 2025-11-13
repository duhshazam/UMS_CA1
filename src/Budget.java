
public class Budget {
    private double totalBudget;
    private double allocatedAmount;
    private double remainingBudget;

    // Constructor - Budget only created with Department
    public Budget(double initialBudget) {
        this.totalBudget = initialBudget;
        this.allocatedAmount = 0;
        this.remainingBudget = initialBudget;
    }

    //  Control budget allocation
    public boolean allocateBudget(double amount) {
        if (amount <= remainingBudget) {
            allocatedAmount += amount;
            remainingBudget -= amount;
            System.out.println("[Budget] Allocated: $" + amount + " | Remaining: $" + remainingBudget);
            return true;
        } else {
            System.out.println("[Budget] INSUFFICIENT FUNDS! Requested: $" + amount + ", Available: $" + remainingBudget);
            return false;
        }
    }

    // Get budget info
    public double getTotalBudget() { return totalBudget; }
    public double getAllocatedAmount() { return allocatedAmount; }
    public double getRemainingBudget() { return remainingBudget; }

    // budget summary
    public void displayBudgetInfo() {
        System.out.println("  Total Budget: $" + totalBudget);
        System.out.println("  Allocated: $" + allocatedAmount);
        System.out.println("  Remaining: $" + remainingBudget);
    }
}
