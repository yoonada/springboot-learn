package com.yoona.join.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yoona.join.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 元数据管理-元数据分组表
 * </p>
 *
 * @author yoonada
 * @since 2023-04-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("st_metadata_group")
@ApiModel(value="MetadataGroup对象", description="元数据管理-元数据分组表")
public class MetadataGroup extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "组名")
    private String metadataGroupName;


}
