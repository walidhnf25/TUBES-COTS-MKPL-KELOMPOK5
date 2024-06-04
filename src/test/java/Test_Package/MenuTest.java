/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Test_Package;

import com.mycompany.restoran.Menu;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {

    @Test
    public void testGettersAndSetters() {
        // Arrange
        Menu menu = new Menu("Nasi Goreng", 15000);

        // Act and Assert
        assertEquals("Nasi Goreng", menu.getNamaMenu());
        assertEquals(15000, menu.getHarga());

        // Act
        menu.setNamaMenu("Mie Goreng");
        menu.setHarga(20000);

        // Assert
        assertEquals("Mie Goreng", menu.getNamaMenu());
        assertEquals(20000, menu.getHarga());
    }
}
