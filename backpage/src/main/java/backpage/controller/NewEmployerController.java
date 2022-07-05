package backpage.controller;

import backpage.entity.NewEmployer;
import backpage.service.NewEmployerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/newEmployer")
public class NewEmployerController {
    @Autowired
    private NewEmployerService newEmployerService;
    @PostMapping("/update")
    public boolean update(@RequestBody NewEmployer newEmployer){
        QueryWrapper<NewEmployer> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("account",newEmployer.getAccount());
        return newEmployerService.update(newEmployer,queryWrapper);
    }
}
