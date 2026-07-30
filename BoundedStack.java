import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;
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

    //Representation
    private final List<String> plates;
    private final int capacity;

    // TODO 1 : เขียน Abstrasction Funtion
    //Abstraction function
    //Af(plates,capacity) = ที่เก็บจานที่มีความจุ capacity ใบ โดยจะเก็บจานทุกใบที่นำเขามาใบไหนเข้ามาก่อนเอาไปไว้ล่างสุดเมื่อจะเอาจานออกจะเอาใบที่เข้าที่หลังสุดหรือก็คือใบบนออกก่อนเข้ากับ Last-In , First-Out

    //TODO 2: เขียน Representation Invariant ตรงนี้ (4 ข้อ)
    /** Representation Invariant
     * plates ต้องไม่เป็น null
     * ไม่มีสมาชิกใน plates ที่เป็น  null
     * ไม่มีสมาชิกใน plates ที่เป็นสตริงว่าง
     * plates.size <= capacity
     */

    // TODO 3 : เขียน Safety from rep exposure
    //Safety from rep exposure:
    //   - plates เป็น private และ final จึงไม่มีทางถูกแทนที่ด้วย reference อื่นจากภายนอก
    //   - constructor คัดลอกข้อมูลเข้ามาใหม่ (new ArrayList<>(initial)) ไม่เก็บ reference ตรง ๆ
    //   - ไม่มี observer ตัวใดคืน reference ของ plates ออกไปโดยตรง (pop/peek/toString คืนค่าที่ปลอดภัย)
    

    

/**
 * TODO 4 : เขียน checkRep()
 * ตรวจสอบว่า RI ต้องเป็นจริงเสมอ
 */ 
private void checkRep() {
    assert plates != null : "plateRack is null " ;
    assert capacity > 0 : "capacity must have available space" ;
    assert plates.size() <= capacity : "there too many plates" ;

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
    public BoundedStack(int capacity) {
        if (capacity <= 0){
            throw new IllegalArgumentException("Capacity might not be negative") ;
        }
        this.capacity = capacity ;
        this.plates = new ArrayList<>();
        checkRep();
        
    }

        /**
         * สร้าง Bounded stack มาโดย initial.get(0) คือจานล่างสุดและจานใบท้าย 
         * TODO 5 : Creator ตัวที่สอง
         * @param initial ลำดับจานเริ่มต้น ต้องไม่มีจานเริ่มต้นที่เป็น null/ว่าง และไม่เกิน capacity
         * @throws IllegalArgumentException ถ้า initial ผิดเงื่อนไข
         * 
         */
            public BoundedStack(int capacity ,List <String> initial){
            if (capacity <= 0) throw new IllegalArgumentException();
            if(initial == null ) throw new IllegalArgumentException();
            if(initial.size() > capacity) throw new IllegalArgumentException();
            for(String b:initial){
            if(b==null)throw new IllegalArgumentException();
            if(b.isEmpty())throw new IllegalArgumentException();
            }
            this.plates = new ArrayList<>(initial);
            this.capacity = capacity;
            checkRep();
        }





    // ===Mutator===
    
    /**
     * TODO 6 : เพิ่มจานเข้าไปในที่วางจานโดยเพิ่มใบบนสุด (โดยใช้ push)
     * @param plate จาน ต้องไม่เป็น null และไม่เป็นช่องว่าง
     * @throws IllegalStateException ถ้า ที่เก็บจานเต็มแล้ว
     * @throws IllegalArgumentException ถ้า จาน เป็น null หรือเป็นช่องว่าง
     */
    public void push(String plate) {
        if(plate == null || plate.isEmpty()) {
            throw new IllegalArgumentException("Plate name cannot be null or whitespace") ;
        }

        if(isFull()){
            throw new IllegalStateException("platRack is Full") ;
        }

        plates.add(plate) ;
        checkRep() ;
    }
    /**
     * TODO 7 : นำจานใบบนสุดออกไป
     * ลบจาน
     * @return ชื่อ/ลายจานที่อยู่บนสุด
     * @throws EmptyStackException ถ้ากองจานว่าง
     */
       public String pop() {
        if (plates.isEmpty()) throw new EmptyStackException();
 
        String top = plates.remove(plates.size() - 1);
        checkRep();
        return top;
    }

      // ===== Observers =====
      /**
       * TODO 8 : ดูจานใบบน
       * ดูจานบนสุดของจานโดยไม่หยิบออก
       * 
       * @return ชื่อ/ลายจานอยู่ที่บนสุด
       * @throws EmptyStackException ถ้ากองจานว่าง
       */
      public String peek(){
        checkRep();
        if(plates.isEmpty()) throw new EmptyStackException();
        return plates.get(plates.size() -1);
      }
        /**
         * คืนจำนวนจานในกอง
         */
        public int size(){
            checkRep();
            return plates.size();
        }
    public int capacity() {
    checkRep();
    return this.capacity;
    }

        /**
         * TODO 9 : ตรวจดูว่าจานในที่เก็บว่างหรือไม่
         * ตรวจว่าจานในกองว่างหรือไม่
         */
        public boolean isEmpty(){
            checkRep();
            return plates.isEmpty();    
        }
        /**
         * TODO 10 : ตรวจว่าจานเก็บเต็มพื้นที่ความจุที่มีให้หรือไม่
         * ตรวจว่ากองจานเต็มความจุ(capacity)หรือไม่
         */
        public boolean isFull(){
            checkRep();
            return plates.size() == capacity;
        }
      /**
       * TODO 11 : ค้นหาหรือตรวจว่ามีลายจานอยู่หรือไม่
       * ตรวจว่ามีจานลาย/ชื่อนี้อยู่ในกองหรือไม่(ไม่ว่าจะอยู่ในตำแหน่งใด)
       */
      public boolean contains(String plate){
        checkRep();
        return plates.contains(plate);
      }

            // ===== Producer =====//
/**
 * TODO 12 : นำจานลายเดิมทุกอย่างไปไว้อีกที่เก็บหนึ่ง
     * ทำการสร้างจานโดยที่มีองค์ประกอบเดิมทุกอย่าง
     * ในการสร้างครั้งนี้จะไม่ส่งผลกระทบกับข้อมูลเดิม
     * 
     * @return BoundedStack ที่จัดเก็บจานใหม่ที่มีขนาดและลำดับเหมือนเดิม
     */
    public BoundedStack copy() {
        checkRep();
        return new BoundedStack(this.capacity, this.plates);
    }


      @Override
      public String toString(){
        //แสดงจากด้านบนไปล่างสุด
        List<String> topToBottom = new ArrayList<>(plates);
        Collections.reverse(topToBottom);
        return topToBottom.toString();
      }
    


}