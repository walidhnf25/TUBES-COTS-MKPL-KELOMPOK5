/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Test_Package;

import com.mycompany.restoran.Admin;
import com.mycompany.restoran.BahanBaku;
import com.mycompany.restoran.Menu;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.ArrayList;


/**
 *
 * @author haida
 */
public class AdminTest {
    private final ArrayList<BahanBaku> bahanBakuList = new ArrayList<>();
    private final ArrayList<Menu> menuList = new ArrayList<>();
    

    @Test
    public void testTambahBahanBaku() {
        // Arrange
        Admin admin = new Admin();
        BahanBaku bahanBaku = new BahanBaku("Bawang", 100);

        // Act
        admin.tambahBahanBaku(bahanBaku);

        // Assert
        assertTrue(admin.getBahanBakuList().contains(bahanBaku));
    }
    
    @Test
    public void testTambahMenu() {
        // Arrange
        Admin admin = new Admin();
        Menu menu = new Menu("Nasi Goreng", 15000);

        // Act
        admin.tambahMenu(menu);

        // Assert
        assertTrue(admin.getMenuList().contains(menu));
    }

    @Test
    public void testHapusMenu() {
        // Arrange
        Admin admin = new Admin();
        Menu menu = new Menu("Nasi Goreng", 15000);
        admin.tambahMenu(menu);

        // Act
        admin.hapusMenu(menu);

        // Assert
        assertFalse(admin.getMenuList().contains(menu));
    }

    @Test
    public void testUbahMenu() {
        // Arrange
        Admin admin = new Admin();
        Menu menu = new Menu("Nasi Goreng", 15000);
        admin.tambahMenu(menu);

        // Act
        admin.ubahMenu(menu, "Mie Goreng", 20000);

        // Assert
        assertEquals("Mie Goreng", menu.getNamaMenu());
        assertEquals(20000, menu.getHarga());
    }
   
    @Test
    public void testGetBahanBakuList(){
        Admin admin = new Admin();
        BahanBaku bahanBaku1 = new BahanBaku("Bawang", 100);
        BahanBaku bahanBaku2 = new BahanBaku("Kentang", 200);
        admin.tambahBahanBaku(bahanBaku1);
        admin.tambahBahanBaku(bahanBaku2);

        // Act
        ArrayList<BahanBaku> result = admin.getBahanBakuList();

        // Assert
        assertEquals(2, result.size());
        assertEquals(bahanBaku1, result.get(0));
        assertEquals(bahanBaku2, result.get(1));
    
    }
}