public class Main {
    public static void main(String[] args) {
        /*
        필요한 객체
        - coffee, tea : product 클래스 상속
        - productRepository : 프로덕트들이 담겨 있는 클래스
        - kiosk : 메인 로직을 담당
        - discount : 할인을 담당
         */

        Kiosk kiosk = new Kiosk();
        kiosk.operate();
    }
}