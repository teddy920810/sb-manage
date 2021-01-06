package com.macro.mall.tiny.modules.sb.mapper;

import com.macro.mall.tiny.modules.sb.model.SbInformation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author macro
 * @since 2021-01-05
 */
public interface SbInformationMapper extends BaseMapper<SbInformation> {

    /**
     * 根据MAC获取
     */
    SbInformation getByMac(@Param("mac") String mac);

}
