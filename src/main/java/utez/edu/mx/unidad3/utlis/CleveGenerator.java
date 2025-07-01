package utez.edu.mx.unidad3.utlis;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class CleveGenerator {
    public static String generateCedeClave(Long idCede){

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy" ,new Locale("es","MX"));
        String formattedDate = sdf.format(System.currentTimeMillis());
        String randomNumber = String.format("%04d", ThreadLocalRandom.current().nextInt(1, 10000) );

        return "C" + idCede + "-"+ formattedDate + "-"+ randomNumber;
    }

    public static void main(String[] args) {
        System.out.println(CleveGenerator.generateCedeClave(1L));
    }

    public static String generateWarehauseClave(String cedeClave, Long idwarehause){
        return null;
    }

}
