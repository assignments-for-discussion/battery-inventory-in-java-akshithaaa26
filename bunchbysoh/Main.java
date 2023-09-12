
package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    int ratedCapacity = 120; 

    for (int capacity : presentCapacities) {
    
      double soh = (double) capacity / ratedCapacity * 100;

      // Classify batteries
      if (soh >= 80.0) {
        counts.healthy++;
      } else if (soh >= 63.0) {
        counts.exchange++;
      } else {
        counts.failed++;
      }
    }

    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {115, 118, 80, 95, 91, 72};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);

    // Print the counts
    System.out.println("Healthy: " + counts.healthy);
    System.out.println("Exchange: " + counts.exchange);
    System.out.println("Failed: " + counts.failed);

    assert counts.healthy == 2;
    assert counts.exchange == 3;
    assert counts.failed == 1;
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
