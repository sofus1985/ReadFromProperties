package Lombok;


import lombok.SneakyThrows;
import java.io.FileReader;

public class LombokExeption {

    @SneakyThrows

    public void  file()  {

        FileReader fileReader = new FileReader("");
    }


    public static void main(String[] args) {
        LombokExeption lombokExeption = new LombokExeption();
        lombokExeption.file();
    }
}
