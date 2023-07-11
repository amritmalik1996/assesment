package com.accenture.assesment.updateProduct.binding;

import java.util.List;

public class RequestType {
    List<ProductType> productTypeList;

    public List<ProductType> getProductTypeList() {
        return productTypeList;
    }

    public void setProductTypeList(List<ProductType> productTypeList) {
        this.productTypeList = productTypeList;
    }
}
