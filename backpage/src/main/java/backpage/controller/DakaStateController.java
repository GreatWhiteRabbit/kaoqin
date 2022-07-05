package backpage.controller;

import backpage.entity.DakaState;
import backpage.service.DakaStateService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dakaState")
public class DakaStateController {
    @Autowired
    private DakaStateService dakaStateService;
    @PostMapping("/addDakaState")
    public boolean addDakaState(@RequestBody DakaState dakaState){
        return dakaStateService.save(dakaState);
    }
    @GetMapping("/getAll")
    public List<DakaState> getAll(){
        return dakaStateService.list();
    }

    @GetMapping("/search")
    public List<DakaState> search(String count,String state){
        QueryWrapper<DakaState> queryWrapper=new QueryWrapper<>();
        if(!(count.equals(""))){
            queryWrapper.eq("count",count);
        }
        if(!(state.equals(""))){
            queryWrapper.eq("state",state);
        }
        return dakaStateService.list(queryWrapper);
    }
    @GetMapping("/getOverTime")
    public List<DakaState> getOverTime(String count){
        QueryWrapper<DakaState> queryWrapper=new QueryWrapper<>();
        if(!(count.equals(""))){
            queryWrapper.eq("count",count);
        }
        queryWrapper.eq("state","加班");
        return dakaStateService.list(queryWrapper);
    }
}
