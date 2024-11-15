package com.app.springbatch.configuration;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

import com.app.springbatch.entity.Inventory;
import com.app.springbatch.entity.Product;

public class InventoryFieldSetMapper implements FieldSetMapper<Inventory> {

	
    @Override
    public Inventory mapFieldSet(FieldSet fieldSet) {
  
    	
    	String sProductId= fieldSet.readString("productId");
    	String sInvId= fieldSet.readString("inventroyId");

        Long lProdId=null;
        Long lInvId= null;
    	
        // Create a new Product object
        Product product = new Product();
        if(sProductId!=null && !sProductId.trim().isEmpty()) {
            product.setProductId(Long.parseLong(sProductId));
        }
        product.setProductName(fieldSet.readString("productName"));
        product.setDescription(fieldSet.readString("description"));

        // Create a new Inventory object
        Inventory inventory = new Inventory();
        if(sInvId!=null  && !sInvId.trim().isEmpty()) {
        	inventory.setInventroyId(Long.parseLong(sInvId));
        }
        inventory.setProduct(product);  // Set the product object in Inventory
        inventory.setQty(fieldSet.readInt("qty"));

        return inventory;
    }
}
