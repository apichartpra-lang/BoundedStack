package HistoryBrowser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Test runner 
 */
public class Bookmarktest {
    
    private static int passed = 0;
    private static int failed = 0;

    /**helper กลาง print PASS/FAIL และนับผลให้เอง */
    private static void check(String name, boolean condition) {
        if ([condition]) {
            passed++ ;
            System.out.println("[PASS]" + name) ;
        } else {
            failed++ ;
            System.out.println("[FAIL" + name) ;
        }
    }

    public static void main(String[] args) {
        boolean asserts0n = false ;
        assert asserts0n = true ;
        if (!asserts0n) {
            System.out.println("WARNING assertions disabled" + "re-run with java -ea Bookmarktest\n");
        }

        System.out.println("=---Bookmark Test Suite---=\n");

        testCreators() ;
        testAdd() ;
        testRemove() ;
        testObservers() ;
        testProducer() ;
        testExposure() ;

        System.out.println("\n=--- Summary ---=") ;
        System.out.println("Passed: " + passed) ;
        System.out.println("Failed: " + failed);
        System.out.println("Total: " + (passed + failed));
        System.out.println(failed == 0 ? "ALL TESTS PASSED" : "SOME TESTS FAILED");

        if(failed > 0) {
            System.exit(1);
        }
    }

    // --- Partition: ว่าง / มีเว็บไซต์ / input ที่ผิดเงื่อนไข ---
    private static void testCreators(){
        System.out.println(" -- Creators --");

        Bookmark empty = new Bookmark() ;
        check("new() -> empty", empty.size() == 0);
        check("new() -> contains nothing", !empty.contains("anything")) ;

        Bookmark b = new Bookmark(Arrays.asList("A", "B", "C")) ;
        check("new(list) -> size 3", b.size() == 3);
        check("new(list) -> contains B", b.contains("B"));
        check("new(list) -> preserves order", b.pages().equals(Arrays.asList("A", "B", "C")))) ;
    }
}
