import org.w3c.dom.ls.LSOutput;

public class SolidRefactoringTest {
    public static void main(String[] args) {
        // 외부에서 부품(의존성 조립)
        Printer myPrinter = new SimplePrinter(); // ISP LSP 적용
        DocumentExporter pdfExporter = new PdfExporter(); // OCP 적용

        // 생성자 주입 -> DIP 적용
        DocumentService service = new DocumentService(myPrinter, pdfExporter);

        // 실행
        service.process("DOC-001");
    }

}

// 기능별로 인터페이스 분리(3개)
interface Printer {
    void printer();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}
// 필요한 인터페이스만 구현 -> class SimplePrinter
class SimplePrinter implements Printer {
    public void printer() {
        System.out.println("단순 프린터로 출력");
    }
}

// class SmartCopier = 복합기 구현(프린트, 스캔, 팩스 가능)
class SmartCopier implements Printer, Scanner, Fax {
    public void printer() {
        System.out.println("복합기로 출력");
    }
    public void scan() {
        System.out.println("스캔");
    }
    public void fax() {
        System.out.println("팩스 전송");
    }
}
// 파일 저장 방식을 전략 패턴으로 분리 interface DocumentExporter
interface DocumentExporter {
    void exporter(String docId);
}

// class pdfExporter
class PdfExporter implements DocumentExporter {
    public void exporter(String docId) {
        System.out.println(docId + " -> pdf 추출 완료");
    }
}
// class HtmlExporter
class HtmlExporter implements DocumentExporter {
    public void exporter(String docId) {
        System.out.println(docId + " -> Html 문서 추출 완료");
    }
}
class DocumentService {
    // 구체적인 클래스가 아닌 인터페이스에 의존
    private final Printer printer;
    private final DocumentExporter exporter;

    // DI 생성자 주입
    public DocumentService(Printer printer, DocumentExporter exporter) {
        this.printer = printer;
        this.exporter = exporter;
    }

    public void process(String docId) {
        System.out.println("문서 로딩 중: " + docId);

        // OCP: 구체적인 if문 없이 인터페이스 동작 수행
        exporter.exporter(docId);

        // DIP: 어떤 프린터가 와도 상관없음
        printer.printer();
    }

}