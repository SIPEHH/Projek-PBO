/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Hafiz
 */

import view.Member;

/**
 *
 * @author Hafiz
 */
public class MemberRegular extends Member {
    @Override
    public String getTipe() {
        return "Regular";
    }

    @Override
    public double hitungTarif(int tambahJam) {
        return tambahJam * 4000.0; // Rp 4.000 per jam
    }
}
