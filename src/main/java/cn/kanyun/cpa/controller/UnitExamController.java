package cn.kanyun.cpa.controller;

import cn.kanyun.cpa.pojo.CpaOption;
import cn.kanyun.cpa.pojo.CpaRepertory;
import cn.kanyun.cpa.pojo.CpaResult;
import cn.kanyun.cpa.service.IUnitExamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by KANYUN on 2017/3/18.
 */
@Controller
@RequestMapping("/unitExam")
public class UnitExamController {
    @Resource(name = IUnitExamService.SERVICE_NAME)
    private IUnitExamService unitExamService;

    @RequestMapping("/showUnitExam.do")
    @ResponseBody
    public CpaResult showUnitExam(String typeCode) {
        Object[] params = {typeCode};
        String where = "o.testType=? ";
        CpaResult result = this.unitExamService.getScrollData(-1, -1, where, params);
        if (result.getTotalCount() > 0) {
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            List<CpaRepertory> listcr = (List<CpaRepertory>) result.getData();
            for (CpaRepertory cr : listcr) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("stem", cr.getTestStem());
                map.put("cr_id", cr.getId());
                Set<CpaOption> setco = cr.getCpaOptions();
//                将Set集合转换为List集合
                List<CpaOption> listco = new ArrayList<CpaOption>();
                for (CpaOption co : setco) {
                    listco.add(co);
                }
//                将转换后的List集合，自定义排序，根据属性内的ABCD进行升序排列
                Collections.sort(listco, new Comparator<CpaOption>() {
                    @Override
                    public int compare(CpaOption o1, CpaOption o2) {
                        int sortResult = o1.getSelectData().compareTo(o2.getSelectData());
                        return sortResult;
                    }
                });
//                从排序后的List集合里取出选项内容，可以保证，他们的顺序不变
                List<String> listoptions = new ArrayList<String>();
                for (CpaOption co:listco){
                    listoptions.add(co.getOptionData());
                }
                map.put("options", listoptions);
                list.add(map);
            }
            result.setStatus(1);
            result.setData(list);
        } else {
            result.setStatus(0);
            result.setMsg("未获取到记录！");
        }
        return result;
    }
}