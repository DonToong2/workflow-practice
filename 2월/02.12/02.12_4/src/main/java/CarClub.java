public class CarClub {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        String insuranceName = memberService
                .getMember("Ayden") // Optional<Member> 반환 -> getMember
                .flatMap(Member::getCar) // Optional<Car> 로 평탄화 -> flatMap -> Optional<Car>
                .flatMap(Car::getInsurance) // Optional<Insurance> 로 평탄화 -> Optional<Insurance>
                .map(Insurance::getCompanyName) // String으로 변환 -> map 사용
                .orElse("Not result")// null 값이 포함되어 있다면 "Not result" 로 처리 ->.orElse
        ;
        System.out.println(insuranceName);
    }
}
