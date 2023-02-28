package discount;

import java.util.Scanner;

public class CozDiscountCondition {
    // 할인율
    private int discountAmount;

    public CozDiscountCondition(int discountAmount) {
        this.discountAmount = discountAmount;
    }
    // 할인 조건을 물어보는 메서드
    private boolean checkDiscountCondition() {
        System.out.println("코드스테이츠 수강생이십니까? (1)_예 (2)_아니오");
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        if (input == 1) return true;
        return false;
    }

    // 할인 금액을 게산해주는 메서드
    private int calculateDiscount(int price) {
        return price - discountAmount;
    }

    // 할인 여부에 따라 할인을 적용해주는 메서드
    public int discount(int price) {
        if (checkDiscountCondition()) return calculateDiscount(price);
        return price;
    }
}
