package com.wanmait.exam.manageController;

import com.wanmait.exam.mapper.ModelMapper;
import com.wanmait.exam.util.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("manage/model")
public class ManageModelController {
    @Resource
    private ModelMapper modelMapper;

//    @GetMapping("list")
//    public AjaxResult list(){
//        return AjaxResult.success(modelMapper.selectList());
//    }
}
