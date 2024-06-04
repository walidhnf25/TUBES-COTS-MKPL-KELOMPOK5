/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Test_Package;

import com.mycompany.restoran.BahanBaku;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BahanBakuTest {

    @Test
    public void testGettersAndSetters() {
        // Arrange
        BahanBaku bahanBaku = new BahanBaku("Tepung", 5000);

        // Act and Assert
        assertEquals("Tepung", bahanBaku.getNamaBahan());
        assertEquals(5000, bahanBaku.getHarga());

        // Act
        bahanBaku.setNamaBahan("Gula");
        bahanBaku.setHarga(8000);

        // Assert
        assertEquals("Gula", bahanBaku.getNamaBahan());
        assertEquals(8000, bahanBaku.getHarga());
    }
}