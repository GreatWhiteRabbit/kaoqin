package backpage.service.Impl;

import backpage.entity.WorkTime;
import backpage.mapper.WorkTimeMapper;
import backpage.service.WorkTImeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class WorkTimeServiceImpl extends ServiceImpl<WorkTimeMapper, WorkTime> implements WorkTImeService{
}
