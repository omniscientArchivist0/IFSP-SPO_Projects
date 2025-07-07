package controller;

import object.BaseTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseController {

    public static final String CONNECTION_STRING = "jdbc:sqlite:sample.db";
    public static final String INITIAL_TABLE = "CREATE TABLE IF NOT EXISTS tasks (id integer PRIMARY KEY, task text NOT NULL, task_change_date text NOT NULL), is_completed boolean NOT NULL";
    public static final String INSERT_TASK = "INSERT INTO tasks(task, task_change_date, is_completed) VALUES (?, ?, ?)";
    public static final String SELECT_TASK = "SELECT id, task, task_change_date, is_completed FROM tasks";

    record TaskRecord(int id, String task, String date, boolean is_completed) {
         TaskRecord(String task, String date, boolean is_completed) {
            this(0, task, date, is_completed);
        }
    }

    public static void setupDB() {
        try (var connection = DriverManager.getConnection(CONNECTION_STRING);
             var statement = connection.createStatement()) {
             statement.execute(INITIAL_TABLE);
             System.out.println("A tabela principal (tasks) foi criada.");
        }
             catch (SQLException e) {
                 System.out.printf("Falha ao criar tabelas %s%n", e.getMessage());
        }
    }

    public void searchTask() {

    }

    public void getTasks() {
        var result = new ArrayList<TaskRecord>();
    }


    public void getTask() {

    }
    public void updateTask() {

    }
    public void storeTask(BaseTask task, Connection connection) {
        var taskRecord = new TaskRecord(task.getText(), task.getDate().toString(), task.isCompleted());

        try (var statement = connection.prepareStatement(INSERT_TASK)) {
            statement.setString(1, taskRecord.task());
            statement.setString(2, taskRecord.date());
            statement.setBoolean(3, taskRecord.is_completed());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.printf("Falha ao inserir: %s%n", taskRecord);
            System.out.println(e.getMessage());
        }

    }
    /*
    public void removeTask() {

    }
    public void removeTask() {

    }
     */

}
