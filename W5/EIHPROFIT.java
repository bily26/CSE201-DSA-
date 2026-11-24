import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class EIHPROFIT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();// nOfProducts
        int k = sc.nextInt();//

        List<Item> lItems = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int stt = sc.nextInt();
            String name = sc.next();
            int cost = sc.nextInt(), price = sc.nextInt(), quantity = sc.nextInt();
            Item item = new Item(stt, name, cost, price, quantity);
            lItems.add(item);
        }

        lItems.sort((i1, i2) -> Long.compare(i2.profit, i1.profit));
        // items.get(k-1) same as the array
        long pivot = (k < n) ? lItems.get(k - 1).profit : -1;
        for (int i = 0; i < lItems.size(); i++) {
            if (lItems.get(i).profit >= pivot) {
                sb.append(lItems.get(i).stt + " " + lItems.get(i).nameItems + " " + lItems.get(i).profit + "\n");
            }
        }
        System.out.println(sb);
    }

    static class Item {
        int stt;
        String nameItems;
        int cost;
        int price;
        int quantity;
        long profit;

        public Item(int stt, String nameItems, int cost, int price, int quantity) {
            this.stt = stt;
            this.nameItems = nameItems;
            this.cost = cost;
            this.price = price;
            this.quantity = quantity;
            getProfit();
        }

        public void getProfit() {
            profit = (cost - price) * (long) quantity;
        }

        @Override
        public String toString() {
            return "%s %s %s".formatted(stt, nameItems, profit);
        }
    }
}
