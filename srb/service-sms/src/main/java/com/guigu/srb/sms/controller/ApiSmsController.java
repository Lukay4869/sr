package com.guigu.srb.sms.controller;

import com.guigu.common.exception.Assert;
import com.guigu.common.result.R;
import com.guigu.common.result.ResponseEnum;
import com.guigu.common.util.RandomUtils;
import com.guigu.common.util.RegexValidateUtils;
import com.guigu.srb.sms.service.SmsService;
import com.guigu.srb.sms.util.SmsProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("/api/sms")
@Api(tags = "短信管理")
@CrossOrigin
@Slf4j
public class ApiSmsController {
    @Resource
    private SmsService smsService;
    @ApiOperation("获取短信验证码")
    @GetMapping("/send/{mobile}")
    public R send(
            @ApiParam(value = "手机号",required = true)
            @PathVariable String mobile
    ){
        Assert.isTrue(RegexValidateUtils.checkCellphone(mobile), ResponseEnum.MOBILE_ERROR);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", RandomUtils.getFourBitRandom());
        smsService.send(mobile, SmsProperties.TEMPLATE_CODE,map);
return R.ok().message("短信发送成功");
    }
}
