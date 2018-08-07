package sk.mh.shopping.datagenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            File filename = new File(String.format("shopping-data%s.csv", Long.toString(System.currentTimeMillis())));
            FileWriter fileWriter = new FileWriter(filename.getAbsolutePath(), true);
            ShoppingCartEvent.ShoppingCartEventBuilder builder = ShoppingCartEvent.builder();
            Random random = new Random(10000);
            for (int i = 0; i < 4000000; i++) {
                fileWriter.write(builder
                        .id(Integer.toString(i))
                        .storeId(String.valueOf(random.nextInt(20000)))
                        .customerId(String.valueOf(random.nextInt(20000)))
                        .sensorId(String.valueOf(random.nextInt(20000)))
                        .sensorMetadata(String.valueOf(random.nextInt(20000)))
                        .timestamp(System.currentTimeMillis())
                        .build().toString());
                fileWriter.write("\\n");

            }
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.flush();
            fileWriter.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
