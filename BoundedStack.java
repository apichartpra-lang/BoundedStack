import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
public class BoundedStack{
/**
 * BoundedStack - ADT แทนการเก็บจาน
 * 
 * ค่านามธรรม (A): ลำดับของจานที่วางซ้อนกัน โดยเรียงจากใบล่างสุดใบบนสุด เช่น [จานใบแรกอยู่ล่างสุด, จานใบสุดท้ายอยู่บนสุด]
 * 
 * ตัวอย่างการใช้งาน
 *  BoundedStack plateRack = new BoundedStack(5) ;
 *  plateRack.push("Plate A") ;
 *  plateRack.push("Plate B") ;
 *  System.out.println(plateRack.peek()) ; // จะแสดงให้เห็น "Plate B" ที่เป็นจานใบล่าสุดที่ใส่เข้าไป
 *  plateRack.pop() ;                      // จะหยิบจานใบบนสุดออกไป ("Plate B")
 * 
 */
    public static final int Max_Capacity = 30; //ความจุของที่เก็บ
    private final int capacity;

    //Representation
    private final List<String>plates;

    
    //Abstraction function
    //Af(plates) = plate ในที่นี้จะหมายถึงจำนวนจานที่เราเก็บแล้วจะเข้าไปในตัวแปร Max_Capacity


    /** Representation Invariant
     * plates ต้องไม่เป็น null
     * ไม่มีสมาชิกใน plates ที่เป็น  null
     * ไม่มีสมาชิกใน plates ที่เป็นสตริงว่าง
     * plates.size <= Max_Capacity (30)
     */


    //Safety from rep exposure:
    //   - plates เป็น private และ final จึงไม่มีทางถูกแทนที่ด้วย reference อื่นจากภายนอก
    //   - constructor คัดลอกข้อมูลเข้ามาใหม่ (new ArrayList<>(initial)) ไม่เก็บ reference ตรง ๆ
    //   - ไม่มี observer ตัวใดคืน reference ของ plates ออกไปโดยตรง (pop/peek/toString คืนค่าที่ปลอดภัย)
    

    

/**
 * ตรวจสอบว่า RI ต้องเป็นจริงเสมอ
 * 
 */ 
private void checkRep() {
    assert plates != null : "plateRack must not be null " ;
    assert capacity > 0 : "capacity must have available space" ;
    assert plates.size() <= Max_Capacity : "there too many plates" ;

    for(String p : plates) {
        assert p != null : "plate is null" ;
        assert !p.isEmpty() : "plate is empty" ;
    }
}
     // =-----Creator-----=
 /**
     * สร้าง BoundedStack ว่าง (ยังไม่มีจานซ้อนอยู่)
     * 
     * @param capacity จำนวนจานสูงสุดที่สามารถเก็บได้
     * @throws IllegalArgumentException ถ้า capacity <= 0
     */
    public BoundedStack() {
        this.plates = new ArrayList<>();
        checkRep();
        
    }

        /**
         * สร้าง Bounded stack มาโดย intial.get(0) คืิอจานล่างสุดและจานใบท้าย 
         * 
         * @param initial ลำดับจานเริ่มต้น ต้องไม่มีจานเริ่มต้นที่เป็น null/ว่าง และไม้เกิน Max_Capacity
         * @throws IllegalArguementException ถ้า intial ผืดเงื่อนไข\
         * 
         */
            public BoundedStack(List <String> initial){
            if(initial == null )throw new IllegalArgumentException();
            if(initial.size()>Max_Capacity) throw new IllegalArgumentException();
            Set<String> seen = new HashSet<>();
            for(String b:initial){
                if(b==null)throw new IllegalArgumentException();
                if(b.isEmpty())throw new IllegalArgumentException();
                if(!seen.add(b))throw new IllegalArgumentException();
            }
            this.plates = new ArrayList<>(initial);
            checkRep();
        }

}



    // ===Mutator===
    
    /**
     * 
     * @param plate จาน ต้องไม่เป็น null และไม่เป็นช่องว่าง
     * @throws IllegalArgumentException ถ้า ที่เก็บจานเต็มแล้ว
     * @throws IllegalArgumentException ถ้า จาน เป็น null หรือเป็นช่องว่าง
     */
    // public void push(String plate) {
    //     if(plate == null || plate.isEmpty()) throw new IllegalArgumentException() ;
    //     if(plates.size() == Max_Capacity || plates.contains(plate)) throw new IllegalArgumentException("PlateRack is full") ;

    //     plates.push(plate) ;
    //     checkRep() ;
    // }
    /**
     * ลบจาน
     * 
     */
    // public String pop() {
    //     if (plates.isEmpty()) throw new EmptyStackException();
 
    //     String top = plates.remove(plates.size() - 1);
    //     checkRep();
    //     return top;



}