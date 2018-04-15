import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.*;

public class PersonalizedCoupons {
    static List<Map<String, Object>> personalizeCoupons(List<Map<String, Object>> coupons, List<String> preferredCategories) {
        List<Map<String, Object>> personalizedCoupons = new ArrayList<>();
        for (Map<String, Object> coupon : coupons) {
            if (preferredCategories.contains(coupon.get("category").toString())) {
                coupon.remove("code");
                float percentage = calculatePercentage((float) coupon.get("itemPrice"), (float) coupon.get("couponAmount"));
                coupon.put("percentage", percentage);
                personalizedCoupons.add(coupon);

            }
        }

        personalizedCoupons.sort((o1, o2) -> {
            float f1 = (float) o1.get("percentage"),
                  f2 = (float) o2.get("percentage");
            if(f1 < f2) return 1;
            else if(f1 > f2) return -1;
            else return 0;
        });

        return personalizedCoupons.subList(0, Math.min(10, personalizedCoupons.size()));
    }

    private static float calculatePercentage(float itemPrice, float couponAmount) {
        return (couponAmount * 100)/itemPrice;
    }

    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        List<String> preferredCategories = Arrays.asList(input.nextLine().split(","));
        List<Map<String, Object>> coupons = new ArrayList<>();
        int lines = Integer.parseInt(input.nextLine());
        IntStream.range(0, lines).forEach(i -> coupons.add(readCoupon(input)));
        List<Map<String, Object>> personalizedCoupons = personalizeCoupons(coupons, preferredCategories);
        personalizedCoupons.stream().forEach(PersonalizedCoupons::printCoupon);
    }

    public static Map<String, Object> readCoupon(Scanner input) {
        String[] couponItems = input.nextLine().split(",");
        Map<String,Object> coupon = new HashMap<>();
        coupon.put("upc", couponItems[0]);
        coupon.put("code", couponItems[1]);
        coupon.put("category", couponItems[2]);
        coupon.put("itemPrice", Float.parseFloat(couponItems[3]));
        coupon.put("couponAmount", Float.parseFloat(couponItems[4]));
        return coupon;
    }

    public static void printCoupon(Map<String, Object> coupon)
    {
        System.out.print("{");
        System.out.print("\"couponAmount\":" +  coupon.get("couponAmount") + ",");
        System.out.print("\"upc\":\"" +  coupon.get("upc") + "\",");
        if(coupon.containsKey("code")) {
            System.out.print("\"code\":\"" +  coupon.get("code") + "\",");
        }
        System.out.print("\"itemPrice\":" +  coupon.get("itemPrice") + ",");
        System.out.println("\"category\":\"" +  coupon.get("category") + "\"}");
    }
}
