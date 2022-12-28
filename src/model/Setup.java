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

    public static boolean getAge64PlusDiscount() {
        try (InputStream input = new FileInputStream("src/bestanden/settings.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            System.out.println("age64PlusDiscountSelected: " + prop.getProperty("age64PlusDiscountSelected"));
            return Boolean.parseBoolean(prop.getProperty("age64PlusDiscountSelected"));
        } catch (IOException ex) {
            ex.printStackTrace();
    }
        return false;
    }

    public static boolean getChristmasLeaveDiscount() {
        try (InputStream input = new FileInputStream("src/bestanden/settings.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            System.out.println("christmasLeaveDiscountSelected: " + prop.getProperty("christmasLeaveDiscountSelected"));
            return Boolean.parseBoolean(prop.getProperty("christmasLeaveDiscountSelected"));
        } catch (IOException ex) {
            ex.printStackTrace();
    }
        return false;
    }

    public static boolean getStudentDiscount() {
        try (InputStream input = new FileInputStream("src/bestanden/settings.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            System.out.println("studentDiscountSelected: " + prop.getProperty("studentDiscountSelected"));
            return Boolean.parseBoolean(prop.getProperty("studentDiscountSelected"));
        } catch (IOException ex) {
            ex.printStackTrace();
    }
        return false;
    }

    public static boolean getFrequentTravellerDiscount() {
        try (InputStream input = new FileInputStream("src/bestanden/settings.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            System.out.println("frequentTravellerDiscountSelected: " + prop.getProperty("frequentTravellerDiscountSelected"));
            return Boolean.parseBoolean(prop.getProperty("frequentTravellerDiscountSelected"));
        } catch (IOException ex) {
            ex.printStackTrace();
    }
        return false;
    }
}