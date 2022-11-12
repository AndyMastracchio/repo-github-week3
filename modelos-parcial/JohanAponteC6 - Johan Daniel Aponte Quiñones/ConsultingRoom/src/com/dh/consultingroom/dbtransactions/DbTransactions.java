package com.dh.consultingroom.dbtransactions;

public enum DbTransactions {
    CREATE_TABLE_PATIENT("DROP TABLE IF EXISTS PATIENT; CREATE TABLE PATIENT "
            + "("
            + " ID INT PRIMARY KEY,"
            + " NAME varchar(100) NOT NULL, "
            + " LASTNAME varchar(100) NOT NULL,"
            + " MAIL varchar(100),"
            + " PHONE varchar(15),"
            + " DNI varchar(15) NOT NULL,"
            + " ROLE varchar(15) NOT NULL"
            + " );"),
    CREATE_TABLE_DENTIST("DROP TABLE IF EXISTS DENTIST; CREATE TABLE DENTIST "
            + "("
            + " ID INT PRIMARY KEY,"
            + " NAME varchar(100) NOT NULL, "
            + " LASTNAME varchar(100) NOT NULL,"
            + " MAIL varchar(100),"
            + " PHONE varchar(15),"
            + " DNI varchar(15) NOT NULL,"
            + " ROLE varchar(15) NOT NULL"
            + " );"),

    INSERT_IN_PATIENT("INSERT INTO PATIENT (ID, NAME, LASTNAME, MAIL, PHONE, DNI, ROLE) VALUES (?,?,?,?,?,?,?)"),
    UPDATE_IN_PATIENT("UPDATE PATIENT SET MAIL=? WHERE ID=?"),
    DELETE_PATIENT("DELETE FROM PATIENT WHERE ID=?"),
    SEARCH_ONE_PATIENT("SELECT * FROM PATIENT WHERE ID=?"),
    SEARCH_ALL_PATIENTS("SELECT * FROM PATIENT"),

    INSERT_IN_DENTIST("INSERT INTO DENTIST (ID, NAME, LASTNAME, MAIL, PHONE, DNI, ROLE) VALUES (?,?,?,?,?,?,?)"),
    UPDATE_IN_DENTIST("UPDATE DENTIST SET MAIL=? WHERE ID=?"),
    DELETE_DENTIST("DELETE FROM DENTIST WHERE ID=?"),
    SEARCH_ONE_DENTIST("SELECT * FROM DENTIST WHERE ID=?"),
    SEARCH_ALL_DENTIST("SELECT * FROM DENTIST");

    private String transactionType;
    DbTransactions(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
