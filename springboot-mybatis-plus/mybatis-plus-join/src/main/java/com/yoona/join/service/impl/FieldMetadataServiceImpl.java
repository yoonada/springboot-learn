package com.yoona.join.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.yoona.join.domain.dto.TestQueryDTO;
import com.yoona.join.domain.entity.FieldMetadata;
import com.yoona.join.domain.entity.MetadataGroup;
import com.yoona.join.domain.entity.MetadataGroupAssociation;
import com.yoona.join.mapper.FieldMetadataMapper;
import com.yoona.join.service.FieldMetadataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 元数据管理-字段元数据 服务实现类
 * </p>
 *
 * @author yoonada
 * @since 2023-04-18
 */
@Service
@RequiredArgsConstructor
public class FieldMetadataServiceImpl extends ServiceImpl<FieldMetadataMapper, FieldMetadata> implements FieldMetadataService {

    private final FieldMetadataMapper fieldMetadataMapper;

    @Override
    public Object testLeftJoin() {
        MPJLambdaWrapper<FieldMetadata> mpjLambdaWrapper = new MPJLambdaWrapper<FieldMetadata>()
                .selectAll(FieldMetadata.class)
                .selectAs(FieldMetadata::getId, TestQueryDTO::getMetadataId)
                .selectAll(MetadataGroup.class)
                .selectAs(MetadataGroup::getId, TestQueryDTO::getMetadataGroupId)
                .leftJoin(MetadataGroupAssociation.class, MetadataGroupAssociation::getMetadataId, FieldMetadata::getId)
                .leftJoin(MetadataGroup.class, MetadataGroup::getId, MetadataGroupAssociation::getMetadataGroupId);
        return fieldMetadataMapper.selectJoinList(TestQueryDTO.class, mpjLambdaWrapper);
    }
}
