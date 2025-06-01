package com.example.warehouse.Mapper;

import com.example.warehouse.dto.request.BlockRequest;
import com.example.warehouse.dto.response.BlockResponse;
import com.example.warehouse.model.Block;
import org.springframework.stereotype.Component;

@Component
public class BlockMapper {

    public Block toEntity(BlockRequest source, Block target) {
        if (source != null && target != null) {
            target.setBlockType(source.type());
            target.setLength(source.length());
            target.setBredth(source.bredth());
            target.setHeight(source.height());
        }
        return target;
    }

    public BlockResponse toResponse(Block block) {
        if (block == null) return null;
        return new BlockResponse(
            block.getBlockId(),
            block.getBlockType(),
            block.getLength(),
            block.getBredth(),
            block.getHeight()
        );
    }
}
