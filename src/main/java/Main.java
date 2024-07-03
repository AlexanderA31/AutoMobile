import java.io.File;

public class Main {
    public static void main(String[] args){
        File app = new File("app\\Airbnb_v22.26_apkpure.com.apk");
        System.out.println("RUTA: " + app.getAbsolutePath().replace("\\", "/"));
    }
}
