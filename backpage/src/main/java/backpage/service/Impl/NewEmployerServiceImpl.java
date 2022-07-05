package backpage.service.Impl;

import backpage.entity.NewEmployer;
import backpage.mapper.NewEmployerMapper;
import backpage.service.NewEmployerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class NewEmployerServiceImpl extends ServiceImpl<NewEmployerMapper, NewEmployer> implements NewEmployerService {
}
