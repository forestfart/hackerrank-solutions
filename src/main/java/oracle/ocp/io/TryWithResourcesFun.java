package oracle.ocp.io;

import java.nio.file.Files;
import java.util.List;

public class TryWithResourcesFun implements AutoCloseable{
    int var;
    public void close() {}
    public TryWithResourcesFun copyObjectReference() {
        return this;
    }

    public static void main(String[] args) {
        TryWithResourcesFun tryWithResourcesFun = null;
        try (TryWithResourcesFun newFun = new TryWithResourcesFun()) {
            newFun.var = 100;
            tryWithResourcesFun = newFun.copyObjectReference();
        }
        System.out.println(tryWithResourcesFun.var);
    }
}

class TryWithResourcesFun2 implements AutoCloseable{
    public void close() throws Exception {
        throw new RuntimeException();
    }
    public TryWithResourcesFun2 copyObjectReference() {
        return this;
    }

    public static void main(String[] args) throws Exception{
        TryWithResourcesFun2 tryWithResourcesFun2 = null;
        try (TryWithResourcesFun2 newFun = new TryWithResourcesFun2()) {
            newFun.copyObjectReference();
        }
    }
}
class ImageScanner implements AutoCloseable {
    public void close () throws Exception {
        System.out.print ("Scanner closed.");
    }
    public void scanImage () throws Exception {
        System.out.print ("Scan.");
        throw new Exception("Unable to scan.");
    }
}
class ImagePrinter implements AutoCloseable {
    public void close () throws Exception {
        System.out.print ("Printer closed.");
    }
    public void printImage ()  {
        System.out.print("Print.");
    }

    public static void main(String[] args) {
        try (ImageScanner ir = new ImageScanner();
             ImagePrinter iw = new ImagePrinter())   {
            ir.scanImage();
            iw.printImage();
        }  catch (Exception e)  {
            System.out.print(e.getMessage());
        }
    }
}

class Resource implements AutoCloseable {

    public void close() throws Exception {
        System.out.println("Close-");
    }

    public void open(){
        System.out.println("Open-");
    }
}

class funFun {
    public static void main(String[] args) {
        // and given code fragment:
        Resource res1 = new Resource();

        try {
            res1.open();
            res1.close();
        } catch (Exception e) {
            System.out.println("Exception - 1");
        }

        try (Resource res2 = new Resource()) {	// line n1
            res1.open();
        } catch (Exception e) {
            System.out.println("Exception - 2");
        }
    }

}


