package HistoryBrowser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
// นายสิรภพ โตสุวรรณ์ 6821651841 เลขที่ 70
// นายอภิชาติ ประเสริฐเวศยากร 6821651892 เลขที่ 73 

/**
 * Bookmark — ADT แทนรายการบุ๊คมาร์คที่ผู้ใช้เก็บบันทึกไว้
 *
 * ค่านามธรรม (A): ลำดับของเว็บไซต์ในบุ๊คมาร์ค เช่น [facebook.com, valorant.com, roblox.com]
 *
 * ตัวอย่างการใช้งาน:
 *     Bookmark b = new Bookmark();
 *     b.add("valorant.com");
 *     b.add("roblox.com");
 *     System.out.println(b.size());  // 2
 */


public class Bookmark {
    public static final int MaxBookMarkSize = 60;

    //===reprensentation===
    private final List <String> pages;

    // Abstraction Function:
    //   AF(pages) = pages ในที่นี้จะหมายถึงจำนวนเว็บไซต์ต่าง ๆ ที่เรา bookmark ไว้แล้วมันจะเข้าไปเกมในตัวแปร MaxBookMarkS
    
    // TODO 2: เขียน Representation Invariant ตรงนี้
    // Representation Invariant:
    //ต้องมีเว็บไซต์ อยู่จริงและ(ไม่เป็น null)
    //ไม่มีชื่อเว็บไซต์ ที่เป็นสตริงว่าง
    //เว็บไซต์ห้ามซ้ำกัน
    //เว็บไซต์ที่เก็บได้มีได้ไม่เกิน MaxBookMarkSize (60) หน้า


    // TODO 3: เขียน Safety from rep exposure:
    //   ซ่อนตัวแปรที่เก็บหน้าไว้ใน private และห้ามเปลี่ยนด้วย final
    //   กำหนดขนาดตัวเก็บไว้อย่างชัดเจนและเปลี่ยนไม่ได้ด้วย final 
    //   


    // TODO 4: เขียน checkRep(
    //แปลง RI ทุกข้อเป็น assert หนึ่งบรรทัด พร้อมข้อความอธิบาย
       /**
     * แปลง RI ทุกข้อเป็น assert หนึ่งบรรทัด พร้อมข้อความอธิบาย
     */
     private void checkRep() {
        assert pages != null : "pages is not null" ; // เว็บไซต์ต้องมีจริงและไม่เป็น null
        assert pages.size() <= MaxBookMarkSize ; //ขนาดเว็บไซต์ต้องไม่เกินขนาดของบุ๊คมาร์คที่กำหนด
        Set<String> seen = new HashSet<>() ;
        for (String p : pages) {
            assert p != null ; //เว็บไซต์ไม่เป็น null
            assert p != "" ; //เว็บไซต์ต้องไม่เป็นสตริงว่าง
            assert seen.add(p) ; //หาเว็บไซต์
        }
    }



    // =-----Creator-----=

    /**
     * สร้างบุ๊คมารก์ว่าง
     */
                public Bookmark() {
                this.pages = new ArrayList<>();
                checkRep();
    }




    /**
     * TODO 5: Creator ตัวที่สอง
     * สร้าง ListBookmarkจากรายการที่เพิ่มมา
     * 
     * ระวัง: ห้ามเก็บ reference ของ initial ตรง ๆ (rep exposure!)
     * @param initial Bookmark ต้องไม่ซ้ำและไม่เกิน Max_BookmarkSize
     * @throws IllegalArgumentException ถ้า initial ผิดเงื่อนไข
     */
        public Bookmark(List<String> initial) {

            if(initial == null) throw new IllegalArgumentException();
            if(initial.size()>MaxBookMarkSize) throw new IllegalArgumentException();
            Set<String> seen = new HashSet<>();
            for(String b: initial){
                if(b==null) throw new IllegalArgumentException();
                if(b=="")throw new IllegalArgumentException();
                if(!seen.add(b)) throw new IllegalArgumentException();
            }

            this.pages = new ArrayList<>(initial);   // แก้บรรทัดนี้
            checkRep();
}


        // ===== Mutators =====
/**
         * TODO 6: เพิ่มBookmarkต่อท้ายList
         *
         * @param page ชื่อเพลง ต้องไม่เป็น null และไม่เป็นสตริงว่าง
         * @return true ถ้าเพิ่มสำเร็จ, false ถ้ามีเพลงนี้อยู่แล้วหรือเต็มแล้ว
         * @throws IllegalArgumentException ถ้า page เป็น null หรือสตริงว่าง
         */
 public boolean add(String page) {
        if(page==null || page =="") throw new IllegalArgumentException();
        if(pages.contains(page)) return false ;
        if(pages.size()==MaxBookMarkSize) return false;


            pages.add(page) ;
            checkRep() ;
            return true ;   // แก้บรรทัดนี้
        }
     /**
         * TODO 7: ลบบุ๊คมาร์ก
         * @param List ชื่อบุ๊คมาร์กที่ต้องการลบ
         * @return true ถ้าลบสำเร็จ, false ถ้าไม่พบบุ๊คมาร์กนี้
         */
        public boolean remove(String page) {
            if(!pages.contains(page))  return false;

            pages.remove(page);
            checkRep() ;
            return true ;   // แก้บรรทัดนี้
        }
  // ===== Observers =====

        /**
         * คืนจำนวนเว็บไซต์ในบุ๊คมาร์ค
         */
        public int size() {
            return pages.size();   // แก้บรรทัดนี้
        }

/**
         *  ตรวจว่ามีเว็บไซต์นี้อยู่ในบุ๊คมาร์คหรือไม่
         */
        public boolean contains(String page) {
            return pages.contains(page);   // แก้บรรทัดนี้
        }

        // ===== Producer =====

        /**
         * TODO 11: จัดการเรียงBookmarkตามลำดับตัวอักษรในภาษาอังกฤษ
         * ระวัง: ห้ามแก้เพลย์ลิสต์เดิม (this) เด็ดขาด
         * @return เพลย์ลิสต์ใหม่ที่สลับลำดับแล้ว
         */
        public Bookmark sortedBookmark() {
            List<String> sortedList = new ArrayList<>(pages);
            Collections.sort(sortedList);
            return new Bookmark(sortedList);   // แก้บรรทัดนี้

 }
 @Override
        public String toString() {
            return pages.toString();
        }
}