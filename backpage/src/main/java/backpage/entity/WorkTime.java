package backpage.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data //主要是为了提高代码简洁，省去set和get方法
@TableName("worktime")
public class WorkTime {
    private String starttime;
    private String endtime;

}
