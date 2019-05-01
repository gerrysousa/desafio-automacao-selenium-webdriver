package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {
    public static String getScreenshot(WebDriver driver)
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+"/output/Screenshot/"+System.currentTimeMillis()+".png";
        File destination=new File(path);

        try
        {
            FileUtils.copyFile(src, destination);
        } catch (IOException e)
        {
            System.out.println("Capture Failed "+e.getMessage());
        }
        return path;
    }

    public static String getDataString()
    {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String aux = new SimpleDateFormat("yyyy-MM-dd").format(date);

        return aux;
    }

    public static String getHoraString()
    {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String aux = new SimpleDateFormat("hhmm").format(date);

        return aux;
    }
}
