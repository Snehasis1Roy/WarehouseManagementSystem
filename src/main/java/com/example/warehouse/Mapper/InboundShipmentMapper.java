package com.example.warehouse.Mapper;

import com.example.warehouse.dto.request.InboundShipmentRequest;
import com.example.warehouse.dto.request.ProductRequest;
import com.example.warehouse.dto.response.InboundShipmentResponse;
import com.example.warehouse.dto.response.ProductResponse;
import com.example.warehouse.model.InboundShipment;
import com.example.warehouse.model.Product;
import org.springframework.stereotype.Component;

@Component
public class InboundShipmentMapper {

    public InboundShipment toEntity(InboundShipmentRequest source, InboundShipment target) {
        Product product = productToEntity(source.product());
        target.setSellerId(source.sellerId());
        target.setProduct(product);
        target.setStatus(source.status());
        target.setQuantity(source.quantity());

        return target;
    }

    public InboundShipmentResponse toResponse(InboundShipment inboundShipment) {
        return new InboundShipmentResponse(
                inboundShipment.getShipmentId(),
                inboundShipment.getProduct(),
                inboundShipment.getSellerId(),
                inboundShipment.getStatus(),
                inboundShipment.getQuantity()
        );
    }
    public Product productToEntity(ProductRequest request) {
        Product product = new Product();
        product.setProductId(request.productId());
        product.setTitle(request.title());
        product.setPrice(request.price());
        product.setMaterial(request.material());
        product.setLength(request.length());
        product.setCareInstruction(request.careInstruction());
        product.setBreadth(request.breadth());
        product.setHeight(request.height());
        product.setWeight(request.weight());
        return product;
    }

    public ProductResponse productToResponse(Product product) {
        return new ProductResponse(
                product.getTitle(),
                product.getWeight(),
                product.getHeight(),
                product.getLength(),
                product.getMaterial(),
                product.getPrice(),
                product.getCareInstruction(),
                product.getBreadth()
        );
    }
}
