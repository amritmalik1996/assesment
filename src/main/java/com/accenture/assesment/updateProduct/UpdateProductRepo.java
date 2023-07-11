package com.accenture.assesment.updateProduct;

import com.accenture.assesment.updateProduct.binding.ProductType;
import com.accenture.assesment.updateProduct.binding.RequestType;
import com.accenture.assesment.updateProduct.binding.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateProductRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public StatusType updateProduct(ProductType productType){
        int id = getId(productType);
        StatusType statusType = new StatusType();
        if(id==0){
            statusType = new StatusType();
            statusType.setStatusCd(3);
            statusType.setStatusDesc("Product not available");
            statusType.setId(id);
        }
        else{
            jdbcTemplate.update("UPDATE Product SET QUANTITY = ? WHERE ID=?",
                   productType.getQuantity(), id);
            statusType.setStatusCd(1);
            statusType.setStatusDesc("Product quantity with Product Id: "+id+" updated by Quantity: "
                    +productType.getQuantity());
            statusType.setId(id);
        }
        return statusType;
    }

    private Integer getId(ProductType requestType){
        try {
            return jdbcTemplate.queryForObject("SELECT ID FROM Product WHERE ID=? ", Integer.class,
                    requestType.getId());
        }
        catch(EmptyResultDataAccessException e){
            return 0;
        }
    }
}
