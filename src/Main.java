import discount.CozDiscountCondition;
import discount.DiscountCondition;

public class Main {
    public static void main(String[] args) {
        /*
        필요한 객체
        - coffee, tea : product 클래스 상속
        - productRepository : 프로덕트들이 담겨 있는 클래스
        - kiosk : 메인 로직을 담당
        - discount : 할인을 담당
         */


        // DiscountCondition 이라는 인터페이스를 구현하는 객체를 만들어서 생성자를 통해 주입
        // Kiosk( 여기 안에 같은 인터페이스를 구현하는 다른 할인 조건의 객체를 넣으면 똑같이 실행  )
        // 하지만 이것만으로는 아직 완성되지 않았다 추가적으로 더 구현해줘야함
        Kiosk kiosk = new Kiosk(new CozDiscountCondition(500));
        kiosk.operate();
    }
}