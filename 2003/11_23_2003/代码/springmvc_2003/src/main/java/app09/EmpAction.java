package app09;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping(value = "/emp")
public class EmpAction {

    //处理自定义对象
    @RequestMapping(value = "/beantojson")
    @ResponseBody
    public Emp beantojson() throws Exception{
        //创建Emp对象
        Emp emp = new Emp();
        //封装数据
        emp.setId(1);
        emp.setUsername("兴龙");
        emp.setSalary(7000D);
        emp.setHiredate(new Date());
        return emp;
    }

    //处理List集合对象
    @RequestMapping("/listbeantojson")
    @ResponseBody
    public List<Emp> list2json() throws Exception{
        //实例化集合对象
        List<Emp> empList = new ArrayList<>();
        //向集合中添加元素
        empList.add(new Emp(1,"昱霖",7000D,new Date()));
        empList.add(new Emp(2,"南洋",8000D,new Date()));
        empList.add(new Emp(3,"耘铭",9000D,new Date()));
        return empList;
    }

    //处理Map集合
    @RequestMapping(value = "/maptojson")
    @ResponseBody
    public Map<String,Object> map2json() throws Exception{
        //实例化List集合对象
        List<Emp> empList = new ArrayList<>();
        //向集合中添加元素
        empList.add(new Emp(1,"晓亮",7000D,new Date()));
        empList.add(new Emp(2,"刘鉴",8000D,new Date()));
        empList.add(new Emp(3,"郑莹",9000D,new Date()));
        //创建Map集合对象
        Map<String,Object> map = new LinkedHashMap<>();
        //向map集合中添加元素 EasyUI分页
        map.put("total",empList.size());
        map.put("rows",empList);
        return map;
    }
}
