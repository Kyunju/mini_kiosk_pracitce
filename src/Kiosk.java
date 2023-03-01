import discount.DiscountCondition;
import products.Product;
import products.ProductRepository;

import java.util.Scanner;

public class Kiosk {
    ProductRepository productRepository = new ProductRepository();
    DiscountCondition discountCondition;
    Scanner scanner = new Scanner(System.in);

    // 의존성 주입을 위한 생성자
    /* 여기서 직접 cozDiscountCondition 객체를 생성하게 되면
    *  나중에 할인 조건이 바뀌거나 할 때 변화하기가 어렵다
    *  객체간의 결합도, 의존도를 낮추기 위해서
    *  의존성 주입을 해줘야 하는데
    *  지금 같은 경우 의존성이 주입될 때 .discount 라는 메소드를 무조건 가지고 있어야 하며
    *  다형성을 통해서 다른 타입의 객체가 들어와도 상위 참조변수로 할당하여 각각 다른 기능을
    *  수행하게 끔 해야함
    * */
    public Kiosk(DiscountCondition discountCondition) {
        this.discountCondition = discountCondition;
    }


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
        int price = discountCondition.discount(orderedMenu.getPrice());
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
