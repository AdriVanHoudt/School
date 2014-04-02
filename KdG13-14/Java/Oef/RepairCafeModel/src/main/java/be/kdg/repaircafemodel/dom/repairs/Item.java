/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.kdg.repaircafemodel.dom.repairs;

/**
 *
 * @author wouter
 */
public class Item
{
    private String productName;
    private String brand;
    private String category;

    public Item()
    {
        this("","","");
    }
    
    /**
     * A thing that needs fixing. Characterized by it's 
     * product name, brand and category
     * @param productName 
     * @param brand
     * @param category 
     */
    public Item(String productName, String brand, String category)
    {
        this.productName = productName;
        this.brand = brand;
        this.category = category;
    }
    
    /**
     * Get product name of item
     * @return product name
     */
    public String getProductName()
    {
        return productName;
    }

    /**
     * Get brand of item
     * @return item brand name
     */
    public String getBrand()
    {
        return brand;
    }

    /**
     * Get category of item
     * @return item category
     */
    public String getCategory()
    {
        return category;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }
}
