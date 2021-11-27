package app09;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/emp")
public class EmpAction {

    //对象转JSON
    @RequestMapping(value = "/beantojson")
    @ResponseBody
    public Emp beantojson() throws Exception{
        //创建员工对象
        Emp emp = new Emp();
        //封装数据
        emp.setId(1);
        emp.setUsername("郝月");
        emp.setSalary(7000D);
        emp.setHiredate(new Date());
        return emp;
    }

    //List转JSON
    @RequestMapping("/listbeantojson")
    @ResponseBody
    public List list2json() throws Exception{
        //实例化集合对象
        List<Emp> empList = new ArrayList<>();
        //向集合中添加元素
        empList.add(new Emp(1,"继达",7000D,new Date()));
        empList.add(new Emp(2,"施迪",8000D,new Date()));
        empList.add(new Emp(3,"明昊",9000D,new Date()));
        return empList;
    }

    //Map转JSON
    @RequestMapping("/maptojson")
    @ResponseBody
    public Map<String,Object> map2json() throws Exception{
        //实例化List集合对象
        List<Emp> empList = new ArrayList<>();
        //向集合中添加元素
        empList.add(new Emp(1,"美楠",7000D,new Date()));
        empList.add(new Emp(2,"国俊",8000D,new Date()));
        empList.add(new Emp(3,"宏达",9000D,new Date()));
        //实例化Map集合对象
        Map<String,Object> map = new LinkedHashMap<>();
        //向集合中添加元素（模拟Easy UI前端框架的分页）
        map.put("total",empList.size());
        map.put("rows",empList);
        return map;
    }
}
