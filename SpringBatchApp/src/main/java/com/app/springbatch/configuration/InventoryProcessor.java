package com.app.springbatch.configuration;

import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.springbatch.entity.Inventory;
import com.app.springbatch.entity.Product;
import com.app.springbatch.repository.InventoryRepo;
import com.app.springbatch.repository.ProductRepo;

public class InventoryProcessor implements ItemProcessor<Inventory, Inventory> {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private InventoryRepo inventoryRepo;

	@Override
	public Inventory process(Inventory item) throws Exception {
		Inventory newInv=null;

		System.out.println("item  :" + item);
		
		Long lInvId= item.getInventroyId();
		Optional<Inventory> inv=null;
		if(lInvId!=null) {
			inv = inventoryRepo.findById(lInvId);
		}
		
		Product invFeedproduct= item.getProduct();
		Long lProductId= invFeedproduct.getProductId();

		int qty= item.getQty();

		if(lInvId!=null && inv.isPresent()) {
			
			newInv=updateStockForItem(inv.get(),qty);
		
		}else {
			Product product=null;
			if(lProductId!=null) {
				Optional<Product> isProductPresent = productRepo.findById(lProductId);
				if(isProductPresent.isPresent()) {
					product=isProductPresent.get();
				}
				else {
					product= new Product();
					product.setProductId(lProductId);
					product.setDescription(invFeedproduct.getDescription());
					product.setProductName(invFeedproduct.getProductName());
				}

			}else {

				product= new Product();
				product.setDescription(item.getProduct().getDescription());
				product.setProductName(item.getProduct().getProductName());		
			}
			Product savedProduct = productRepo.save(product);
			
			newInv= new Inventory();
			newInv.setProduct(savedProduct);	
			newInv.setQty(item.getQty()!=null?item.getQty():0);
			
			if(newInv!=null)
			inventoryRepo.save(newInv);
		}
		
		return newInv;
	}

	private Inventory updateStockForItem(Inventory inventory, int qty) {

		inventory.setQty(qty);
		Inventory inv=inventoryRepo.save(inventory);

		return inv;
	}

}
