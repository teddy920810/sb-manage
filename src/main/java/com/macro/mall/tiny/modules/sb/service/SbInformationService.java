package com.macro.mall.tiny.modules.sb.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.sb.model.SbInformation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author macro
 * @since 2021-01-05
 */
public interface SbInformationService extends IService<SbInformation> {

    /**
     * 添加
     */
    boolean create(SbInformation info);

    /**
     * 修改
     */
    boolean update(Long id, SbInformation info);

    /**
     * 批量删除
     */
    boolean delete(List<Long> ids);

    /**
     * 分页获取列表
     */
    Page<SbInformation> list(String keyword, Integer pageSize, Integer pageNum);

    SbInformation getByMac(String mac);

}
