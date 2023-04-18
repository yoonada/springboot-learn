package com.yoona.join.controller;


import com.yoona.join.service.FieldMetadataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * <p>
 * 元数据管理-字段元数据 前端控制器
 * </p>
 *
 * @author yoonada
 * @since 2023-04-18
 */
@RestController
@RequestMapping("/fieldMetadata")
@RequiredArgsConstructor
public class FieldMetadataController {

    private final FieldMetadataService fieldMetadataService;

    @GetMapping("/testLeftJoin")
    public Object testLeftJoin(){
        return fieldMetadataService.testLeftJoin();
    }


}

