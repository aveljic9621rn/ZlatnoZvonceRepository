package view.fileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    public static List<String> getClanovi(){
        List<String> clanovi = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("src/resources/clanovi.txt"));
            while(sc.hasNext()){
                String line = sc.nextLine();
                String[] split = line.split(",");
                for(String s : split){
                    clanovi.add(s);

                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return clanovi;
    }
}
