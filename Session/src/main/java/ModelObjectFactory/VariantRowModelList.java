/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelObjectFactory;

/**
 *
 * @author IXL1KOR
 */
public class VariantRowModelList implements IVariantRowModelList {
    @Override
    public void addVariantRow(String data) {
        System.out.println("Added to variant row: " + data);
    }
}
