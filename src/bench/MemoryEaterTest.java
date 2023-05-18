package bench;
import java.util.Vector;



public class MemoryEaterTest implements IBenchmark{

    static int count = 0;
    public void run(){

        Vector v = new Vector();

        while (true) {
            try {
                count++;
                byte b[] = new byte[4*1048576];
                v.add(b);

            } catch(OutOfMemoryError e){
                try{
                    System.out.println("\nProgram has reached "+ count + " iterations");
                } catch(OutOfMemoryError f){
                    ;
                }
                break;
            }
        }
    }

    public int getIterations(){
        return count;
    }

    public void run(Object ... params) {

    }

    public void initialize(Object ... params){

    }

    public void clean(){

    }

    public void cancel(){

    }
}
