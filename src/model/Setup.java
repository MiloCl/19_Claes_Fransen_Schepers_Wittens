package model;

import java.io.*;
import java.util.Properties;

public class Setup {

    public static void setProperties(String format, String discount) {
        try (OutputStream output = new FileOutputStream("src/bestanden/settings.properties")) {
            Properties prop = new Properties();
            prop.setProperty("FileFormat", format);
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }


    public static String getFileFormat() {
        try (InputStream input = new FileInputStream("src/bestanden/settings.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            System.out.println("FileFormat: " + prop.getProperty("FileFormat"));
            return prop.getProperty("FileFormat");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void setFileFormat(String format) {
        try (OutputStream output = new FileOutputStream("src/bestanden/settings.properties")) {
            Properties prop = new Properties();
            prop.setProperty("FileFormat", format);
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static void saveDiscounts(boolean age64PlusDiscountSelected, boolean christmasLeaveDiscountSelected, boolean studentDiscountSelected, boolean frequentTravellerDiscountSelected) {
        try (OutputStream output = new FileOutputStream("src/bestanden/settings.properties")) {
            Properties prop = new Properties();
            prop.setProperty("age64PlusDiscountSelected", String.valueOf(age64PlusDiscountSelected));
            prop.setProperty("christmasLeaveDiscountSelected", String.valueOf(christmasLeaveDiscountSelected));
            prop.setProperty("studentDiscountSelected", String.valueOf(studentDiscountSelected));
            prop.setProperty("frequentTravellerDiscountSelected", String.valueOf(frequentTravellerDiscountSelected));
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static void saveSettings(String fileFormat, boolean age64PlusDiscountSelected, boolean christmasLeaveDiscountSelected, boolean studentDiscountSelected, boolean frequentTravellerDiscountSelected) {
        try (OutputStream output = new FileOutputStream("src/bestanden/settings.properties")) {
            Properties prop = new Properties();
            prop.setProperty("FileFormat", fileFormat);
            prop.setProperty("age64PlusDiscountSelected", String.valueOf(age64PlusDiscountSelected));
            prop.setProperty("christmasLeaveDiscountSelected", String.valueOf(christmasLeaveDiscountSelected));
            prop.setProperty("studentDiscountSelected", String.valueOf(studentDiscountSelected));
            prop.setProperty("frequentTravellerDiscountSelected", String.valueOf(frequentTravellerDiscountSelected));
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}