/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Test_Package;

import com.mycompany.restoran.Admin;
import com.mycompany.restoran.BahanBaku;
import com.mycompany.restoran.Kasir;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class KasirTest {

    private Admin admin;
    private Kasir kasir;

    @BeforeEach
    public void setUp() {
        admin = new Admin();
        kasir = new Kasir(admin);
    }

    @Test
    public void testCatatTransaksi() {
        kasir.catatTransaksi("Nasi Goreng", 15000);
        kasir.catatTransaksi("Nasi Goreng", 15000);
        
        // Use reflection to access the private field
        HashMap<String, Integer> transaksiHarian = (HashMap<String, Integer>) 
            getPrivateField(kasir, "transaksiHarian");
        
        assertEquals(30000, transaksiHarian.get("Nasi Goreng"), 
                     "Total transaksi for Nasi Goreng should be 30000");
    }

    @Test
    public void testAkumulasiTransaksi() {
        kasir.catatTransaksi("Nasi Goreng", 15000);
        kasir.catatTransaksi("Nasi Goreng", 15000);
        
        BahanBaku bahanBaku1 = new BahanBaku("Gula", 5000);
        BahanBaku bahanBaku2 = new BahanBaku("Tepung", 10000);
        admin.tambahBahanBaku(bahanBaku1);
        admin.tambahBahanBaku(bahanBaku2);
        
        kasir.akumulasiTransaksi();
        
        ArrayList<HashMap<String, Integer>> transaksiBulanan = kasir.getTransaksiBulanan();
        assertEquals(1, transaksiBulanan.size(), 
                     "Transaksi bulanan should contain one entry");
        
        HashMap<String, Integer> transaksiHariIni = transaksiBulanan.get(0);
        assertTrue(transaksiHariIni.containsKey("Pendapatan Bersih"), 
                   "Transaksi hari ini should contain 'Pendapatan Bersih'");
        assertEquals(15000, transaksiHariIni.get("Pendapatan Bersih"), 
                     "Pendapatan Bersih should be 15000 after akumulasiTransaksi");
    }

    @Test
    public void testGetTransaksiBulanan() {
        kasir.catatTransaksi("Nasi Goreng", 15000);
        kasir.akumulasiTransaksi();
        
        ArrayList<HashMap<String, Integer>> transaksiBulanan = kasir.getTransaksiBulanan();
        assertEquals(1, transaksiBulanan.size(), 
                     "Transaksi bulanan should contain one entry");
        
        HashMap<String, Integer> transaksiHariIni = transaksiBulanan.get(0);
        assertTrue(transaksiHariIni.containsKey("Pendapatan Bersih"), 
                   "Transaksi hari ini should contain 'Pendapatan Bersih'");
        assertEquals(15000, transaksiHariIni.get("Pendapatan Bersih"), 
                     "Pendapatan Bersih should be 15000 after akumulasiTransaksi");
    }

    // Helper method to access private fields for testing purposes
    private Object getPrivateField(Object instance, String fieldName) {
        try {
            java.lang.reflect.Field field = instance.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(instance);
        } catch (Exception e) {
            throw new RuntimeException("Failed to access private field", e);
        }
    }
}
