/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cse.mbstu.nahid_riaj.healthindexcalculatorwithfederatedlearning;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;




public class HealthIndexCalculatorWithFederatedLearning {
    private int id;
     private String name;
    private double age;
    private double bmr;
    private double bmi;
    private String height;  // Storing height as a String (e.g., "5'8\"")
    private double weight;
    private String gender;
    private double needCalorie;
    private double avgBloodSugar;
    private double hdl;
    private double ldl;
    private double triglycerides;
    private double cholesterolRatio;
    private double systolic;
    private double diastolic;
    private double pulsePressure;
    private double meanArterialPressure;

    // Getters and Setters for all fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
    public double getId() {
        return id;
    }

    public void setId(int id) {
        this.id = (int) id;
    }

    public double getBmr() {
        return bmr;
    }

    public void setBmr(double bmr) {
        this.bmr = bmr;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public String getHeightString() { // Rename this method
        return height;
    }

    public void setHeight(String height) {
        this.height = height;

    }

    public double getWeight() {
        System.out.printf("%f\n", weight);
        return weight;
    }

    public void setWeight(double w) {
        this.weight = w;
        System.out.printf("%f\n Nahid", weight);

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getNeedCalorie() {
        return needCalorie;
    }

    public void setNeedCalorie(double needCalorie) {
        this.needCalorie = needCalorie;
    }

    public double getAvgBloodSugar() {
        return avgBloodSugar;
    }

    public void setAvgBloodSugar(double avgBloodSugar) {
        this.avgBloodSugar = avgBloodSugar;
    }

    public double getHdl() {
        return hdl;
    }

    public void setHdl(double hdl) {
        this.hdl = hdl;
    }

    public double getLdl() {
        return ldl;
    }

    public void setLdl(double ldl) {
        this.ldl = ldl;
    }

    public double getTriglycerides() {
        return triglycerides;
    }

    public void setTriglycerides(double triglycerides) {
        this.triglycerides = triglycerides;
    }

    public double getCholesterolRatio() {
        return cholesterolRatio;
    }

    public void setCholesterolRatio(double cholesterolRatio) {
        this.cholesterolRatio = cholesterolRatio;
    }

    public double getSystolic() {
        return systolic;
    }

    public void setSystolic(double systolic) {
        this.systolic = systolic;
    }

    public double getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(double diastolic) {
        this.diastolic = diastolic;
    }

    public double getPulsePressure() {
        return pulsePressure;
    }

    public void setPulsePressure(double pulsePressure) {
        this.pulsePressure = pulsePressure;
    }

    public double getMeanArterialPressure() {
        return meanArterialPressure;
    }

    public void setMeanArterialPressure(double meanArterialPressure) {
        this.meanArterialPressure = meanArterialPressure;
    }
   public class DatabaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/health_index";
    private static final String user = "root";
    private static final String password = "N@h!dr!@j";

    public static Connection ConnectDb() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return null;
        }
    }
}
public static void insertBMRData(
        int id,
        String name,
        double age,
        String height,
        double weight,
        double bmr,
        double caloriesNeeded,
        String gender,
        Date date) {

    // SQL query to insert data
    String insertSQL = "INSERT INTO BMR_Table (id, name, age, height, weight, bmr, calories_needed, gender, date) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    // Try-with-resources to handle the database connection and statement
    try (Connection conn = DatabaseConnection.ConnectDb();
         PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

        // Set the values for the query
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setDouble(3, age);
        pstmt.setString(4, height); // Height as a string (e.g., "5ft 10in")
        pstmt.setDouble(5, weight);
        pstmt.setDouble(6, bmr);
        pstmt.setDouble(7, caloriesNeeded);
        pstmt.setString(8, gender);
        pstmt.setDate(9, date);

        // Execute the query
        int rowsInserted = pstmt.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("BMR data successfully inserted!");
        }

    } catch (SQLException e) {
        System.out.println("Error while inserting BMR data: " + e.getMessage());
    }
}

    
    
    public static void insertBMIData(int id, String name, String height, double weight, double bmi, Date date) {
        // SQL query to insert data
        String url = "jdbc:mysql://localhost:3306/health_index"; 
        String user = "root"; 
        String password = "N@h!dr!@j"; 

        String insertSQL = "INSERT INTO BMI_Table (id, name, height, weight, bmi, date) VALUES (?, ?, ?, ?, ?, ?)";

        // Try-with-resources block to handle database connection and insertion
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            // Set the values to be inserted into the query
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, height);
            pstmt.setDouble(4, weight);
            pstmt.setDouble(5, bmi);
               pstmt.setDate(6, date);

            // Execute the query (insert the data)
            int rowsInserted = pstmt.executeUpdate();
            
            if (rowsInserted > 0) {
                System.out.println("Data successfully inserted!");
            }

        } catch (SQLException e) {
            System.out.println("Error while inserting data: " + e.getMessage());
        }
    }
