package com.example.model;

import java.math.BigDecimal;
import java.util.Date;

public class SalesData {
    private String customer_Number;

    private String store_Number;

    private Date mtd_Date;

    private Integer department;

    private Integer invoice_type;

    private BigDecimal mtdAmount;

    private Date last_buying_date;

    public SalesData() {
    }

    public SalesData(String customer_Number, String store_Number, Date mtd_Date, Integer department, Integer invoice_type, BigDecimal mtdAmount, Date last_buying_date) {
        this.customer_Number = customer_Number;
        this.store_Number = store_Number;
        this.mtd_Date = mtd_Date;
        this.department = department;
        this.invoice_type = invoice_type;
        this.mtdAmount = mtdAmount;
        this.last_buying_date = last_buying_date;
    }

    public String getCustomer_Number() {
        return customer_Number;
    }

    public void setCustomer_Number(String customer_Number) {
        this.customer_Number = customer_Number;
    }

    public String getStore_Number() {
        return store_Number;
    }

    public void setStore_Number(String store_Number) {
        this.store_Number = store_Number;
    }

    public Date getMtd_Date() {
        return mtd_Date;
    }

    public void setMtd_Date(Date mtd_Date) {
        this.mtd_Date = mtd_Date;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getInvoice_type() {
        return invoice_type;
    }

    public void setInvoice_type(Integer invoice_type) {
        this.invoice_type = invoice_type;
    }

    public BigDecimal getMtdAmount() {
        return mtdAmount;
    }

    public void setMtdAmount(BigDecimal mtdAmount) {
        this.mtdAmount = mtdAmount;
    }

    public Date getLast_buying_date() {
        return last_buying_date;
    }

    public void setLast_buying_date(Date last_buying_date) {
        this.last_buying_date = last_buying_date;
    }
}
