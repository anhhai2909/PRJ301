/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author anhha
 */
public class Student {
    private String mahs;
    private String ten;
    private int gt;
    private Date dob;
    private String quequan;
    private String socccd;
    private String sdt;
    private String email;
    private String tenph;
    private String sdtph;
    private String malop;
    private String magv;

    public Student(String mahs, String ten, int gt, Date dob, String quequan, String socccd, String sdt, String email, String tenph, String sdtph, String malop, String magv) {
        this.mahs = mahs;
        this.ten = ten;
        this.gt = gt;
        this.dob = dob;
        this.quequan = quequan;
        this.socccd = socccd;
        this.sdt = sdt;
        this.email = email;
        this.tenph = tenph;
        this.sdtph = sdtph;
        this.malop = malop;
        this.magv = magv;
    }

    public String getMahs() {
        return mahs;
    }

    public void setMahs(String mahs) {
        this.mahs = mahs;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGt() {
        return gt;
    }

    public void setGt(int gt) {
        this.gt = gt;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getSocccd() {
        return socccd;
    }

    public void setSocccd(String socccd) {
        this.socccd = socccd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTenph() {
        return tenph;
    }

    public void setTenph(String tenph) {
        this.tenph = tenph;
    }

    public String getSdtph() {
        return sdtph;
    }

    public void setSdtph(String sdtph) {
        this.sdtph = sdtph;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getMagv() {
        return magv;
    }

    public void setMagv(String magv) {
        this.magv = magv;
    }

    @Override
    public String toString() {
        return "Student{" + "mahs=" + mahs + ", ten=" + ten + ", gt=" + gt + ", dob=" + dob + ", quequan=" + quequan + ", socccd=" + socccd + ", sdt=" + sdt + ", email=" + email + ", tenph=" + tenph + ", sdtph=" + sdtph + ", malop=" + malop + ", magv=" + magv + '}';
    }
    
}
