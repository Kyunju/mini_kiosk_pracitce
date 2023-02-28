import discount.CozDiscountCondition;
import products.Product;
import products.ProductRepository;

import java.util.Scanner;

public class Kiosk {
    ProductRepository productRepository = new ProductRepository();
    CozDiscountCondition cozDiscountCondition = new CozDiscountCondition(500);
    Scanner scanner = new Scanner(System.in);

    // 메뉴를 보여줘야함

    public void operate() {
        // 메뉴 보여주기
        printMenu();

        // 메뉴 선택하기
        Product orderedMenu = chooseMenu();

        // 옵션 적용해주기
        orderedMenu.applyOption();

        // 할인 적용해주기
        // 주문 메뉴 출력하기
        order(orderedMenu);
    }

    private void order(Product orderedMenu) {
        int price = cozDiscountCondition.discount(orderedMenu.getPrice());
        System.out.println("주문이 완료되었습니다.");
        System.out.printf("주문 상품 : %s %s\n", orderedMenu.getName(), orderedMenu.getOptionToString());
        System.out.printf("가격 : %d", price);
    }

    private Product chooseMenu() {
        System.out.println("메뉴를 골라주세요");
        int orderedMenuID = Integer.parseInt(scanner.nextLine());
        Product orderedMenu = productRepository.findByID(orderedMenuID);
        return orderedMenu;
    }

    private void printMenu() {
        System.out.println("#메뉴");
        System.out.println("-".repeat(30));

        for(Product product : productRepository.getProducts()) {
            System.out.printf("(%d) %-15s %d\n", product.getId(), product.getName(), product.getPrice());
        }
        System.out.println("-".repeat(30));
    }
}
