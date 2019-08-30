package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.CodeEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 二维码管理
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:10:41
 */
public interface CodeService extends IService<CodeEntity> {

    PageUtils queryPage(Map<String, Object> params);


}

