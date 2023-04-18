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
 * 元数据管理-字段元数据
 * </p>
 *
 * @author yoonada
 * @since 2023-04-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("st_field_metadata")
@ApiModel(value="FieldMetadata对象", description="元数据管理-字段元数据")
public class FieldMetadata extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "元数据名称")
    private String metadataName;

    @ApiModelProperty(value = "字段名称")
    private String fieldName;

    @ApiModelProperty(value = "敏感度：1、公开；2、一般；3、重要；4、特殊")
    private Integer sensitivity;

    @ApiModelProperty(value = "元数据分类：1、技术元数据；2、业务元数据；3、管理元数据")
    private Integer metadataClassification;

    @ApiModelProperty(value = "数据类型：1、varchar；2、int；3、double；4、datatime")
    private Integer dataType;

    @ApiModelProperty(value = "数据长度")
    private Long dataLength;

    @ApiModelProperty(value = "是否主键：0、不是主键；1、是主键；默认为0")
    private Integer isPrimaryKey;

    @ApiModelProperty(value = "是否允许为空：0、不允许为空；1、允许为空；默认为0")
    private Integer isAllowNull;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "版本号")
    private String version;

    @ApiModelProperty(value = "是否发布：0、未发布；1、发布")
    private Integer isPublish;

    @ApiModelProperty(value = "元数据状态：0、未发布；1、发布；2、已归档；默认为0")
    private Integer metadataStatus;

    @ApiModelProperty(value = "元数据属性：1、字段元数据；2、表元数据；3、组合元数据；该表为1（字段元数据）")
    private Integer metadataProperty;


}
