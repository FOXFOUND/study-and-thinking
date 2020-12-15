package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class FormatPropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\dfcx_project\\csbu\\ms_dms\\source\\src\\main\\resources\\application.properties"));
         Enumeration<?> strings= properties.propertyNames();
        while (strings.hasMoreElements()){
            String s= strings.nextElement().toString();
            System.out.println(s);
            String tempString = "@"+s+"@";
            properties.setProperty(s,tempString);
        }
        properties.list(new PrintStream("./1.txt"));
    }
}
