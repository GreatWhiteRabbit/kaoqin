package backpage.service.Impl;

import backpage.entity.DakaState;
import backpage.mapper.DakaStateMapper;
import backpage.service.DakaStateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DakaStateServiceImpl extends ServiceImpl<DakaStateMapper, DakaState> implements DakaStateService {
}
