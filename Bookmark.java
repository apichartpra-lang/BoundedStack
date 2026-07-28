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
    // // private void checkRep() {
    //     assert songs != null : "songs is not null" ; //เพลงต้องมีจริงและไม่เป็น null
    //     assert songs.size() <= MAX_SONGS ; //ขนาดเพลงต้องไม่เกินขนาดที่กำหนด
    //     Set<String> seen = new HashSet<>() ;
    //     for (String s : songs) {
    //         assert s != null ; //เพลงต้องไม่เป็น null
    //         assert s != "" ; //เพลงต้องไม่เป็นสตริงว่าง
    //         assert seen.add(s) ; //หาเพลงซ้ำ
    //     }
    // }



    // =-----Creator-----=

    // public HistoryBrowser() {
    //     this.pages = new ArrayList<>();
    //     checkRep();
    // }


    /**
     * TODO 5: Creator ตัวที่สอง
     * สร้าง ListBookmarkจากรายการที่เพิ่มมา
     * 
     * ระวัง: ห้ามเก็บ reference ของ initial ตรง ๆ (rep exposure!)
     * @param initial Bookmark ต้องไม่ซ้ำและไม่เกิน Max_BookmarkSize
     * @throws IllegalArgumentException ถ้า initial ผิดเงื่อนไข
     */
// public Playlist(List<String> initial) {

//             if(initial == null) throw new IllegalArgumentException();
//             if(initial.size()>MAX_BookmarkSize) throw new IllegalArgumentException();
//             Set<String> seen = new HashSet<>();
//             for(String s: initial){
//                 if(s==null) throw new IllegalArgumentException();
//                 if(s=="")throw new IllegalArgumentException();
//                 if(!seen.add(s)) throw new IllegalArgumentException();
//             }

//             this.songs = new ArrayList<>(initial);   // แก้บรรทัดนี้
//             checkRep();
//}


        // ===== Mutators =====
/**
         * TODO 6: เพิ่มBookmarkต่อท้ายList
         *
         * @param page ชื่อเพลง ต้องไม่เป็น null และไม่เป็นสตริงว่าง
         * @return true ถ้าเพิ่มสำเร็จ, false ถ้ามีเพลงนี้อยู่แล้วหรือเต็มแล้ว
         * @throws IllegalArgumentException ถ้า page เป็น null หรือสตริงว่าง
         */
//  public boolean add(String List) {
            
//         if(List==null || List =="") throw new IllegalArgumentException();
//         if(List.contains(Lis9t)) return false ;
//         if(List.size()==MaxBookmarkSize) return false;


//             List.add(List) ;
//             return true ;   // แก้บรรทัดนี้
//         }
     /**
         * TODO 7: ลบเพลงออกจากเพลย์ลิสต์
         *
         * @param List ชื่อเพลงที่ต้องการลบ
         * @return true ถ้าลบสำเร็จ, false ถ้าไม่พบเพลงนี้
         */
        // public boolean remove(String song) {
        //     if(!List.contains(List))  return false;

        //     List.remove(song);
        //     return true ;   // แก้บรรทัดนี้
        // }
  // ===== Observers =====

        /**
         * TODO 8: คืนจำนวนเพลงในเพลย์ลิสต์
         */
        // public int size() {
        //     return page.size();   // แก้บรรทัดนี้
        // }

/**
         * TODO 9: ตรวจว่ามีBookmarkนี้อยู่หรือไม่
         */
        // public boolean contains(String song) {
        //     return List.contains(List);   // แก้บรรทัดนี้
        // }

        // ===== Producer =====

        /**
         * TODO 11: จัดการเรียงBookmarkตามลำดับตัวอักษรในภาษาอังกฤษ
         *
         * ระวัง: ห้ามแก้เพลย์ลิสต์เดิม (this) เด็ดขาด
         *
         * @return เพลย์ลิสต์ใหม่ที่สลับลำดับแล้ว
         */
        // public List shuffled() {
        //     List<String> copy = new ArrayList<>(songs);
        //     Collections.shuffle(copy);
        //     return new Playlist(copy);   // แก้บรรทัดนี้

 }
