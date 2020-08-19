package app.findbug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(" java -jar target/dgraph-1.0-SNAPSHOT.jar localhost 9080 x.gql minLen maxTimes");
        System.out.println("args is :");
        for (String arg : args) {
            System.out.println(arg);
        }
        DGraphService ds = new DGraphService();
        ds.setDgraphHost(args[0]);
        ds.setPort(Integer.parseInt(args[1]));
        try {
            String gql = Files.readAllLines(Paths.get(args[2])).stream().collect(Collectors.joining("\n"));
            System.out.println("GET GQL from " + args[2]);
            System.out.println(gql);
            String r = ds.response(gql);
            System.out.println("GET RESPONSE ");
            System.out.println(r);
            System.out.println("Length is " + r.length());
            Integer minLen = Integer.parseInt(args[3]);
            Integer maxTimes = Integer.parseInt(args[4]);
            int i = 0;
            while (i <= maxTimes) {
                String ri = ds.response(gql);
                System.out.println(ri);
                System.out.println("Response Length is " + ri.length());
                if (ri.length() < minLen) {
                    System.out.println("Find it !");
                    break;
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Over!");
    }
}