public static void insertBloodPressureData(
        int id, String name, double systolic, double diastolic, double pulsePressure, double meanArterialPressure, LocalDate date) {

    // SQL query to insert data
    String insertSQL = "INSERT INTO blood_pressure_data (id, name, systolic, diastolic, pulse_pressure, mean_arterial_pressure, date) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?)";

    // Try-with-resources to handle the database connection and statement
    try (Connection conn = DatabaseConnection.ConnectDb();
         PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

        // Set the values for the query
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setDouble(3, systolic);
        pstmt.setDouble(4, diastolic);
        pstmt.setDouble(5, pulsePressure);
        pstmt.setDouble(6, meanArterialPressure);
        pstmt.setDate(7, java.sql.Date.valueOf(date)); // Convert LocalDate to java.sql.Date

        // Execute the query
        int rowsInserted = pstmt.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("Blood pressure data successfully inserted!");
        }

    } catch (SQLException e) {
        System.err.println("Error while inserting blood pressure data: " + e.getMessage());
    }
}


public void insertBloodSuger(int id, String name, double avgBloodSugar) {
    String query = "INSERT INTO blood_sugar_data (id, name, avg_blood_sugar) VALUES (?, ?, ?)";

    try (Connection conn = DatabaseConnection.ConnectDb();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setDouble(3, avgBloodSugar);
      

        int rowsInserted = pstmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Data successfully saved to database!");
        }
    } catch (SQLException e) {
        System.err.println("Error inserting data into database: " + e.getMessage());
    }
}
public void insertCholesterolData(int id, String name, double HDL, double LDL, double triglycerides, double totalCholesterol, double cholesterolRatio) {
    String query = "INSERT INTO cholesterol_data (id, name, HDL, LDL, triglycerides, total_cholesterol, cholesterol_ratio) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = DatabaseConnection.ConnectDb();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setDouble(3, HDL);
        pstmt.setDouble(4, LDL);
        pstmt.setDouble(5, triglycerides);
        pstmt.setDouble(6, totalCholesterol);
        pstmt.setDouble(7, cholesterolRatio);
   

        int rowsInserted = pstmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Cholesterol data successfully saved to database!");
        }
    } catch (SQLException e) {
        System.err.println("Error inserting cholesterol data into database: " + e.getMessage());
    }
}


    // Method to save health data to the database
    public void saveToDatabase() {
        String url = "jdbc:mysql://localhost:3306/health_index"; 
        String user = "root"; 
        String password = "N@h!dr!@j"; 

       String query = "INSERT INTO health_data (id,name, age, bmr, bmi, height, weight, gender, need_calorie, avg_blood_sugar, hdl, ldl, triglycerides, cholesterol_ratio, systolic, diastolic, pulse_pressure, mean_arterial_pressure) "
            + "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "
            + "ON DUPLICATE KEY UPDATE "
            + "age = COALESCE(NULLIF(VALUES(age), ''), age), "
            + "bmr = COALESCE(NULLIF(VALUES(bmr), ''), bmr), "
            + "bmi = COALESCE(NULLIF(VALUES(bmi), ''), bmi), "
            + "height = COALESCE(NULLIF(VALUES(height), ''), height), "
            + "weight = COALESCE(NULLIF(VALUES(weight), ''), weight), "
            + "gender = COALESCE(NULLIF(VALUES(gender), ''), gender), "
            + "need_calorie = COALESCE(NULLIF(VALUES(need_calorie), ''), need_calorie), "
            + "avg_blood_sugar = COALESCE(NULLIF(VALUES(avg_blood_sugar), ''), avg_blood_sugar), "
            + "hdl = COALESCE(NULLIF(VALUES(hdl), ''), hdl), "
            + "ldl = COALESCE(NULLIF(VALUES(ldl), ''), ldl), "
            + "triglycerides = COALESCE(NULLIF(VALUES(triglycerides), ''), triglycerides), "
            + "cholesterol_ratio = COALESCE(NULLIF(VALUES(cholesterol_ratio), ''), cholesterol_ratio), "
            + "systolic = COALESCE(NULLIF(VALUES(systolic), ''), systolic), "
            + "diastolic = COALESCE(NULLIF(VALUES(diastolic), ''), diastolic), "
            + "pulse_pressure = COALESCE(NULLIF(VALUES(pulse_pressure), ''), pulse_pressure), "
            + "mean_arterial_pressure = COALESCE(NULLIF(VALUES(mean_arterial_pressure), ''), mean_arterial_pressure)";

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, age);
            pstmt.setDouble(4, bmr);
            pstmt.setDouble(5, bmi);
            pstmt.setString(6, height);
            pstmt.setDouble(7, weight);
            pstmt.setString(8, gender);
            pstmt.setDouble(9, needCalorie);
            pstmt.setDouble(10, avgBloodSugar);
            pstmt.setDouble(11, hdl);
            pstmt.setDouble(12, ldl);
            pstmt.setDouble(13, triglycerides);
            pstmt.setDouble(14, cholesterolRatio);
            pstmt.setDouble(15, systolic);
            pstmt.setDouble(16, diastolic);
            pstmt.setDouble(17, pulsePressure);
            pstmt.setDouble(18, meanArterialPressure);

            pstmt.executeUpdate();
            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
      // HealthIndexCalculatorWithFederatedLearning calculator = new HealthIndexCalculatorWithFederatedLearning();
      Login LoginFrame =new Login();
      LoginFrame.setVisible(true);
      LoginFrame.pack();
      LoginFrame.setLocationRelativeTo(null);
    }
}

    
  

