package backpage.controller;


import backpage.entity.WorkTime;
import backpage.service.WorkTImeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/time")
public class WorkTimeController {
    @Autowired
    private WorkTImeService workTImeService;
    @PostMapping("/updateTime")
    public boolean updateTime(@RequestBody WorkTime workTime){
        WorkTime time=getWorkTime().get(0);
        QueryWrapper<WorkTime> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("starttime",time.getStarttime());
        workTImeService.remove(queryWrapper);
        return workTImeService.save(workTime);
//        System.out.println(workTime);
//        return true;
    }
    @GetMapping("/getWorkTime")
    public List<WorkTime> getWorkTime(){
        return workTImeService.list();
    }
}
