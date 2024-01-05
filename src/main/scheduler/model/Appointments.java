package scheduler.model;

import scheduler.db.ConnectionManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Appointments {
    String appID;
    String patID;
    String carID;
    String vacID;
    Date Time;

    public Appointments() {}

    public Appointments(String ID, String patient, String caregiver, String vaccines, Date time) {
        this.appID = ID;
        patID = patient;
        carID = caregiver;
        vacID = vaccines;
        Time = time;
    }

    public void saveToDB() throws SQLException {
        ConnectionManager cm = new ConnectionManager();
        Connection con = cm.createConnection();
        String addAppointment = "INSERT INTO Appointments (appID, patID, carID, vacID, Time) VALUES (?, ?, ? ,? ,?)";
        try {
            PreparedStatement statement = con.prepareStatement(addAppointment);
            statement.setString(1, this.appID);
            statement.setString(2, this.patID);
            statement.setString(3, this.carID);
            statement.setString(4, this.vacID);
            statement.setDate(5, this.Time);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cm.closeConnection();
        }
    }
}