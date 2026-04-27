/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import view.Member;

/**
 *
 * @author Hafiz
 */
public class MemberVIP extends Member {
    @Override
    public String getTipe() {
        return "VIP";
    }

    @Override
    public double hitungTarif(int tambahJam) {
        return tambahJam * 7000.0; // Rp 7.000 per jam
    }
}