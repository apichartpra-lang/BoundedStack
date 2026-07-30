
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;


/**
 * Test runner 
 */
public class BoundedStackTest {

    private static int passed = 0;
    private static int failed = 0;

    /** helper กลาง — พิมพ์ PASS/FAIL และนับผลให้เอง */
    private static void check(String name, boolean condition) {
        if (condition) {
            passed++;
            System.out.println("[PASS] " + name);
        } else {
            failed++;
            System.out.println("[FAIL] " + name);
        }
    }

    public static void main(String[] args) {
        boolean assertsOn = false;
        assert assertsOn = true;
        if (!assertsOn) {
            System.out.println("WARNING: assertions disabled"
                    + " - re-run with: java -ea BoundedStackTest\n");
        }

        System.out.println("=== BoundedStack Test Suite ===\n");

        testCreators();
        testAdd();
        testPop() ;
        
        testObservers();
         testProducer();
         testExposure();

        System.out.println("\n=== Summary ===");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
        System.out.println("Total : " + (passed + failed));
        System.out.println(failed == 0 ? "ALL TESTS PASSED" : "SOME TESTS FAILED");

        if (failed > 0) {
            System.exit(1);
        }
    }

    // 1.Category =--Creators--=
    private static void testCreators(){
        System.out.println("=== Creators ===") ;

        BoundedStack empty = new BoundedStack(5) ;
        check("new() -> capacity is 5 ", empty.capacity()== 5) ;
        check("new() -> there nothing in the rack  ", empty.isEmpty() == true);
        check("new() -> size is 0", empty.size() == 0) ;
        check("new() -> plateRack is full", empty.isFull() == false) ;

        BoundedStack sb = new BoundedStack(3, Arrays.asList("Plate A", "Plate B", "Plate C")) ;
        check("new() -> size 3", sb.size() == 3 );
        check("new() -> top plate is Plate C", sb.peek().equals("Plate C")) ;
    }

    // 2.Category =--Mutator--= Push
    private static void testAdd(){
        System.out.println("=== Push ===") ;

        BoundedStack b1 = new BoundedStack(3);
        b1.push("Plate A");
        check("push('Plate A') -> size is 1 ", b1.size() == 1) ;
        check("push('Plate A') -> top plate is Plate A", b1.peek().equals("Plate A"));

        b1.push("Plate B");
        check("push('Plate B') -> size is 2 ", b1.size() ==2) ;
        check("push('Plate B') -> top plate is Plate B", b1.peek().equals("Plate B"));

        b1.push("Plate C");
        check("push('Plate C') -> size is 3", b1.size() ==3);
        check("push('Plate C') -> top Plate is Plate C", b1.peek().equals("Plate C"));

    }
    // --- Mutator: pop ทั้งกรณีมีข้อมูลและ stack ว่าง ---
private static void testPop() {
    System.out.println("\n-- Pop --");

    // กำหนด capacity = 5 และใส่จานเริ่มต้น ["A", "B", "C"] ( C คือจานใบบนสุด )
    BoundedStack R1 = new BoundedStack(5, Arrays.asList("A", "B", "C"));

    check("pop() -> returns C", R1.pop().equals("C"));
    check("pop -> size decreases", R1.size() == 2);
    check("pop -> plate is gone", !R1.contains("C"));
    check("pop keeps the others in order",
            R1.toString().equals("[B, A]")); // toString() เรียงจากบนลงล่าง [B, A]

    // boundary: ดึงออกทีละใบจนหมด
    check("pop B -> returns B", R1.pop().equals("B"));
    check("pop A -> returns A", R1.pop().equals("A"));
    check("pop all -> empty", R1.size() == 0);

    // boundary: pop บน stack ที่ว่างเปล่า — ต้องโยน EmptyStackException
    try {
        R1.pop();
        check("pop on empty stack -> throws EmptyStackException", false); // ถ้าไม่โยน exception ถือว่าผิด
    } catch (EmptyStackException e) {
        check("pop on empty stack -> throws EmptyStackException", true);  // โยน exception ถูกต้อง
    }
}
// --- Observer ต้องไม่มี side effect ---
    private static void testObservers() {
        System.out.println("\n-- Observers --");
        BoundedStack b = new BoundedStack(3, Arrays.asList("Plate A", "Plate B"));

        check("contains('Plate A') -> true", b.contains("Plate A"));
        check("contains('Plate Z') -> false", !b.contains("Plate Z"));

        // Exception: peek จากสแต็กว่าง
        BoundedStack empty = new BoundedStack(3);
        boolean errEmptyPeek = false;
        try {
            empty.peek();
        } catch (EmptyStackException e) {
            errEmptyPeek = true;
        }
        check("peek on empty stack -> throws EmptyStackException", errEmptyPeek);
        int sizeBefore = b.size();
    b.contains("Plate A");
    b.peek();
    check("only peek on plate rack -> size unchanged", b.size() == sizeBefore);
    }
    // 5. Category =--Producer--=
    private static void testProducer() {
        System.out.println("=== Producer ===");

        BoundedStack original = new BoundedStack(3, Arrays.asList("Plate A", "Plate B"));
        BoundedStack copied = original.copy();

        check("copy() -> size is same", copied.size() == original.size());
        check("copy() -> top plate is same", copied.peek().equals(original.peek()));

        // ตรวจสอบ Independence (ความเป็นอิสระต่อกัน)
        original.push("Plate C");
        check("push to original -> copied size unchanged", copied.size() == 2);
        check("original size increased", original.size() == 3);
    }
    // 6. Category =--Rep Exposure--=
    private static void testExposure() {
        System.out.println("=== Rep Exposure ===");

        List<String> externalList = new ArrayList<>(Arrays.asList("Plate A", "Plate B"));
        BoundedStack stack = new BoundedStack(5, externalList);

        // แอบแก้ externalList จากข้างนอก
        externalList.add("Hacked Plate");

        // ขนาดของ stack ข้างในต้องไม่เปลี่ยนตาม
        check("modifying external list -> stack size unchanged", stack.size() == 2);
        check("modifying external list -> stack does not contain Hacked Plate", !stack.contains("Hacked Plate"));
    }
}
