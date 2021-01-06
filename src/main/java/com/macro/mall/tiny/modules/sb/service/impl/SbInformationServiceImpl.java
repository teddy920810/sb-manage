package com.macro.mall.tiny.modules.sb.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.sb.model.SbInformation;
import com.macro.mall.tiny.modules.sb.mapper.SbInformationMapper;
import com.macro.mall.tiny.modules.sb.service.SbInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author macro
 * @since 2021-01-05
 */
@Service
public class SbInformationServiceImpl extends ServiceImpl<SbInformationMapper, SbInformation> implements SbInformationService {

    @Autowired
    private SbInformationMapper infoMapper;

    @Override
    public boolean create(SbInformation info) {
        info.setCreateTime(new Date());
        return save(info);
    }

    @Override
    public boolean update(Long id, SbInformation info) {
        info.setId(id);
        return updateById(info);
    }

    @Override
    public boolean delete(List<Long> ids) {
        boolean success = removeByIds(ids);
        return success;
    }

    @Override
    public Page<SbInformation> list(String keyword, Integer pageSize, Integer pageNum) {
        Page<SbInformation> page = new Page<>(pageNum,pageSize);
        QueryWrapper<SbInformation> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<SbInformation> lambda = wrapper.lambda();
        if(StrUtil.isNotEmpty(keyword)){
            lambda.like(SbInformation::getMac,keyword);
        }
        return page(page,wrapper);
    }

    @Override
    public SbInformation getByMac(String mac) {
        return infoMapper.getByMac(mac);
    }

}
